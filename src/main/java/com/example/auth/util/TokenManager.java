package com.example.auth.util;

import com.example.auth.model.User;
import com.example.auth.servlet.TokenStore;
import  com.example.auth.model.User;
import java.util.UUID;

public class TokenManager {

    public String generateToken(String username) {

        String token = UUID.randomUUID().toString();
        TokenStore.tokenMap.put(token, username);
        return token ;
    }

    public boolean validateToken(String token) {
        // Add your logic to validate token if necessary
        return token != null && !token.isEmpty();
    }
}
