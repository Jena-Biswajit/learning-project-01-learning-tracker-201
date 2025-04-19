package com.jdbc.flyway;

import org.flywaydb.core.Flyway;
import java.sql.*;

public class JdbcFlywayExample {
    public static void main(String[] args) {

        // Run Flyway migration using settings from flyway.conf
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/Employee", "root", "subhasmita")
                .locations("filesystem:db/migration")
                .load();
        flyway.migrate();

        // Check inserted data
        checkDataInserted();
    }

    public static void checkDataInserted() {
        // Flyway will use the database details from flyway.conf file
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "subhasmita");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
