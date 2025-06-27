package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.model.User;
import com.mahesh.fetchivo.repository.UserRepository;
import com.mahesh.fetchivo.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(Model model, @AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            User user = userService.getUserByProviderUserId(principal.getName());
            model.addAttribute("name", user.getName());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("provider", user.getProvider());
        }
        return "welcome";
    }
}