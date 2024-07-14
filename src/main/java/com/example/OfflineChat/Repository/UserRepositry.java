package com.example.OfflineChat.Repository;

import com.example.OfflineChat.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UserRepositry extends MongoRepository<User,String> {
     Optional<User> findByName(String name);

     Optional<User> findByPhone(String phone);
}

