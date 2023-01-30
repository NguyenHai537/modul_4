package com.example.demo3.Model;

public class Demo {
    private String language;

    private String size;

    private boolean spams;

    private String description;

    public Demo() {
    }

    public Demo(String language, String size, boolean spams, String description) {
        this.language = language;
        this.size = size;
        this.spams = spams;
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
