package com.codegym.case_study_modul_4.model.dto;

public class OrderDetailRequestDto {
    private String productId;

    private String quantity;

    public OrderDetailRequestDto() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
