package com.example.OfflineChat.Service;

import com.example.OfflineChat.Model.Seasson;
import com.example.OfflineChat.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeasonService {
    @Autowired
    private SessionRepository repository;



    public Seasson createSeasson(String userId) {
        Seasson newSeason = new Seasson(userId);
        Seasson createSeasson = repository.insert(newSeason);
        return createSeasson;
    }

    public Seasson getSeasson(String seassonId) {
        return  repository.findById(seassonId).get();
    }

    public List<Seasson> getAllSeassons(String userId) {
        return repository.findAllByUserId(userId);
    }

}
