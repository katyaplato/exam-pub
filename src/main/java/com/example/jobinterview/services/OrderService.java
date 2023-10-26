package com.example.jobinterview.services;

import com.example.jobinterview.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService implements OrderRepository {
    OrderRepository orderRepository;
}
