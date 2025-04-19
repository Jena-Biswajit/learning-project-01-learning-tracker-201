### Java flyway explanation 
- Flyway is a powerful database migration tool.
- Version control your database schema (like Git for your DB)
- Apply SQL scripts in order to keep your database structure updated
- Track which migrations have already been applied.

### How Flyway Works with SQL Scripts

---
- when you run your application again, Flyway will check the migration scripts directory to see if there are any new scripts (i.e., scripts that have not been applied to the database yet).
- If a script is found in the directory but is not listed in Flyway's history table (which tracks the migrations already applied), Flyway will execute that new script to update the database.
- After executing the new script, Flyway will record the script's details (such as the script name and its execution time) in the history table of the database. 
- This ensures that Flyway knows which migrations have already been applied, preventing them from being applied again in future runs.

---

### follow below article to set-up java flyway
- In this article, we will learn how to use Flyway with JDBC for effective database migration.

- https://www.geeksforgeeks.org/how-to-use-flyway-database-migration-tool-with-jdbc/

- Set-up maven for jdbc flyway connection

**Example**
```
    <!-- Flyway core -->
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-core</artifactId>
        <version>8.5.13</version>
    </dependency>

    <!-- Flyway MySQL support (you were missing this!) -->
    <dependency>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-mysql</artifactId>
        <version>8.5.13</version>
    </dependency>
```

**Example**

```java
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
```

**O/p**
```
![Image](https://github.com/user-attachments/assets/11a203cc-3bb1-45f0-a8f8-8fd04b7a803b)
```
**Database table**
```
![Image](https://github.com/user-attachments/assets/dc1d052d-ce07-4009-a224-171169eb4869)
```

