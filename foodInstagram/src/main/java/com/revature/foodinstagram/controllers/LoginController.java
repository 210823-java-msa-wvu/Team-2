package com.revature.foodinstagram.controllers;

import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    private UserRepo userRepo;

    @Autowired
    LoginController(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @PostMapping
    public void login(@RequestBody User user){
        userService
    }

}
