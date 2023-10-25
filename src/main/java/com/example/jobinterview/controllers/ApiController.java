package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserDTO;
import com.example.jobinterview.models.Product;
import com.example.jobinterview.services.ProductService;
import com.example.jobinterview.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/api")
public class ApiController {
    UserService userService;
    ProductService drinkService;

    @GetMapping("/users")
    public List<?> getAllUsers() {
        return  userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable("userId") Long id){
        return new UserDTO(userService.getUserById(id).getBody());
    }

    @GetMapping("/drinks")
    public List<Product> getAllDrinks(){
        return drinkService.getAllDrinks();
    }

}
