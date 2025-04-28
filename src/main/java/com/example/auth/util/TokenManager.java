package com.example.auth.util;

import java.util.UUID;

public class TokenManager {

    public String generateToken(String username) {
        return UUID.randomUUID().toString();
    }

    public boolean validateToken(String token) {
        // Add your logic to validate token if necessary
        return token != null && !token.isEmpty();
    }
}
