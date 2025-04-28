
package com.example.auth.dao;

import com.example.auth.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private final Connection conn;

    // Constructor to initialize with a Connection object
    public UserDAO(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.conn = conn;
    }

    // Default constructor removed since connection should always be passed for DB operations
    // public UserDAO() { conn = null; } // Remove this constructor to prevent misuse

    // ✅ Method to check if a user already exists
    public boolean isUserExists(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;  // true if count > 0
            }
        }
    }

    // ✅ Method to create a new user
    public void createUser(User user) throws SQLException {
        String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword()); // Plain password for now
            stmt.executeUpdate();
        }
    }

    // ✅ Method to validate username and password during login
    public boolean validateUser(String username, String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;  // true if credentials are valid
            }
        }
    }
}
