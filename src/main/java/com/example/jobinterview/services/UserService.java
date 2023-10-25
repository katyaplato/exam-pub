package com.example.jobinterview.services;

import com.example.jobinterview.models.User;
import com.example.jobinterview.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public List getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        if(allUsers.isEmpty()){
        throw new Error("No customers today in the pub.");
        }
        return allUsers;
    }
}
