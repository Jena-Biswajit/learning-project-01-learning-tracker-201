package com.example.auth.util;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties properties = new Properties();
        try (InputStream input = DBConnectionManager.class.getClassLoader().getResourceAsStream("dbcredential/db.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find dbcredential/db.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error reading database properties", ex);
        }

        URL = properties.getProperty("db.url");
        USERNAME = properties.getProperty("db.username");
        PASSWORD = properties.getProperty("db.password");

        Flyway flyway = Flyway.configure()
                .dataSource(URL, USERNAME, PASSWORD)
                .locations("filesystem:db/migration")
                .load();

        flyway.migrate();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
