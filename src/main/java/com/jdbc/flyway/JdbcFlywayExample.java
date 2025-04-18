package com.jdbc.flyway;

import java.sql.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcFlywayExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase"; 
    private static final String USER = "root";
    private static final String PASS = "Bbiswajit@408";

    public static void main(String[] args) {
        runScript("script1.sql");
        checkTableExists("employees");

        runScript("script2.sql");
        checkDataInserted();
    }

    public static void runScript(String fileName) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement()) {

            String sql = Files.readString(Path.of(fileName));
            stmt.execute(sql);
            System.out.println("Executed script: " + fileName);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkTableExists(String tableName) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                ResultSet rs = conn.getMetaData().getTables(null, null, tableName.toUpperCase(), null)) {

            if (rs.next()) {
                System.out.println("Table '" + tableName + "' exists in DB.");
            } else {
                System.out.println(" Table '" + tableName + "' not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDataInserted() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            while (rs.next()) {
                System.out.printf("Found Employee -> ID: %d, Name: %s, Dept: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
