package com.mahesh.fetchivo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.List;
import com.mahesh.fetchivo.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, ObjectId>{
}
