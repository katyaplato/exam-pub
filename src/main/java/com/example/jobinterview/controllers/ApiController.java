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





}
