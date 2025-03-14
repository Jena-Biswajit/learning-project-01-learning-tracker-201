### SQL Guide

### Introduction
- SQL (Structured Query Language) used for storing, manipulating, and retrieving data in a structured format.
- SQL was invented by IBM and is widely used for handling large amounts of data in database servers such as MySQL, PostgreSQL, SQLite3, and more. 
- SQL queries help in data manipulation and gaining business insights.

---

### Query-1: Show Existing Databases
To list all existing databases, use:
```sql
SHOW DATABASES;
```
**Output:**
```
Existing database Name
information_schema
mysql
performance_schema
sakila
student
sys
world
```

### Query-2: Drop a Database
To delete a database (e.g., `student`), use:
```sql
DROP DATABASE student;
SHOW DATABASES;
```
**Output:**
```
Database Name
information_schema
mysql
performance_schema
sakila
sys
world
```

### Query-3: Create a Database
To create a new database (e.g., `bank`), use:
```sql
CREATE DATABASE bank;
SHOW DATABASES;
```
**Output:**
```
Database Name
bank
information_schema
mysql
performance_schema
sakila
sys
world
```

### Query-4: Using a Database
To select a database:
```sql
USE bank;
```

### Query-5: Create a Table
```sql
CREATE TABLE table_name (
   column1 datatype,
   column2 datatype,
   ...
);
```
**Example:**
```sql
CREATE TABLE IF NOT EXISTS Employee (
   EmployeeID int,
   FirstName varchar(55),
   LastName varchar(55),
   Email varchar(150),
   DOB date
);
```

### Query-6: Show Tables
```sql
SHOW TABLES;
```

### Query-7: Drop a Table
```sql
DROP TABLE table_name;
```

### Query-8: Insert Values into a Table
```sql
INSERT INTO Employee
VALUES(1111,'Dipak','Bera','dipakbera@gmail.com','1994-11-22');
```

### Query-9: Fetch Values from a Table
```sql
SELECT * FROM Employee;
```

### Query-10: Not Null Constraint
```sql
CREATE TABLE table_name (
  column1 datatype NOT NULL,
  column2 datatype,
 ...
);
```

### Query-11: Unique Constraint
```sql
CREATE TABLE table_name (
 column1 datatype UNIQUE,
 column2 datatype,
 ...
);
```
**Example:**
```sql
CREATE TABLE demo_table
(
EmployeeID int NOT NULL UNIQUE,
FirstName varchar(55),
LastName varchar(55)
);
```

---

### Key Concepts in SQL

### Primary Key
Ensures entries are neither null nor duplicate.
```sql
CREATE TABLE IF NOT EXISTS Customer(
CustID int NOT NULL,
FName varchar(55),
LName varchar(55),
Email varchar(100),
DOB date,
CONSTRAINT customer_custid_pk PRIMARY KEY(CustID)
);
```

### Foreign Key
Links two tables.
```sql
CREATE TABLE Account(
AccNo int NOT NULL,
AType varchar(20),
OBal int,
OD date,
CurBal int,
CONSTRAINT customer_AccNo_fk FOREIGN KEY(AccNo) REFERENCES Customer(CustID)
);
```

---

### SQL Commands

### ORDER BY
Sorts query results in ascending (default) or descending order.
```sql
SELECT column1, column2, ...
FROM table_name
ORDER BY column1, column2, ... ASC|DESC;
```

**Example:**
```sql
SELECT * FROM Account ORDER BY CurBal;
```

**Descending Order:**
```sql
SELECT * FROM Account ORDER BY CurBal DESC;
```

### GROUP BY
Groups results.
```sql
SELECT COUNT(AType) FROM Account GROUP BY AType;
```
**Output:**
```
AType	count(AType)
savings	2
current	2
```

---

### Join Operations

### LEFT JOIN
Returns all records from the left table and matching records from the right table.
```sql
SELECT column_name(s)
FROM table1
LEFT JOIN table2
ON table1.column_name = table2.column_name;
```

### RIGHT JOIN
Returns all records from the right table and matching records from the left table.
```sql
SELECT column_name(s)
FROM table1
RIGHT JOIN table2
ON table1.column_name = table2.column_name;
```

### INNER JOIN
Returns matching records from both tables.
```sql
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;
```

### FULL JOIN (Not in MySQL)
Returns all records from both tables.
```sql
SELECT column_name(s)
FROM table1
FULL OUTER JOIN table2
ON table1.column_name = table2.column_name;
```
**Alternative for MySQL:**
```sql
SELECT column_name(s) FROM table1
UNION
SELECT column_name(s) FROM table2;
```

### SELF JOIN
A regular join between aliases of the same table.
```sql
SELECT column_name(s)
FROM table1 T1, table1 T2
WHERE condition;
```

---

### SQL Clauses

### WHERE Clause
Filters data.
```sql
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```
**Example:**
```sql
SELECT AccNo, CurBal FROM Account WHERE CurBal >= 1000;
```

### HAVING Clause
Filters results based on aggregate functions.
```sql
SELECT column1, column2, ...
FROM table_name
HAVING condition;
```
**Example:**
```sql
SELECT AccNo, CurBal FROM Account HAVING CurBal = MAX(CurBal);
```
**Output:**
```
AccNo	CurBal
1111	6000
```

---