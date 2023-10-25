package com.example.jobinterview.services;

import com.example.jobinterview.models.User;
import com.example.jobinterview.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<?> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty()) {
            throw new Error("No customers today in the pub.");
        }
        return allUsers;
    }

    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> maybeUser = userRepository.findById(id);
        if (maybeUser.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        User user = maybeUser.get();
        return ResponseEntity.status(200).body(user);
    }
}
