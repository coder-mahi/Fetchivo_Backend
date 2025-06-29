package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.dto.LoginRequest;
import com.mahesh.fetchivo.dto.LoginResponse;
import com.mahesh.fetchivo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    ));

            LoginResponse response = new LoginResponse(jwtUtil.generateToken(loginRequest.getUsername()));
        return response;
    }
}