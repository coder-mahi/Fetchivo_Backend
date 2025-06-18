package com.mahesh.fetchivo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "users")
public class User{
	@Id
	public ObjectId userid;
	public String username;
	public String email;
	public void setUserId(ObjectId userid) {
		this.userid = userid;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public ObjectId getUserId() {
		return userid;
	}
	public String getUserName() {
		return username;
	}
	public String getUserEmail() {
		return email;
	}
}