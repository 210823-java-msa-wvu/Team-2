package com.revature.foodinstagram.controllers;


import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {

    private UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping(path="/{id}")
    public User getById(@PathVariable("id") int id){
        return userRepo.getById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping(path="/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (id == user.getId()) {
            userRepo.save(user);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userRepo.delete(userRepo.getById(id));
    }

}
