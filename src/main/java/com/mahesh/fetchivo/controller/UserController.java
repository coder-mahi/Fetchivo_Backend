package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.dto.UserDTO;
import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return service.getAllUsers();
    }
    @GetMapping("/{userid}")
    public Optional<User> getUserById(@PathVariable String userid){
        return service.getUser(userid);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        if(user!=null){
            service.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/{userid}")
    public ResponseEntity<?> updateUser(@PathVariable String userid, @RequestBody User user){
        if(!userid.equals("") && user!=null){
            service.updateUser(userid,user);
            return new ResponseEntity<>("User Updated..!",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Invalid UserId..!",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable String userid){
        if(!userid.equals("")){
            service.deleteUser(userid);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Invalid UserId..!",HttpStatus.BAD_REQUEST);
        }
    }

}
