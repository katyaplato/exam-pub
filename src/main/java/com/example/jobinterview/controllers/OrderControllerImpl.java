package com.example.jobinterview.controllers;

import com.example.jobinterview.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderControllerImpl {

    ProductService productService;

    @PostMapping("/buy")
    public String buyDrink(Long userId, Long productId, int amount) {
        return productService.buyProduct(userId, productId, amount);
    }
}