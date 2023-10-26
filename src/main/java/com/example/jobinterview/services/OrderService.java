package com.example.jobinterview.services;

import com.example.jobinterview.dtos.SummaryAllDTO;

import java.util.List;

public interface OrderService {
    List<SummaryAllDTO> getSummaryAll();
}
