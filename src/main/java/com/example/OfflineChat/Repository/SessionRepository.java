package com.example.OfflineChat.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.OfflineChat.Model.Seasson;

import java.util.List;

public interface SessionRepository extends MongoRepository<Seasson, String> {

    List<Seasson> findAllByUserId(String userId);
}
