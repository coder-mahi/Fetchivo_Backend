package com.mahesh.fetchivo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mahesh.fetchivo.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,ObjectId>{
    Optional<User> findByUsername(String username);
}