package com.example.jobinterview.dtos;

import com.example.jobinterview.models.Order;
import com.example.jobinterview.models.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private double pocket;
    private List<Order> orders;
}
