package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertUsingPreparedStatement {
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
            Connection connection = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO students(name,age,marks) VALUES(?,?,?)";

            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, "krishna");
            prepareStatement.setInt(2, 26);
            prepareStatement.setDouble(3, 56.3);

            int rowsAffected = prepareStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("data inserted successfully");
            } else {
                System.out.println("data not inserted ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
