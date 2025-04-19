### Java flyway explanation 
- Flyway is a powerful database migration tool.
- Version control your database schema (like Git for your DB)
- Apply SQL scripts in order to keep your database structure updated
- Track which migrations have already been applied.

### How Flyway Works with SQL Scripts

---
**imp**

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

<img width="1335" alt="Image" src="https://github.com/user-attachments/assets/e420c22e-1994-4826-b067-b824113d8073" />

**Database table**

<img width="1310" alt="Image" src="https://github.com/user-attachments/assets/ed6c1106-5620-4c47-81d3-5d2af6fb8052" />

###  What Is File Naming in Flyway?

**File naming in Flyway** means how you name your SQL migration scripts so that Flyway can:
- Recognize them,
- Determine the order to run them, and
- Keep track of which scripts have already been executed in the database.

Flyway **relies on the filename** — not the contents of the file — to control this behavior.

---

### Flyway File Naming Format

Each migration script **must follow a strict naming pattern**:

```
V<version>__<description>.sql
```

### Breakdown:

| Part               | Meaning                                      | Example                        |
|--------------------|----------------------------------------------|--------------------------------|
| `V`                | Indicates a **versioned migration**          | `V1`                          |
| `<version>`        | Migration version number (number or dot)     | `V1`, `V2`, `V1.1`, `V3.5.2`  |
| `__` (double _)    | Separator between version and description    | Must be double underscores    |
| `<description>`    | A short name for the migration (for humans)  | `create_table`, `insert_data` |
| `.sql`             | The file extension for SQL scripts           | Required                      |

### Example File Names

- `V1__create_table.sql`
- `V2__insert_employee_data.sql`
- `V3__add_salary_column.sql`

---

### Wrong Examples (Invalid)

| File Name                    | Problem                              |
|-----------------------------|---------------------------------------|
| `v1__init.sql`              | `V` must be capitalized               |
| `V1_init.sql`               | Must use double underscores `__`     |
| `V2__add data.sql`          | Spaces not allowed in description     |
| `update.sql`                | No version → not a valid migration    |


