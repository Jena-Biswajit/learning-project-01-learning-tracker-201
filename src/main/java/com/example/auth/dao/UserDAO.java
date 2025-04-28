
package com.example.auth.dao;

import com.example.auth.model.User;
import com.example.auth.util.DBConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // ✅ Method to check if a user already exists
    public boolean isUserExists(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        Connection conn = DBConnectionManager.getConnection();
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
        Connection conn = DBConnectionManager.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword()); // Plain password for now
            stmt.executeUpdate();
        }
    }

    // ✅ Method to validate username and password during login
    public boolean validateUser(String username, String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        Connection conn = DBConnectionManager.getConnection();
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
