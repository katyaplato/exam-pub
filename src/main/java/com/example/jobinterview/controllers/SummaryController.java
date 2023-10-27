package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.SummaryAllDTO;
import com.example.jobinterview.dtos.SummaryProductDTO;
import com.example.jobinterview.dtos.SummaryUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Summary controller", description = "API to get summaries")
@RequestMapping("/api/summary")
public interface SummaryController {
    @GetMapping("/all")
    @Operation(summary = "Retrieve all orders for a specific product/drink across all drinks, including the total sum")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully get a summary"),
            @ApiResponse(responseCode = "400", description = "User cannot see any summary")
    })
    ResponseEntity<?> getAllSummary();

    @GetMapping("/product")
    @Operation(summary = "Retrieve all orders for a specific drink for each drink")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully get a summary"),
            @ApiResponse(responseCode = "400", description = "User cannot see any summary")
    })
    ResponseEntity<?> getProductSummary();

    @GetMapping("/user")
    @Operation(summary = "Retrieve all orders for a specific user across all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully get a summary"),
            @ApiResponse(responseCode = "400", description = "User cannot see any summary")
    })
    ResponseEntity<?> getSummaryUser();
}
