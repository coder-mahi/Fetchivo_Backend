package com.mahesh.fetchivo.service;

import com.mahesh.fetchivo.dto.UserDTO;
import com.mahesh.fetchivo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahesh.fetchivo.model.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User processOAuth2User(OAuth2User oAuth2User, String provider) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String providerUserId = oAuth2User.getName();
        String name = (String) attributes.getOrDefault("name", "");
        String email = (String) attributes.getOrDefault("email", "");

        User user = userRepository.findByProviderUserId(providerUserId);
        if (user == null) {
            user = new User(providerUserId, name, email, provider, attributes);
        } else {
            user.setAttributes(attributes);
            user.setName(name);
            user.setEmail(email);
        }

        return userRepository.save(user);
    }

    public User getUserByProviderUserId(String providerUserId) {
        return userRepository.findByProviderUserId(providerUserId);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
