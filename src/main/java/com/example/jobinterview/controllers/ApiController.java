package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserDTO;
import com.example.jobinterview.models.Product;
import com.example.jobinterview.services.ProductService;
import com.example.jobinterview.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {

    UserService userService;

    ProductService drinkService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Kate:)";
    }

    @GetMapping("/users")
    public List<?> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable("userId") Long id) {
        return new UserDTO(userService.getUserById(id).getBody());
    }

    @GetMapping("/drinks")
    public List<Product> getAllDrinks() {
        return drinkService.getAllDrinks();
    }

    @PostMapping("/buy")
    public String buyDrink(Long userId, Long productId){

    }
}
