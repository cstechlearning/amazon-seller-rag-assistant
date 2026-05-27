package com.wzamz.rag.controller;

import com.wzamz.rag.service.InsightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insights")
public class InsightController {

    private final InsightService insightService;

    public InsightController(InsightService insightService) {
        this.insightService = insightService;
    }

    @GetMapping
    public String generateInsight(
            @RequestParam String question
    ) {
        return insightService.generateSellerInsight(question);
    }
}
