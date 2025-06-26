package com.mahesh.fetchivo.service;

import com.mahesh.fetchivo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahesh.fetchivo.model.*;
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User findUser(ObjectId userId){
        if(repo.existsById(userId)) {
            return repo.findById(userId).get();
        }
            return null;
    }

    public void addUser(User user){
        repo.save(user);
    }

    public boolean updateUser(ObjectId userId, User newUser){
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

    public boolean deleteUser(ObjectId userId){
        if(!repo.existsById(userId)){
            repo.deleteById(userId);
            return true;
        }
        return false;
    }

}
