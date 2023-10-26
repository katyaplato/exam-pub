package com.example.jobinterview.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummaryAllDTO {
    private String productName;
    private int amount;
    private double unitPrice;
    private double summaryPrice;
}
