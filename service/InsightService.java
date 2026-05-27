package com.wzamz.rag.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsightService {

    private final RetrievalService retrievalService;
    private final LlmService llmService;

    public InsightService(
            RetrievalService retrievalService,
            LlmService llmService
    ) {
        this.retrievalService = retrievalService;
        this.llmService = llmService;
    }

    public String generateSellerInsight(String question) {

        List<String> reviews =
                retrievalService.retrieveRelevantReviews(question);

        String context = String.join("\n", reviews);

        String prompt = """
                You are an Amazon seller analytics assistant.

                Based on the following reviews:

                %s

                Answer this seller question:

                %s
                """.formatted(context, question);

        return llmService.generateInsight(prompt);
    }
}
