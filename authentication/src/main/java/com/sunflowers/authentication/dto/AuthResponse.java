package com.sunflowers.authentication.dto;

public class AuthResponse {

    private String token;

    // Constructor
    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }
}
