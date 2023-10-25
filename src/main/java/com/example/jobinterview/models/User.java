package com.example.jobinterview.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private double pocket;
    @Enumerated
    private Role role;
    @OneToMany(mappedBy = "USER", cascade = CascadeType.ALL)
    private List<Order> orders;
}
