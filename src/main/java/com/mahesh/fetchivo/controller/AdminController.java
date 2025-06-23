package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminServiceImpl service;

    @GetMapping
    public String healthCheck(){
        return "OK";
    }
    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        boolean successed = false;
        User createdUserInfo = null;
        if(user!=null){
            createdUserInfo = service.createUser(user);
            successed = true;
        }

        return (successed)? new ResponseEntity<>("createdUserInfo: "+createdUserInfo,HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}