### Java flyway explanation 
- Flyway is a powerful database migration tool. 
- It simplifies and automates the process of managing database schema changes. 
- Flyway follows the simple principle of versioning the database schema using SQL scripts. 
- These scripts are organized in a specific folder structure and executed in a sequential order.
- Version control your database schema (like Git for your DB)
- Apply SQL scripts in order to keep your database structure updated
- Track which migrations have already been applied

### follow below article to set-up java flyway
- In this article, we will learn how to use Flyway with JDBC for effective database migration.

- https://www.geeksforgeeks.org/how-to-use-flyway-database-migration-tool-with-jdbc/

### How Flyway Works with SQL Scripts
- SQL files should be named like:
- script1.sql
- script2.sql

- Flyway runs them in order (based on the version prefix 1, 2, etc.)

- It maintains a table in your DB called flyway_schema_history to keep track of applied migrations

### Example jdbc flyway
```java
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
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Employee";
    private static final String USER = "root";
    private static final String PASS = "subhasmita";

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
```

**o/p**

---
![flyway db tracking.png](flyway%20db%20tracking.png)
---

**Employee table**

---
![employees table.png](employees%20table.png)
---