package com.mahesh.fetchivo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/home")
@RestController
public class DashboardController {
    @GetMapping
    public String welcome(){
        return "Succesfully sign up using Google.. welcome home!!!";
    }

}
