package com.example.jobinterview.controllers;

import com.example.jobinterview.models.User;
import com.example.jobinterview.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {
    UserService userService;

    @GetMapping("/users")
    public List<?> getAllUsers() {
        return  userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long id){
        return userService.getUserById(id);
    }

}
