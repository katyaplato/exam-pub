package com.example.jobinterview.dtos;

import lombok.Data;

@Data
public class UserRegistrationDTO {
    private String name;
    private String password;
    private boolean isAdult;
}
