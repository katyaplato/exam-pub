package com.example.jobinterview.controllers;

import com.example.jobinterview.models.Product;
import com.example.jobinterview.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsControllerImpl implements ProductController {
    ProductService productService;

    @Override
    @GetMapping("/drink-menu")
    public List<Product> getAllDrinks() {
        return productService.getAllDrinks();
    }
}
