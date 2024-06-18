package com.example.OfflineChat.Model;

public class Conersation {
    private String prompt;
    private String aiRespone;
    private String systemPrompt;

    public Conersation(String prompt, String aiRespone, String systemPrompt) {
        this.prompt = prompt;
        this.aiRespone = aiRespone;
        this.systemPrompt = systemPrompt;
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
}
