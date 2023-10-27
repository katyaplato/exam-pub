package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "User controller", description = "API to handle user-related operations")
@RequestMapping("/api/users")
public interface UserController {
    @GetMapping("/")
    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all the users"),
            @ApiResponse(responseCode = "404", description = "There are not users yet")
    })
    List<?> getAllUsers();

    @GetMapping("/{userId}")
    @Operation(summary = "Get user info by user id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user info by user id"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    UserDTO getUserById(@PathVariable("userId") Long id);
}
