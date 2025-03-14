### JDBC (Java Database Connectivity) - A Complete Guide

###  What is JDBC?
JDBC (Java Database Connectivity) is an API (Application Programming Interface) provided by Java for interacting with databases. It allows Java applications to connect to databases, send SQL queries, retrieve results, and perform database operations.

###  JDBC Drivers
JDBC uses different types of drivers to establish a connection between Java applications and databases. There are **four types of JDBC drivers**:

1. **JDBC-ODBC Bridge Driver (Type-1)**
    - Uses ODBC (Open Database Connectivity) to communicate with the database.
    - Requires ODBC drivers installed on the system.
    - **Example:** Not commonly used due to performance issues.

2. **Native API Driver (Type-2)**
    - Uses native database client libraries to interact with the database.
    - Requires database-specific drivers installed on the client machine.
    - **Example:** Oracle OCI driver.

3. **Network Protocol Driver (Type-3)**
    - Uses a middle-tier server to communicate with the database.
    - Database independence as it sends requests via a network.
    - **Example:** JDBC-Net drivers.

4. **Thin Driver (Type-4) – Most Common**
    - Directly communicates with the database using a pure Java driver.
    - No additional software required.
    - **Example:** MySQL Connector/J, PostgreSQL JDBC Driver.

###  Components of JDBC
JDBC consists of the following core components:

1. **DriverManager**: Manages the list of database drivers and establishes connections to databases.
2. **Connection**: Represents the connection to a specific database.
3. **Statement**: Executes SQL queries (SELECT, INSERT, UPDATE, DELETE).
4. **PreparedStatement**: Precompiled SQL statement with placeholders.
5. **CallableStatement**: Executes stored procedures.
6. **ResultSet**: Holds data retrieved from the database.

###  Setting up JDBC
### Steps to set up JDBC in a Java project:
1. **Download the JDBC driver** for your database. Example: MySQL Connector/J (`mysql-connector-java.jar`).
2. **Add the JDBC driver to the project’s classpath.**
3. **Write a Java program** to connect to the database.

### command to connect the db to localhost 
```
mysql -u user -p
```

### 5. First JDBC Program (Boilerplate Code)
```java
import java.sql.*;

public class FirstJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "password";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create Statement
            Statement stmt = conn.createStatement();

            // Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Process ResultSet
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }

            // Close Resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

###  CRUD Operations Using Statement
### Performing CRUD Operations using `Statement`
```java
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
```

### 7. PreparedStatement (Precompiled SQL Queries)
```java
import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Insert using PreparedStatement
            String insertSQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Alice");
            pstmt.setString(3, "alice@example.com");
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Batch Processing (Executing Multiple Queries at Once)
```java
import java.sql.*;

public class BatchProcessingExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Add batch
            stmt.addBatch("INSERT INTO users (id, name, email) VALUES (3, 'Bob', 'bob@example.com')");
            stmt.addBatch("INSERT INTO users (id, name, email) VALUES (4, 'Charlie', 'charlie@example.com')");
            
            // Execute batch
            int[] result = stmt.executeBatch();

            System.out.println("Batch executed successfully!");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Transaction Handling (Commit and Rollback)
```java
import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "password";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO users (id, name, email) VALUES (5, 'David', 'david@example.com')");
            stmt.executeUpdate("INSERT INTO users (id, name, email) VALUES (6, 'Eve', 'eve@example.com')");
            
            conn.commit();
            System.out.println("Transaction committed successfully!");
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```