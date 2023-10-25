package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserDTO;
import com.example.jobinterview.models.Drink;
import com.example.jobinterview.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api")
public class ApiController {
    UserService userService;

    @GetMapping("/users")
    public List<?> getAllUsers() {
        return  userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable("userId") Long id){
        return new UserDTO(userService.getUserById(id).getBody());
    }

    @GetMapping("/drinks")
    public List<Drink> getAllDrinks(){
        return
    }

}
