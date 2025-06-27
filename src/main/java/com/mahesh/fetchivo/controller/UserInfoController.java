package com.mahesh.fetchivo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserInfoController {

    @GetMapping("/me")
    public Map<String, Object> getAuthenticatedUser(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return Map.of("error", "User not authenticated");
        }
        return principal.getAttributes(); // 👈 returns user profile info like email, name, picture
    }
}
