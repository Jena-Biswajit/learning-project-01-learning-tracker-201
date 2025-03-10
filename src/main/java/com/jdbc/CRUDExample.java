package com.jdbc;

import java.sql.*;

public class CRUDExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "subhasmita";

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
            String insertQuery = "INSERT INTO users (id, name, email) VALUES (1, 'Biswajit Jena', 'biswajitjena529.com')";
            stmt.executeUpdate(insertQuery);

            // READ (Select)
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }

            // UPDATE
            String updateQuery = "UPDATE users SET name='Biswajit Jena' WHERE id=1";
            stmt.executeUpdate(updateQuery);

            // DELETE
            String deleteQuery = "DELETE FROM users WHERE id=1";
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
