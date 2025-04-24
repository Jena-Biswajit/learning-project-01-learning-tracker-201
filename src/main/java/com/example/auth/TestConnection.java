package com.example.auth;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            if (conn != null) {
                System.out.println(" Connected to DB");
            } else {
                System.out.println(" Failed to connect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

