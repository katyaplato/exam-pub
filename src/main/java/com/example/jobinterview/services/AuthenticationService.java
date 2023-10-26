package com.example.jobinterview.services;

import com.example.jobinterview.dtos.UserRegistrationDTO;
import com.example.jobinterview.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationService {
    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder;

    public void registerUser(UserRegistrationDTO registrationDTO) {
        // Check if the username is already taken
        if (userRepository.existsByName(registrationDTO.getName())) {
            throw new Error("Username already exists");
        }

        // Create a new user entity
        User user = new User();
        user.setName(registrationDTO.getName());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setIsAdult(registrationDTO.isAdult());


        userRepository.save(user);
    }

    public String loginUser(UserLoginDTO loginDTO) {

        User user = userRepository.findByName(loginDTO.getName())
                .orElseThrow(() -> new RuntimeException("User not found."));

        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return "Logged in successfully.";
        } else {
            throw new Error("Wrong password.");
        }
    }
}
