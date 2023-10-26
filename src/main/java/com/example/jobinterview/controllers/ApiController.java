package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserDTO;
import com.example.jobinterview.models.Product;
import com.example.jobinterview.services.ProductServiceImpl;
import com.example.jobinterview.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {

    UserServiceImpl userService;
    ProductServiceImpl productService;

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

    @GetMapping("/drink-menu")
    public List<Product> getAllDrinks() {
        return productService.getAllDrinks();
    }

    @PostMapping("/buy")
    public String buyDrink(Long userId, Long productId, int amount){
        return productService.buyProduct(userId, productId, amount);
    }
}
