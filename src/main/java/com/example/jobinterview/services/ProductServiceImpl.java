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

    @Override
    public String buyProduct(Long userId, Long productId, int amount) {

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
