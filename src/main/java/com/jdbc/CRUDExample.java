package com.jdbc;

import java.sql.*;

public class CRUDExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "Bbiswajit@408";

           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // CREATE (Insert)
            String insertQuery = "INSERT INTO students (name,age,marks) VALUES ( 'Biswajit Jena',25, 33)";
            stmt.executeUpdate(insertQuery);

            // READ (Select)
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println("students: " + rs.getString("name"));
            }

            // UPDATE
            String updateQuery = "UPDATE students SET name='Biswajit Jena' WHERE id=1";
            stmt.executeUpdate(updateQuery);

            // DELETE
            String deleteQuery = "DELETE FROM students WHERE id=1";
            stmt.executeUpdate(deleteQuery);

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
