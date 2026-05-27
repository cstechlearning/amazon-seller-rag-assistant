package com.wzamz.rag.service;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingSearchResult;
import dev.langchain4j.store.embedding.pgvector.PgVectorEmbeddingStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrievalService {

    private final PgVectorEmbeddingStore store;
    private final EmbeddingService embeddingService;

    public RetrievalService(EmbeddingService embeddingService) {

        this.embeddingService = embeddingService;

        this.store = PgVectorEmbeddingStore.builder()
                .host("localhost")
                .port(5432)
                .database("ragdb")
                .user("postgres")
                .password("password")
                .table("review_embeddings")
                .dimension(1536)
                .build();
    }

    public List<String> retrieveRelevantReviews(String query) {

        var queryEmbedding = embeddingService.generateEmbedding(query);

        EmbeddingSearchResult<TextSegment> result =
                store.search(
                        EmbeddingSearchRequest.builder()
                                .queryEmbedding(queryEmbedding)
                                .maxResults(3)
                                .build()
                );

        return result.matches()
                .stream()
                .map(EmbeddingMatch::embedded)
                .map(TextSegment::text)
                .collect(Collectors.toList());
    }
}
