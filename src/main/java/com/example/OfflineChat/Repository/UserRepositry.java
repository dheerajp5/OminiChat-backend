package com.example.OfflineChat.Repository;

import com.example.OfflineChat.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface UserRepositry extends MongoRepository<User,String> {
     User findByName(String name);

     User findByPhone(String phone);
}

