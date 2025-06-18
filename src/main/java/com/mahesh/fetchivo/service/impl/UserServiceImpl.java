package com.mahesh.fetchivo.service.impl;

import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.repository.UserRepository;
import com.mahesh.fetchivo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public Optional<User> getUser(ObjectId userId) {
        return userRepo.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User createUser(User user){
        userRepo.save(user);
        return user;
    }
}
