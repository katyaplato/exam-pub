package com.example.jobinterview.services;

import com.example.jobinterview.dtos.SummaryAllDTO;
import com.example.jobinterview.dtos.SummaryProductDTO;
import com.example.jobinterview.dtos.SummaryUserDTO;

import java.util.List;

public interface OrderService {
    List<SummaryAllDTO> getSummaryAll();
    List<SummaryProductDTO> getSummaryProduct();
    List<SummaryUserDTO> getSummaryUser();
}
