package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserDTO;
import com.example.jobinterview.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    UserService userService;

    @Override
    @GetMapping("/")
    public List<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable("userId") Long id) {
        return new UserDTO(userService.getUserById(id).getBody());
    }
}
