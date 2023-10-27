package com.example.jobinterview.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;


@Tag(name = "Order controller", description = "API to handle operations on orders")
public interface OrderController {
    @PostMapping("/buy")
    @Operation(summary = "Post request to buy a drink/creating an order",
            description = "Enter your name and password to register a new user. " +
                    "If the the drink is for adult but the user is not adult or if the user does not have enough money to buy the product" +
                    " you will get an error message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully bought a product"),
            @ApiResponse(responseCode = "400", description = "User cannot afford the product or is not old enough.")
    })
    String buyDrink(Long userId, Long productId, int amount);
}
