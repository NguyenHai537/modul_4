package com.codegym.model;

public class ProductSearch {

    private String keyword;

    public ProductSearch(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
