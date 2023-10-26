package com.example.jobinterview.dtos;

import lombok.Data;

@Data
public class SummaryUserDTO {
    private Long userId;
    private String productName;
    private double price;
}
