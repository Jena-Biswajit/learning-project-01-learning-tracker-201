package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateUsingPreparedStatement {
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

            String query = "UPDATE students SET MARKS = ? WHERE id = ?";

            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setDouble(1, 87);
            prepareStatement.setInt(2, 3);
            int rowsAffected = prepareStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("data updated successfully");
            } else {
                System.out.println("data not updated ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
