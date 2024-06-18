package com.example.OfflineChat.Service;

import com.example.OfflineChat.Model.User;
import com.example.OfflineChat.Repository.UserRepositry;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserRepositry repositry;

    public UserService(UserRepositry repositry) {
        this.repositry = repositry;
    }

    public User addUser(User user) {
        return repositry.save(user);
    }

    public User getUserById(String id) {

        return repositry.findById(id).get();
    }

    public User findUserByPhoneNUmber(String phone) {
        User u =  repositry.findByPhone(phone);

        return u;
    }

    public User findUserByName(String name) {
       return repositry.findByName(name);


    }
}
