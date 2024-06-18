package com.example.OfflineChat.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Email is Required")
    @Email(message = "Please Enter valid email")
    private String email;


    private String model;

    @Indexed(unique = true)
    @NotEmpty
    @Size(min = 10, max = 10, message = "Please enter valid phone no")
    private String phone;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.model =  "mistral";
        this.phone = phone;
    }
}
