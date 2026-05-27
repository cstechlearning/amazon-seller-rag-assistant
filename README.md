# amazon-seller-rag-assistant
A Java/Spring Boot RAG project for a small AI startup serving Amazon sellers.

## 1. Project Goal

This project is a lightweight Retrieval-Augmented Generation (RAG) platform used by an Amazon seller analytics startup.

The system:

ingests Amazon product reviews
generates embeddings
stores vectors in PostgreSQL + pgvector
performs semantic retrieval
augments prompts with retrieved reviews
generates AI-powered seller insights using OpenAI APIs

## 2. Tech Stack

Backend
- Java 21
- Spring Boot 3
- Maven

AI / RAG
- LangChain4j
- OpenAI API
- pgvector

Database
- PostgreSQL

Infra
- Docker
- Docker Compose

## 3. Repo Structure

```text
amazon-seller-rag-assistant/
│
├── README.md
├── docker-compose.yml
├── pom.xml
│
├── src/main/java/com/wzamz/rag/
│   ├── RagApplication.java
│   │
│   ├── controller/
│   │   └── InsightController.java
│   │
│   ├── service/
│   │   ├── EmbeddingService.java
│   │   ├── RetrievalService.java
│   │   ├── LlmService.java
│   │   └── InsightService.java
│   │
│   ├── model/
│   │   ├── ProductReview.java
│   │   └── InsightResponse.java
│   │
│   ├── repository/
│   │   └── ReviewRepository.java
│   │
│   └── config/
│       └── OpenAiConfig.java
│
└── src/main/resources/
    ├── application.yml
    └── schema.sql
```
