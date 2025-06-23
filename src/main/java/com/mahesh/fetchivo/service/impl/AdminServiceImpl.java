package com.mahesh.fetchivo.service.impl;

import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.repository.UserRepository;
import com.mahesh.fetchivo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public User createUser(User user) {
        user.setUsername(user.getUsername()); //no need
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
