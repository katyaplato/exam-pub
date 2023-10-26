package com.example.jobinterview.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummaryUserDTO {
    private Long userId;
    private String productName;
    private double price;
}
