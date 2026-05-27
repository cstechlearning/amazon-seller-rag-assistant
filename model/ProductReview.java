package com.wzamz.rag.model;

public class ProductReview {

    private String productId;
    private String reviewText;

    public ProductReview() {
    }

    public ProductReview(String productId, String reviewText) {
        this.productId = productId;
        this.reviewText = reviewText;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
