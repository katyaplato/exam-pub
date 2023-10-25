package com.example.jobinterview.controllers;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {
    @GetMapping("/users")
    public Iterable<User> getAllUsers(){
        return;
    }

}
