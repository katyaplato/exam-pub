package com.example.jobinterview.services;

import com.example.jobinterview.dtos.UserLoginDTO;
import com.example.jobinterview.dtos.UserRegistrationDTO;
import com.example.jobinterview.models.User;
import com.example.jobinterview.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserRepository userRepository;
    @Override
    public void registerUser(UserRegistrationDTO registrationDTO) {

        if (userRepository.existsByName(registrationDTO.getName())) {
            throw new Error("User already exists");
        }

        User user = User
                .builder()
                .name(registrationDTO.getName())
                .password(registrationDTO.getPassword())
                .isAdult(registrationDTO.isAdult())
                .pocket(registrationDTO.getPocket())
                .role(registrationDTO.getRole())
                .build();

        userRepository.save(user);
    }
    @Override
    public void loginUser(UserLoginDTO loginDTO) {

        Optional<User> maybeUser = userRepository.findByName(loginDTO.getName());
        if (maybeUser.isEmpty()) {
            throw new Error("User not found.");
        }
        User user = maybeUser.get();


        if (loginDTO.getPassword().equals(user.getPassword())) {
        } else {
            throw new Error("Wrong password.");
        }
    }
}
