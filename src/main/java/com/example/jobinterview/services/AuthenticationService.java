package com.example.jobinterview.services;

import com.example.jobinterview.dtos.UserLoginDTO;
import com.example.jobinterview.dtos.UserRegistrationDTO;

public interface AuthenticationService {
    void registerUser(UserRegistrationDTO registrationDTO);
    void loginUser(UserLoginDTO loginDTO);
}
