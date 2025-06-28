package com.mahesh.fetchivo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mahesh.fetchivo.model.User;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
