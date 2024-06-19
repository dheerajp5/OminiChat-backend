package com.example.OfflineChat.Service;

import com.example.OfflineChat.Model.Conersation;
import com.example.OfflineChat.Model.Seasson;
import com.example.OfflineChat.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {
    @Autowired
    private SessionRepository repository;

    @Autowired
    public SeasonService(SessionRepository repository) {
        this.repository = repository;
    }



    public Seasson createSeasson(String userId) {
        Seasson newSeason = new Seasson(userId);
        Seasson createSeasson = repository.insert(newSeason);
        return createSeasson;
    }

    public Seasson getSeasson(String seassonId) {
        var c =   repository.findById(seassonId);
        if(c.isPresent()) return c.get();
        return null;

    }

    public List<Seasson> getAllSeassons(String userId) {
        return repository.findAllByUserId(userId);
    }

    public Seasson addConversation(String seassonId, Conersation conversation) {
        Optional<Seasson> seassonOptional = repository.findById(seassonId);
        if (seassonOptional.isPresent()) {
            Seasson seasson = seassonOptional.get();
            seasson.getConversations().add(conversation);
            return repository.save(seasson);
        }
        return null; // Handle case when seasson is not found
    }

}
