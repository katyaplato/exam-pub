package com.example.jobinterview.services;

import com.example.jobinterview.models.Drink;
import com.example.jobinterview.repositories.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DrinkService {
    DrinkRepository drinkRepository;

    public List<Drink> getAllDrinks() {
        List<Drink> allDrinks = drinkRepository.findAll();
        if (allDrinks.isEmpty()) {
            throw new Error("There is not any drink in our Drink Menu yet.");
        }
        return allDrinks;
    }
}
