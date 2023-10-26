package com.example.jobinterview.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "DRINK-MENU")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double price;
    private boolean isForAdult;
}
