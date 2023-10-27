package com.example.jobinterview.services;

import com.example.jobinterview.dtos.SummaryAllDTO;
import com.example.jobinterview.dtos.SummaryProductDTO;
import com.example.jobinterview.dtos.SummaryUserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<List<SummaryAllDTO>> getSummaryAll();
    ResponseEntity<List<SummaryProductDTO>> getSummaryProduct();
    ResponseEntity<List<SummaryUserDTO>> getSummaryUser();
    String buyProduct(Long userId, Long productId, int amount);
}
