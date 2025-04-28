package com.example.auth.service;

//package com.yourapp.service;

import com.example.auth.dao.UserDAO;
import com.example.auth.util.TokenManager;
import com.example.auth.dao.UserDAO;
import com.example.auth.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthService {

    private final UserDAO userDAO;
    private final TokenManager tokenManager;

    // Constructor to initialize DAO and TokenManager
    public AuthService(Connection conn) {
        this.userDAO = new UserDAO(conn);
        this.tokenManager = new TokenManager();
    }

    public AuthService(UserDAO userDAO, TokenManager tokenManager) {
        this.userDAO = null;
        this.tokenManager = null;
    }

    // ✅ Signup service (for creating a new user)
    public String signup(String username, String password) throws SQLException {
        if (userDAO.isUserExists(username)) {
            return null;  // User already exists
        }

        // Create the new user
        User user;
        user = new User(username, password);
        userDAO.createUser(user);

        // Return the token after successful signup
        return tokenManager.generateToken(username);
    }

    // ✅ Login service (for authenticating user)
    public String login(String username, String password) throws SQLException {
        if (userDAO.validateUser(username, password)) {
            // If user is valid, return a token
            return tokenManager.generateToken(username);
        } else {
            // Invalid login credentials
            return null;
        }
    }

    public boolean userExists(String username) {
        return false;
    }

    public void registerUser(String username, String password) {
    }

    public String authenticateUser(String username, String password) {
        return username;
    }
}
