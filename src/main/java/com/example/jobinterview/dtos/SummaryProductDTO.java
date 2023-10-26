package com.example.jobinterview.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummaryProductDTO {
    private Long userId;
    private int amount;
    private double price;
}
