package com.jdbc;
import java.sql.*;

public class CRUDExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // CREATE (Insert)
            String insertQuery = "INSERT INTO users (id, name, email) VALUES (1, 'John Doe', 'john@example.com')";
            stmt.executeUpdate(insertQuery);

            // READ (Select)
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }

            // UPDATE
            String updateQuery = "UPDATE users SET name='Jane Doe' WHERE id=1";
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
