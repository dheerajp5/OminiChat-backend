package com.example.OfflineChat.controller;


import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;



@RestController
public class Code {
    private final OllamaChatModel chatModel ;


    public Code(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }
    @CrossOrigin("*")
//    @CrossOrigin("http://localhost:5173")
    @GetMapping("/ai")
    public Flux<ChatResponse> promptResponse(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        System.out.println(chatModel.getDefaultOptions().toString());
        return chatModel.stream(new Prompt(message));


    }
}
