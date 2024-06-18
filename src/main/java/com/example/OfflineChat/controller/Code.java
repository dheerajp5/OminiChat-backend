package com.example.OfflineChat.controller;



import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;


 class Res {
    private String userId;
    private String prompt;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

     @Override
     public String toString() {
         return "Res{" +
                 "user_id=" + userId +
                 ", prompt='" + prompt + '\'' +
                 '}';
     }
 }




@RestController
public class Code {
    private final ChatModel chatModel ;
    private String prompt;

    public Code(ChatModel chatModel) {
        this.chatModel = chatModel;
    }
    @RequestMapping(value = "/ai", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:5173")

    public String getResponse(@RequestBody Res message) {
        this.prompt = message.getPrompt();
        System.out.println(message.toString());
        sse();
        return "done";
    }
    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "http://localhost:5173")
    public Flux<ChatResponse> sse() {
        var User = new UserMessage(this.prompt);
        Prompt prompt = new Prompt(List.of(User));
        return chatModel.stream(prompt);
    }

}
