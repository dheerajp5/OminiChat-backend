package com.example.OfflineChat.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "seassions")
public class Seasson {
    @Id
    private String id;
    private String userId;
    private List<Conersation> conversations;

    public Seasson(String userId) {
        this.userId = userId;
        this.conversations = new ArrayList<>();
    }
    public Seasson(String seassonId,String userId) {
        this.userId = userId;
        this.id = seassonId;
        this.conversations = new ArrayList<>();
    }



    public Seasson() {
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public List<Conersation> getConversations() {
        return conversations;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setConversations(List<Conersation> conversations) {
        this.conversations = conversations;
    }
}
