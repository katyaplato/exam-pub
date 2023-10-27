package com.example.jobinterview.services;

import com.example.jobinterview.dtos.SummaryAllDTO;
import com.example.jobinterview.dtos.SummaryProductDTO;
import com.example.jobinterview.dtos.SummaryUserDTO;
import com.example.jobinterview.models.Order;
import com.example.jobinterview.models.Product;
import com.example.jobinterview.models.User;
import com.example.jobinterview.repositories.OrderRepository;
import com.example.jobinterview.repositories.ProductRepository;
import com.example.jobinterview.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getSummaryAll() {
        try {
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
            return ResponseEntity.ok(summary);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getSummaryProduct() {
        try {
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
            return ResponseEntity.ok(productSummary);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getSummaryUser() {
        try {
            List<Order> allOrders = orderRepository.findAll();
            List<SummaryUserDTO> summaryUser = new ArrayList<>();

            for (Order order : allOrders) {
                User user = order.getUser();
                Product product = order.getProduct();

                SummaryUserDTO summaryUserDTO = SummaryUserDTO
                        .builder()
                        .userId(user.getId())
                        .productName(product.getProductName())
                        .price(order.getPrice())
                        .build();
                summaryUser.add(summaryUserDTO);
            }
            return ResponseEntity.ok(summaryUser);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @Override
    public String buyProduct(Long userId, Long productId, int amount) {

//         we also can check if isAdult == true by getting this property from authorized user
//
//            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            String userName = userDetails.getUsername();
//            Optional<User> user = userRepository.findByName(userName);
//            Long userId = user.get().getId();

        Optional<User> maybeUser = userRepository.findById(userId);
        Optional<Product> maybeProduct = productRepository.findById(productId);

        if (maybeUser.isEmpty()) {
            throw new Error("A User with such ID does not exist.");
        } else if (maybeProduct.isEmpty()) {
            throw new Error("A drink with such ID does not exist.");
        }

        Product product = maybeProduct.get();
        User user = maybeUser.get();

        if (product.isForAdult()) {
            if (!user.isAdult()) {
                throw new Error("You are not allowed to drink alcohol!");
            } else if (user.getPocket() < (product.getPrice() * amount)) {
                throw new Error("You cannot afford it.");
            }
        }

        user.setPocket(user.getPocket() - product.getPrice());

        Order order = Order
                .builder()
                .product(product)
                .amount(amount)
                .price(product.getPrice() * amount)
                .user(user)
                .build();

        user.getOrders().add(order);

        return "Have a nice evening.";
    }
}
