package com.example.OfflineChat.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.OfflineChat.Model.Seasson;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends MongoRepository<Seasson, String> {

    Optional<List<Seasson>> findAllByUserId(String userId);
}
