package com.example.jobinterview.controllers;

import com.example.jobinterview.models.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Product controller", description = "API to handle operations on products")
@RequestMapping("/api/products")
public interface ProductController {
    @GetMapping("/drink-menu")
    @Operation(summary = "Get request to get the list of all products",
            description = "Retrieve a drinks menu with items. If there are not drinks in menu, you will get an error.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully get a list"),
            @ApiResponse(responseCode = "404", description = "User cannot see any product because the list is empty.")
    })
    List<Product> getAllDrinks();
}
