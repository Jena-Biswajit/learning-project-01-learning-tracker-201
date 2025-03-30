### Step-by-Step detailed explanation of Tomcat server Implementation

**Before starting, make sure you have installed:**
- Java JDK (Ensure Java 8+ is installed) . In my case i'm using java-21
- Apache Tomcat (Version 9 or above) . In my case i'm using Tomcat-10
- Maven (for dependency management)

**Command to verify Java Version**
```
java --version
```

**Check Maven version:**
```
mvn -version
```

**Check the Tomcat version**
- For mac
```
$ ./catalina.sh version
```
- For windows 
```
catalina.bat version
```

### Set Up Maven Project for Servlet

**Create a new Maven project:**
- If you are using intelliJ idea : Then follow these steps .
  - Open IDE : 
     step-1: open new-project
     step-2: Go to generator and select Maven Archetype
     step-3: In Maven Archetype : 
             select Name : name of project
             Location : workspace to create your project 
             JDK : Chose as per you downloaded version
             Archetype : org.apache.maven.archetypes:maven-archetype-webapp 

- **OR** : Use command 
```
mvn archetype:generate -DgroupId=com.example -DartifactId=ServletDemoJson -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
```

### Configure pom.xml for Dependencies

```
    <!-- Servlet API -->
    <dependency>
      <groupId>jakarta.servlet</groupId>
      <artifactId>jakarta.servlet-api</artifactId>
      <version>6.0.0</version>
      <scope>provided</scope>
    </dependency>

    <!-- Logback (SLF4J API + Logback implementation) -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.4.11</version>
    </dependency>

    <!--  JSON Dependency  -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.16.0</version>
    </dependency>

  </dependencies>
  <build>
    <finalName>ExampleMavenTomcat</finalName>

    <plugins>
      <!-- Maven Compiler Plugin: Set Java version -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>  <!-- Ensure you're using at least 3.8.1 -->
        <configuration>
          <release>21</release>  <!-- Ensures compatibility with Java 21 -->
        </configuration>
      </plugin>

      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.3.2</version>
      </plugin>
    </plugins>
  </build>
</project>
```

###  Implement the ServletDemoJson Class
- Create a ServletDemoJson file inside src/main/java/com/example/ServletDemoJson 

```
package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/employee")
public class ServletDemoJson extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ServletDemoJson.class);
    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

    // Database Credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Employee?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root"; // Change username
    private static final String JDBC_PASSWORD = "subhasmita"; // Change password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Received POST request for Employee");

        // Read JSON request body
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        }
        String jsonInput = jsonBuffer.toString();
        logger.info("Received JSON: {}", jsonInput);

        // Convert JSON to Employee object
        Employee employee = objectMapper.readValue(jsonInput, Employee.class);

        // Insert Employee into database
        boolean inserted = insertEmployeeIntoDatabase(employee);

        if (inserted) {
            // Modify salary (increase by 10%)
            employee.setSalary(employee.getSalary() * 1.1);

            // Convert Employee object back to JSON
            String jsonResponse = objectMapper.writeValueAsString(employee);

            // Set response headers and write JSON output
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse);

            logger.info("Updated Employee JSON sent: {}", jsonResponse);
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert employee");
        }
    }

    // Method to insert Employee into the database
    private boolean insertEmployeeIntoDatabase(Employee employee) {
        try {
            // Ensure the driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(
                         "INSERT INTO Employee (name, age, salary) VALUES (?, ?, ?)")) {

                logger.info("Database connected successfully!");

                statement.setString(1, employee.getName());
                statement.setInt(2, employee.getAge());
                statement.setDouble(3, employee.getSalary());

                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (ClassNotFoundException e) {
            logger.error("MySQL JDBC Driver not found", e);
        } catch (SQLException e) {
            logger.error("Database error: {}", e.getMessage());
        }
        return false;
    }
}
```

**Expected O/p** :
```
![db_con-log.png](..%2F..%2F..%2F..%2F..%2FDesktop%2Fall_apps%2Fscreenshots%2Fdb_con-log.png)
```

### Build and Deploy to Tomcat
**Build the WAR File**
```
mvn clean package
```

**Deploy to Tomcat**

- Copy the WAR file to Tomcat’s webapps/ directory:
```
cp target/ExampleMavenTomcat.war /path/to/tomcat/webapps/
```

**Start Tomcat:**
- Open bin folder of /path/to/tomcat
- cd /path/to/tomcat/bin
- ./startup.sh  # (Linux/macOS)
- ./catalina.sh start ((Linux/macOS))

**Stop Tomcat:**
- Open bin folder of /path/to/tomcat
- cd /path/to/tomcat/bin
- ./shutdown.sh
- ./catalina.sh stop

### View Tomcat Logs
- If the deployment fails, check Tomcat’s logs for error messages.
```
tail -f /path/to/tomcat/logs/catalina.out
```

### Command to check the number of process running in same port :
```
lsof -i :8080
```

### Store Employee data in Database 
### Check MySQL version:
```shell
mysql --version
```
- If returns nothing then download and setup required db .

**Verify Database Connection*
```shell
mysql -u root -p
```
- Then, verify the table structure:
```shell
SHOW TABLES;
DESC Employee;
```
**Example**
```shell
private boolean insertEmployeeIntoDatabase(Employee employee) {
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
         PreparedStatement statement = connection.prepareStatement(
                 "INSERT INTO Employee (name, age, salary) VALUES (?, ?, ?)")) {
    
        logger.info("Database connected successfully!");
    
        statement.setString(1, employee.getName());
        statement.setInt(2, employee.getAge());
        statement.setDouble(3, employee.getSalary());
    
        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }
    } catch (ClassNotFoundException e) {
    logger.error("MySQL JDBC Driver not found", e);
    } catch (SQLException e) {
    logger.error("Database error: {}", e.getMessage());
}
```
**Expected O/P**
```shell
![Employee_tbl-mySql.png](..%2F..%2F..%2F..%2F..%2FDesktop%2Fall_apps%2Fscreenshots%2FEmployee_tbl-mySql.png)
```

### Test API Using cURL
- Test using Postman or curl 

**By postman**
- go to postman and check api using Post method .

**By curl**
```shell
curl -X POST http://localhost:8080/ServletDemo/employee \
     -H "Content-Type: application/json" \
     -d '{"name": "John Doe", "age": 30, "salary": 50000}'

```


