package com.mahesh.fetchivo.service;
import java.util.*;
import com.mahesh.fetchivo.model.User;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

public interface UserService{
	public Optional<User> getUser(ObjectId userId);
	public List<User> getAllUsers();
	public User createUser(User user);
}