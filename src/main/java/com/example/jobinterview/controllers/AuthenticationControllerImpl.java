package com.example.jobinterview.controllers;

import com.example.jobinterview.dtos.UserLoginDTO;
import com.example.jobinterview.dtos.UserRegistrationDTO;
import com.example.jobinterview.services.AuthenticationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationControllerImpl {

    private AuthenticationServiceImpl authenticationService;

    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody UserRegistrationDTO registrationDTO) {
        authenticationService.registerUser(registrationDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO loginDTO) {
        authenticationService.loginUser(loginDTO);
        return ResponseEntity.ok().build();
    }
}
