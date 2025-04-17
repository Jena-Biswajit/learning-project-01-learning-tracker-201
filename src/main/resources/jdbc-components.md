### jdbc components
### Components of JDBC (Java Database Connectivity)

- JDBC (Java Database Connectivity) is an API in Java that allows applications to interact with databases. 
- It provides methods for querying and updating data in a database using Java. JDBC acts as a bridge between Java applications and database management systems (DBMS).

---

### 1. JDBC Components
JDBC consists of several components that help in establishing a connection, executing queries, and handling database results.

### (i) DriverManager
- Manages the set of JDBC drivers.
- Establishes a connection between Java applications and databases.
- Loads the appropriate driver based on the database.

**Example:**
```
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
```

---

### (ii) Driver
- A software component that enables JDBC to interact with the database.
- Different databases require different JDBC drivers (MySQL, Oracle, PostgreSQL, etc.).

**Example:**
```
Class.forName("com.mysql.cj.jdbc.Driver");
```
This loads the MySQL JDBC Driver.

---

### (iii) Connection
- Represents the connection between Java and the database.
- Used to execute SQL queries.

**Example:**
```
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
```
---

### (iv) Statement
- Used to execute static SQL queries.
- It does not accept parameters.

**Example:**
```
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
```

---

### (v) PreparedStatement
- Used for executing SQL queries that have parameters.
- More secure and efficient than `Statement`.

**Example:**
```
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Employee WHERE id = ?");
pstmt.setInt(1, 101);
ResultSet rs = pstmt.executeQuery();
```

---

### (vi) CallableStatement
- Used to execute stored procedures in a database.

**Example:**
```
CallableStatement cstmt = con.prepareCall("{call getEmployee(?)}");
cstmt.setInt(1, 101);
ResultSet rs = cstmt.executeQuery();
```

---

### (vii) ResultSet
- Stores the result of executed queries.
- Provides methods to navigate and retrieve data.

**Example:**
```
while (rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
}
```

---

### 2. Step-by-Step Implementation of JDBC in Java

### Step 1: Load the JDBC Driver
```
Class.forName("com.mysql.cj.jdbc.Driver");
```
---

### Step 2: Establish a Connection
```
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
```
---

### Step 3: Create a Statement
```
Statement stmt = con.createStatement();
```
---

### Step 4: Execute a Query
```
ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
while (rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
}
```
---

### Step 5: Close the Connection
```
con.close();
```

---

