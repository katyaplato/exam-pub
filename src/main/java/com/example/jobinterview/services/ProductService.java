package com.example.jobinterview.services;

import com.example.jobinterview.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllDrinks();
    String buyProduct(Long userId, Long productId, int amount);
}
