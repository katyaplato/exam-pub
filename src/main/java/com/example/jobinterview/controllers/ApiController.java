package com.example.jobinterview.controllers;

import com.example.jobinterview.models.User;
import com.example.jobinterview.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return  userService.getAllUsers();
    }

}
