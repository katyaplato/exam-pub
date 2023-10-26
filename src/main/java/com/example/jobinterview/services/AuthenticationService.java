package com.example.jobinterview.services;

import com.example.jobinterview.dtos.UserLoginDTO;
import com.example.jobinterview.dtos.UserRegistrationDTO;
import com.example.jobinterview.models.User;
import com.example.jobinterview.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationService {
    private UserRepository userRepository;


    private PasswordEncoder passwordEncoder;

    public void registerUser(UserRegistrationDTO registrationDTO) {

        if (userRepository.existsByName(registrationDTO.getName())) {
            throw new Error("Username already exists");
        }


        User user = new User();
        user.setName(registrationDTO.getName());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setIsAdult(registrationDTO.isAdult());


        userRepository.save(user);
    }

    public String loginUser(UserLoginDTO loginDTO) {

        Optional<User> maybeUser = userRepository.findByName(loginDTO.getName());
        if (maybeUser.isEmpty()) {
            throw new Error("User not found.");
        }
        User user = maybeUser.get();


        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return "Logged in successfully.";
        } else {
            throw new Error("Wrong password.");
        }
    }
}
