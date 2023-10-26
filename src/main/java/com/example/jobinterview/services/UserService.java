package com.example.jobinterview.services;

import com.example.jobinterview.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<?> getAllUsers();
    ResponseEntity<User> getUserById(Long id);
}
