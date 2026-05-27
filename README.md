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

## 4. Example API Call

Run:
```
curl "http://localhost:8080/api/insights?question=Why are customers unhappy with my product?"
```

Example Retrieved Reviews
- Battery drains too quickly
- Charging cable stopped working after 3 days
- Product overheats during use

Example Generated Response
The most common customer complaints are related to battery life and charging reliability.
Customers also mention overheating issues, which may negatively impact product ratings and conversion rates.

## 5. Project Inside [Senior-Level]
Uses:

retrieval pipeline
embeddings
semantic search
prompt augmentation
OpenAI integration
vector database


Realistic Startup Constraints

This project intentionally avoids:
training custom LLMs
giant distributed ML infra
unrealistic GPU clusters

Instead:
open-source tooling
managed APIs
cost-effective stack

what startups do.

## Improvement

#### Architecture Diagram:

Amazon Reviews
      ↓
Embeddings
      ↓
pgvector
      ↓
Semantic Retrieval
      ↓
Prompt Augmentation
      ↓
OpenAI API
      ↓
Seller Insights

#### Features
Semantic review search
AI-generated seller insights
RAG pipeline
Spring Boot microservices
pgvector similarity search
OpenAI integration

Future Improvements Details

Phase 2
Redis caching
async ingestion jobs
Kafka event pipeline
review sentiment analysis
review summarization
dashboard UI
Phase 3
hybrid keyword + vector search
metadata filtering
streaming responses
multi-tenant seller support
observability / tracing

#### Positioning
This project positions tech as:

Backend Engineer with AI integration experience
Applied AI Engineer
AI Platform Engineer
RAG / LLM Infrastructure Engineer

NOT:

ML Research Scientist
Foundation Model Engineer

This distinction is important.
