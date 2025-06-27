package com.mahesh.fetchivo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mahesh.fetchivo.model.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByProviderUserId(String providerUserId);
    User findByEmail(String email);
}