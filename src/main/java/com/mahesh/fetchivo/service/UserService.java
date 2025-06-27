package com.mahesh.fetchivo.service;

import com.mahesh.fetchivo.dto.UserDTO;
import com.mahesh.fetchivo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahesh.fetchivo.model.*;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User findUser(String userId){
        return repo.findById(userId).orElse(null);
    }

    public void addUser(User user){
        repo.save(user);
    }

    public boolean updateUser(String userId, User newUser){
        if(repo.existsById(userId)){
            User user = findUser(userId);
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setCredits(newUser.getCredits());
            repo.save(user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String userId){
        if(repo.existsById(userId)){
            repo.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<UserDTO> getAllUser() {
        List<User> users = repo.findAll();
        return users.stream()
                .map(user -> new UserDTO(user.getUsername(),user.getEmail(),user.getCredits()))
                .collect(Collectors.toList());
    }
}
