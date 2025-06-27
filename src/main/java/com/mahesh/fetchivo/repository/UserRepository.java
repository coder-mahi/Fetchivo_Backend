package com.mahesh.fetchivo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mahesh.fetchivo.model.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User,String>{
    Optional<User> findByEmail(String email);
}
