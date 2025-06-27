package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.dto.UserDTO;
import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    public UserService service;

    @GetMapping
    public List<UserDTO> getAllUser(){
        return service.getAllUser();
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return service.findUser(userId);
    }

    @PostMapping
    public void signUpUser(@RequestBody User user){
        service.addUser(user);
    }

    @PutMapping("/{userId}")
    public boolean update(@PathVariable String userId, @RequestBody User newUser){
        return service.updateUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable String user){
        return service.deleteUser(user);
    }
}
