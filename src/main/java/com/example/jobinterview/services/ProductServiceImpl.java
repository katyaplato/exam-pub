package com.example.jobinterview.services;

import com.example.jobinterview.models.Order;
import com.example.jobinterview.models.Product;
import com.example.jobinterview.models.User;
import com.example.jobinterview.repositories.OrderRepository;
import com.example.jobinterview.repositories.ProductRepository;
import com.example.jobinterview.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    UserRepository userRepository;
    OrderRepository orderRepository;

    @Override
    public List<Product> getAllDrinks() {
        List<Product> allDrinks = productRepository.findAll();
        if (allDrinks.isEmpty()) {
            throw new Error("There is not any drink in our Drink Menu yet.");
        }
        return allDrinks;
    }
}
