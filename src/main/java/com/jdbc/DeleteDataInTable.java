package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDataInTable {
    static String url = "jdbc:mysql://localhost:3306/mydatabase";
    static String user = "root";
    static String password = "Bbiswajit@408";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String query = String.format("DELETE FROM students WHERE ID = 2");
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("data deleted successfully");
            } else {
                System.out.println("data not deleted ");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
