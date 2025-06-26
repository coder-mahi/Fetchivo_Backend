package com.mahesh.fetchivo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private ObjectId id;
    private String username;
    private String password;
    private String email;
    private int credits;
}
