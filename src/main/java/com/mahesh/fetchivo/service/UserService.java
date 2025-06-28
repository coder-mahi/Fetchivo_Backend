package com.mahesh.fetchivo.service;

import com.mahesh.fetchivo.dto.UserDTO;
import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Optional<User> getUser(String userid){
        return repo.findById(userid);
    }

    public void createUser(User newUser){
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        repo.save(newUser);
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = repo.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getUserid(),user.getUsername()))
                .collect(Collectors.toList());
    }

    public void updateUser(String userid, User newUser) {
        if (newUser != null) {

            // Check for empty fields
            if (isNullOrEmpty(newUser.getUsername()) || isNullOrEmpty(newUser.getPassword())) {
                throw new IllegalArgumentException("Username or password cannot be empty.");
            }

            Optional<User> optionalUser = repo.findById(userid);

            if (optionalUser.isPresent()) {
                User oldUser = optionalUser.get();
                oldUser.setUsername(newUser.getUsername());
                oldUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
                repo.save(oldUser);
            } else {
                throw new RuntimeException("User with ID " + userid + " not found.");
            }
        }
    }

    // Helper method
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }



    public void deleteUser(String userId){
        repo.deleteById(userId);
    }
}
