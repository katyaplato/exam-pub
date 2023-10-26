package com.example.jobinterview.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double price;
    private boolean isForAdult;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Order> orders;
}
