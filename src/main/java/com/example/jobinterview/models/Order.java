package com.example.jobinterview.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDERS")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int amount;
    private double price;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
