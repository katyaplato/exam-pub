package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserLoginDTO;
import com.example.jobinterview.dtos.UserRegistrationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Authentication controller", description = "API to handle registration and login")
@RequestMapping("/api/auth")
public interface AuthenticationController {
    @PostMapping("/registration")
    @Operation(summary = "Post request to register new user",
            description = "Enter your name and password to register a new user. " +
                    "If the name is already taken, you will get an error message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully registered"),
            @ApiResponse(responseCode = "400", description = "User with this name already exists")
    })
    ResponseEntity<?> register(@RequestBody UserRegistrationDTO registrationDTO);

    @PostMapping("/login")
    @Operation(summary = "Post request to log in user",
            description = "By entering user name and password, our database will log in the user, while providing him access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully logged in"),
            @ApiResponse(responseCode = "400", description = "User with this name does not exist or password is incorrect")
    })
    ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO);
}
