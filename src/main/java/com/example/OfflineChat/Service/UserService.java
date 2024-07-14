package com.example.OfflineChat.Service;

import com.example.OfflineChat.Exceptions.CustomException.UserNotFound;
import com.example.OfflineChat.Model.User;
import com.example.OfflineChat.Repository.UserRepositry;
import com.example.OfflineChat.Response.ApiResponse;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ApiResponse getUserById(String id) {
       User foundUser = repositry.findById(id).get();
       Optional<User> user = Optional.of(foundUser);
       if(user.isEmpty())  throw new UserNotFound("User not found.");

       return new ApiResponse(true, "User found", user);

    }

    public ApiResponse findUserByPhoneNUmber(String phone) {
        Optional<User> user = repositry.findByPhone(phone);

        if(user.isEmpty())  throw new UserNotFound("User with phone number " + phone + " not found.");

        return new ApiResponse(true,"User Found",user );
    }

    public ApiResponse findUserByName(String name) {
      Optional<User> user =  repositry.findByName(name);
        if(user.isEmpty())  throw new UserNotFound("User with phone number " + name + " not found.");
        return new ApiResponse(true,"User Found",user );
    }
}
