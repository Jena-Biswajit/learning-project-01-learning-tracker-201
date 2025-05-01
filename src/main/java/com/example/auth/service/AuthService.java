package com.example.auth.service;

import com.example.auth.dao.UserDAO;
import com.example.auth.util.TokenManager;
import com.example.auth.model.User;
import java.sql.SQLException;

public class AuthService {

    private final UserDAO userDAO;
    private final TokenManager tokenManager;

    // Constructor to initialize UserDAO and TokenManager
    public AuthService(UserDAO userDAO, TokenManager tokenManager) {
        this.userDAO = userDAO;
        this.tokenManager = tokenManager;
    }

    //  Signup service (for creating a new user)
    public String signup(User user) throws SQLException {  // Removed static
        // Check if the user already exists by checking the username
        if (userDAO.isUserExists(user.getUsername())) {
            return null;  // User already exists
        }

        // Create the new user in the database
        userDAO.createUser(user);

        // Return the token after successful signup
        return tokenManager.generateToken(user.getUsername());
    }

    //  Login service (for authenticating user)
    public String login(User user) throws SQLException {
        // Validate the user's credentials using the UserDAO
        if (userDAO.validateUser(user.getUsername(), user.getPassword())) {
            // If the user is valid, generate and return a token
            return tokenManager.generateToken(user.getUsername());
        } else {
            // If credentials are invalid, return null (failed login)
            return null;
        }
    }

    // Method to authenticate user using username and password (alternative for calling login)
    public String authenticateUser(String username, String password) throws SQLException {

        User user = new User(username, password);  // Create a new User object
        return login(user);  // Delegate to login method
    }
}
