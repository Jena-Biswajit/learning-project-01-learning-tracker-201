### Introduction 
- SQL is a computer language that is used for storing, manipulating, and retrieving data in a structured format.


### Some important sql commands 

**SELECT -** extracts data from a database.

**UPDATE -** updates data in a database.

**DELETE -** deletes data from a database.

**INSERT INTO -** inserts new data into a database.

**CREATE DATABASE -** creates a new database.

**ALTER DATABASE -** modifies a database.

**CREATE TABLE -** creates a new table.

**ALTER TABLE -** modifies a table.

**DROP TABLE -** deletes a table.

**CREATE INDEX -** creates an index (search key).

**DROP INDEX -** deletes an index

### sequel important 


### SQL Commands with Detailed Explanation and Examples

### 1. SQL Commands Classification
SQL commands are mainly divided into four categories:

| **Category**                           | **Description**                                              |
|----------------------------------------|--------------------------------------------------------------|
| **DDL (Data Definition Language)**     | Defines the structure of the database (e.g., tables, schema) |
| **DML (Data Manipulation Language)**   | Manipulates and retrieves data in tables                     |
| **DCL (Data Control Language)**        | Controls access to the database                              |
| **TCL (Transaction Control Language)** | Manages transactions in SQL                                  |

---

### 2. SQL Commands List with Explanation and Examples

### **A. DDL (Data Definition Language) Commands**
DDL commands define and modify database structure.

#### 1. `CREATE`
Used to create tables, databases, indexes, or views.

##### **Example:** Creating a table
```sql
CREATE TABLE Employees (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Salary DECIMAL(10,2)
);
```

#### 2. `ALTER`
Used to modify an existing table by adding, modifying, or deleting columns.

##### **Example:** Adding a new column
```sql
ALTER TABLE Employees 
ADD COLUMN Department VARCHAR(50);
```

##### **Example:** Modifying a column data type
```sql
ALTER TABLE Employees 
MODIFY COLUMN Age SMALLINT;
```

##### **Example:** Dropping a column
```sql
ALTER TABLE Employees 
DROP COLUMN Salary;
```

#### 3. `DROP`
Deletes a table, database, or index permanently.

##### **Example:** Dropping a table
```sql
DROP TABLE Employees;
```

##### **Example:** Dropping a database
```sql
DROP DATABASE CompanyDB;
```

#### 4. `TRUNCATE`
Removes all records from a table but retains its structure.

##### **Example:**
```sql
TRUNCATE TABLE Employees;
```

#### 5. `RENAME`
Changes the name of a table.

##### **Example:**
```sql
RENAME TABLE Employees TO Staff;
```

---

### **B. DML (Data Manipulation Language) Commands**
DML commands handle data inside tables.

#### 1. `SELECT`
Retrieves data from the database.

##### **Example:** Fetch all employees
```sql
SELECT * FROM Employees;
```

##### **Example:** Fetch specific columns
```sql
SELECT Name, Salary FROM Employees WHERE Age > 30;
```

#### 2. `INSERT`
Adds new records to a table.

##### **Example:**
```sql
INSERT INTO Employees (ID, Name, Age, Salary) 
VALUES (1, 'John Doe', 30, 6000.00);
```

#### 3. `UPDATE`
Modifies existing records in a table.

##### **Example:**
```sql
UPDATE Employees 
SET Salary = Salary + 1000 
WHERE ID = 1;
```

#### 4. `DELETE`
Removes specific records from a table.

##### **Example:**
```sql
DELETE FROM Employees 
WHERE ID = 1;
```

---

### **C. DCL (Data Control Language) Commands**
DCL commands manage user access and permissions.

#### 1. `GRANT`
Provides specific privileges to users.

##### **Example:**
```sql
GRANT SELECT, INSERT 
ON Employees 
TO user1;
```

#### 2. `REVOKE`
Removes privileges from users.

##### **Example:**
```sql
REVOKE INSERT 
ON Employees 
FROM user1;
```

---

### **D. TCL (Transaction Control Language) Commands**
TCL commands manage transactions in SQL.

#### 1. `COMMIT`
Saves all changes permanently.

##### **Example:**
```sql
BEGIN;
UPDATE Employees 
SET Salary = Salary + 500 
WHERE ID = 2;
COMMIT;
```

#### 2. `ROLLBACK`
Reverts changes made in the current transaction.

##### **Example:**
```sql
BEGIN;
UPDATE Employees 
SET Salary = Salary - 500 
WHERE ID = 3;
ROLLBACK;
```

#### 3. `SAVEPOINT`
Creates a checkpoint in a transaction.

##### **Example:**
```sql
BEGIN;
UPDATE Employees 
SET Salary = 7000 
WHERE ID = 4;
SAVEPOINT sp1;
UPDATE Employees 
SET Salary = 6500 
WHERE ID = 4;
ROLLBACK TO sp1;
COMMIT;
```

---

### **3. SQL Constraints**
Constraints ensure data integrity by defining rules on table columns.

| **Constraint** | **Description** |
|--------------|----------------|
| `NOT NULL`  | Ensures a column cannot have NULL values. |
| `UNIQUE`    | Ensures all values in a column are unique. |
| `PRIMARY KEY` | Combines `NOT NULL` and `UNIQUE`. Identifies each record uniquely. |
| `FOREIGN KEY` | Establishes a relationship between two tables. |
| `CHECK`     | Ensures that values meet a specified condition. |
| `DEFAULT`   | Assigns a default value if no value is provided. |

##### **Example:** Applying Constraints
```sql
CREATE TABLE Employees (
    ID INT PRIMARY KEY,       -- Unique and not null
    Name VARCHAR(50) NOT NULL, -- Cannot be null
    Age INT CHECK (Age > 18),  -- Must be greater than 18
    Salary DECIMAL(10,2) DEFAULT 5000.00, -- Default salary
    DeptID INT,
    FOREIGN KEY (DeptID) REFERENCES Departments(ID) -- Must exist in Departments table
);
```

---

