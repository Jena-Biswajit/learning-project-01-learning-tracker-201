package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetriveUsingPreparedStatement {
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

            String query = "SELECT marks FROM students WHERE id = ?";

            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setInt(1, 3);
            ResultSet resultSet = prepareStatement.executeQuery();

            if (resultSet.next()) {
              
                double marks = resultSet.getDouble("marks");
                System.out.println("marks :"+ marks);
            } else {
                System.out.println("mark not found ");
            }
            prepareStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
