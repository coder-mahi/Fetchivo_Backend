package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
]import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    public UserService service;


    @GetMapping("/{userId}")
    public User getUser(@PathVariable ObjectId userId){
        return service.findUser(userId);
    }

    @PostMapping
    public void signUpUser(@RequestBody User user){
        service.addUser(user);
    }

    @PutMapping("/{userId}")
    public boolean update(@PathVariable ObjectId userId, @RequestBody User newUser){
        return service.updateUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable ObjectId user){
        return service.deleteUser(user);
    }
}
