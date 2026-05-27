package com.wzamz.rag.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.stereotype.Service;

@Service
public class LlmService {

    private final ChatLanguageModel model;

    public LlmService(ChatLanguageModel model) {
        this.model = model;
    }

    public String generateInsight(String prompt) {
        return model.generate(prompt);
    }
}
