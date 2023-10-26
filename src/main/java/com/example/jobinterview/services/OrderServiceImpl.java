package com.example.jobinterview.services;

import com.example.jobinterview.dtos.SummaryAllDTO;
import com.example.jobinterview.dtos.SummaryProductDTO;
import com.example.jobinterview.models.Order;
import com.example.jobinterview.models.Product;
import com.example.jobinterview.models.User;
import com.example.jobinterview.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;

    @Override
    public List<SummaryAllDTO> getSummaryAll() {
        List<Order> allOrders = orderRepository.findAll();
        List<SummaryAllDTO> summary = new ArrayList<>();

        for (Order order : allOrders) {
            Product product = order.getProduct();

            SummaryAllDTO summaryAllDTO = SummaryAllDTO
                    .builder()
                    .productName(product.getProductName())
                    .amount(order.getAmount())
                    .unitPrice(product.getPrice())
                    .summaryPrice(order.getPrice())
                    .build();

            summary.add(summaryAllDTO);
        }
        return summary;
    }

    @Override
    public List<SummaryProductDTO> getSummaryProduct() {
        List<Order> allOrders = orderRepository.findAll();
        List<SummaryProductDTO> productSummary = new ArrayList<>();

        for (Order order : allOrders) {
            User user = order.getUser();
            SummaryProductDTO summaryProductDTO = SummaryProductDTO
                    .builder()
                    .userId(user.getId())
                    .amount(order.getAmount())
                    .price(order.getPrice())
                    .build();

            productSummary.add(summaryProductDTO);
        }
        return productSummary;
    }
}
