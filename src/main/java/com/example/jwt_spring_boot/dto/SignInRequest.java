package com.example.jwt_spring_boot.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
