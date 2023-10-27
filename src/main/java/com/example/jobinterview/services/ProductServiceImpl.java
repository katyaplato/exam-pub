package com.example.jobinterview.services;

import com.example.jobinterview.models.Product;
import com.example.jobinterview.repositories.OrderRepository;
import com.example.jobinterview.repositories.ProductRepository;
import com.example.jobinterview.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is not any drink in our Drink Menu yet.");
        }
        return allDrinks;
    }
}
