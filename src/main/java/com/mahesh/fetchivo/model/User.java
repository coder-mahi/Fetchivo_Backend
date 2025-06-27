package com.mahesh.fetchivo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String providerUserId;
    private String name;
    private String email;
    private String provider;
    private Map<String, Object> attributes;

    // Constructors
    public User() {}

    public User(String providerUserId, String name, String email, String provider, Map<String, Object> attributes) {
        this.providerUserId = providerUserId;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.attributes = attributes;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}