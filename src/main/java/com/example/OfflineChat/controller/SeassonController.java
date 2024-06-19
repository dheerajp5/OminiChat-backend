package com.example.OfflineChat.controller;
import com.example.OfflineChat.Model.Seasson;
import com.example.OfflineChat.Service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;


public class SeassonController {
    @Autowired
    private SeasonService seasson;

    public SeassonController(SeasonService seasson) {
        this.seasson = seasson;
    }

    public SeassonController() {
    }

    public Seasson seassonHandler(Seasson s) {

        if(s.getId() == null || s.getId().isEmpty())
            if(s.getUserId().isEmpty()) return  null;

            else if(!s.getUserId().isEmpty()) {
                return seasson.createSeasson(s.getUserId());
            }

        return  seasson.getSeasson(s.getId());
    }


}
