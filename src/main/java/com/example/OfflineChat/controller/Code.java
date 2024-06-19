package com.example.OfflineChat.controller;
import com.example.OfflineChat.Model.Conersation;
import com.example.OfflineChat.Model.Seasson;
import com.example.OfflineChat.Service.SeasonService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;


 @Setter
 class Res {
     // Getters and Setters
     @Getter
     private String userId;
    @Getter
    private String prompt;

     private String seassonId;


     public String getSessionId() {
         return seassonId;
     }

     public void setSessionId(String sessionId) {
         this.seassonId = sessionId;
     }

     @Override
     public String toString() {
         return "Res{" +
                 "user_id=" + userId +
                 ", prompt='" + prompt + '\'' +
                 ", seassonId='" + seassonId + '\'' +
                 '}';
     }
 }




@RestController
public class Code {
    private final ChatModel chatModel ;
    private final SeasonService seasonService;
    private String prompt;
    private String sessionId;
    private Seasson seasson;


    @Autowired
    public Code(ChatModel chatModel, SeasonService seasonService) {
        this.chatModel = chatModel;
        this.seasonService = seasonService;
        this.prompt = "";
        this.sessionId = "";
    }

    @RequestMapping(value = "/ai", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:5173")

    public ResponseEntity<?> getResponse(@RequestBody Res message) {
        this.prompt = message.getPrompt();

            if(message.getSessionId() != null && !message.getSessionId().isEmpty()) {
            seasson = seasonService.getSeasson(message.getSessionId());
                System.out.println("season is found ");
        }

       else if(message.getUserId() != null) {
           seasson = seasonService.createSeasson(message.getUserId());
           System.out.println("season is created ");
        }


        if(seasson != null) this.sessionId = seasson.getId();
        else this.sessionId = "";

        sse();
        return new ResponseEntity<>(sessionId, HttpStatus.OK);
    }



    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "http://localhost:5173")
    public Flux<ChatResponse> sse() {

        System.out.println("Seassion id ");
        System.out.println(this.sessionId);

        var User = new UserMessage(this.prompt);
        Prompt prompt = new Prompt(List.of(User));
        Flux<ChatResponse> c =  chatModel.stream(prompt);
        List<String> responses = new ArrayList<>();

        return c
                .doOnComplete(() -> System.out.println("Completed"))
                .doOnEach(chatResponseSignal -> {
                    if(chatResponseSignal.get() != null) {
                        responses.add (chatResponseSignal.get().getResult().getOutput().getContent());
                    }
                })
                .doOnTerminate(() -> {
                   String s = "";
                   for(int i= 0; i< responses.size(); i++) {
                       s+= responses.get(i);
                   }
                   seasonService.addConversation(sessionId, new Conersation(this.prompt,s));
                });
    }


    @PostMapping(value = "/history")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> getHistory(@RequestBody Res r) {
        String userid = r.getUserId();
        System.out.println("History User id " + userid);
        if(userid == null || userid.isEmpty() )  return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);

        List<Seasson> seassons = seasonService.getAllSeassons(userid);

        if(!seassons.isEmpty()) return  new ResponseEntity<>(seassons,HttpStatus.OK);

         return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }
}
