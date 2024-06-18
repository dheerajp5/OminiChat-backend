package com.example.OfflineChat.controller;
import com.example.OfflineChat.Model.Seasson;
import com.example.OfflineChat.Service.SeasonService;


public class SeassonController {

    private SeasonService seasson;

    public Seasson seassonHandler(Seasson s) {

        if(s.getId().isEmpty())
            if(s.getUserId().isEmpty()) return  null;

            else if(!s.getUserId().isEmpty()) {
                return seasson.createSeasson(s.getUserId());
            }

        return  seasson.getSeasson(s.getId());
    }


}
