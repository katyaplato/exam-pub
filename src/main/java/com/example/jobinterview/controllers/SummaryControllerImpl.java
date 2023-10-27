package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.SummaryAllDTO;
import com.example.jobinterview.dtos.SummaryProductDTO;
import com.example.jobinterview.dtos.SummaryUserDTO;
import com.example.jobinterview.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/summary")
@AllArgsConstructor
public class SummaryControllerImpl implements SummaryController {

    OrderService orderService;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<SummaryAllDTO>> getAllSummary() {
        return orderService.getSummaryAll();
    }

    @Override
    @GetMapping("/product")
    public ResponseEntity<List<SummaryProductDTO>> getProductSummary() {
        return orderService.getSummaryProduct();
    }

    @Override
    @GetMapping("/user")
    public ResponseEntity<List<SummaryUserDTO>> getSummaryUser() {
        return orderService.getSummaryUser();
    }
}
