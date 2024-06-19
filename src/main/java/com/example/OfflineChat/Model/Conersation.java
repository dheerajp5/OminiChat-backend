package com.example.OfflineChat.Model;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class Conersation {
    @MongoId
    private String id;
    private String prompt;
    private String aiRespone;
    private String systemPrompt;

    public Conersation(String prompt, String aiRespone, String systemPrompt) {
        this.prompt = prompt;
        this.aiRespone = aiRespone;
        this.systemPrompt = systemPrompt;
    }

    public Conersation(String prompt, String aiRespone) {
        this.prompt = prompt;
        this.aiRespone = aiRespone;

    }

    public Conersation() {
    }

    public String getPrompt() {
        return prompt;
    }

    public String getAiRespone() {
        return aiRespone;
    }

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setAiRespone(String aiRespone) {
        this.aiRespone = aiRespone;
    }

    public void setSystemPrompt(String systemPrompt) {
        this.systemPrompt = systemPrompt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
