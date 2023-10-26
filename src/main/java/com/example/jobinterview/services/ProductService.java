package com.example.jobinterview.services;

import com.example.jobinterview.models.Product;
import com.example.jobinterview.repositories.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    DrinkRepository drinkRepository;

    public List<Product> getAllDrinks() {
        List<Product> allDrinks = drinkRepository.findAll();
        if (allDrinks.isEmpty()) {
            throw new Error("There is not any drink in our Drink Menu yet.");
        }
        return allDrinks;
    }

//    public Product buyProduct(Product product, User user){
//        if(product.isForAdult()){
//            if()
//        }
//   }
}
