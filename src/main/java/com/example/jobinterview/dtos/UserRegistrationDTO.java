package com.example.jobinterview.dtos;

import com.example.jobinterview.models.Role;
import lombok.Data;


@Data
public class UserRegistrationDTO {
    private String name;
    private String password;
    private boolean adult;
    private double pocket;
    private Role role;
}
