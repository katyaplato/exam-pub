package com.example.jobinterview.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "drink-menu")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String drinkName;
    private double price;
    private boolean isForAdult;
}