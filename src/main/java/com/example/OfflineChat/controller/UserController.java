package com.example.OfflineChat.controller;

import com.example.OfflineChat.Model.Seasson;
import com.example.OfflineChat.Model.User;
import com.example.OfflineChat.Response.ApiResponse;
import com.example.OfflineChat.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.UncategorizedMongoDbException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


//@CrossOrigin(origins = "http://localhost:5173/")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService serverice;



    public UserController(UserService serverice) {
        this.serverice = serverice;

    }

    @PostMapping("/")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        try {
            User savedUser =  serverice.addUser(user);
            return new ResponseEntity(savedUser, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity("User already exists please login. ",HttpStatus.CONFLICT);

        }

    }


    @PostMapping("/login")
    public ResponseEntity<?> findUserByPhoneNumber(@RequestBody User phone) {
        System.out.println(phone.getPhone());

        try {
           ApiResponse user =  serverice.findUserByPhoneNUmber(phone.getPhone());
            return new ResponseEntity(user,HttpStatus.OK);
        }
        catch (Exception  e ) {
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/name")
    public ApiResponse findByName(@RequestBody  User name) {
        return serverice.findUserByName(name.getName());
    }

    @PostMapping("/seassion")
    public ResponseEntity<?> newSeasson(@RequestBody Seasson s) {
        SeassonController sc = new SeassonController();
        Seasson newSeasson  = sc.seassonHandler(s);
        return new ResponseEntity<>(newSeasson,HttpStatus.OK);
    }




}
