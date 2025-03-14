package com.jdbc;
import java.sql.*;

public class JdbcJoinExample {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "subhasmita";

        // SQL queries for different types of joins
        String innerJoinQuery = "SELECT employees.id, employees.name, departments.name " +
                "FROM employees INNER JOIN departments ON employees.dept_id = departments.id";

        String leftJoinQuery = "SELECT employees.id, employees.name, departments.name " +
                "FROM employees LEFT JOIN departments ON employees.dept_id = departments.id";

        String rightJoinQuery = "SELECT employees.id, employees.name, departments.name " +
                "FROM employees RIGHT JOIN departments ON employees.dept_id = departments.id";

        // Full Outer Join (Using UNION since MySQL does not support FULL OUTER JOIN)
        String fullOuterJoinQuery = "SELECT employees.id, employees.name, departments.name " +
                "FROM employees LEFT JOIN departments ON employees.dept_id = departments.id " +
                "UNION " +
                "SELECT employees.id, employees.name, departments.name " +
                "FROM employees RIGHT JOIN departments ON employees.dept_id = departments.id";

        String crossJoinQuery = "SELECT employees.name, departments.name " +
                "FROM employees CROSS JOIN departments";

        String selfJoinQuery = "SELECT A.name AS Employee, B.name AS Manager " +
                "FROM employees A INNER JOIN employees B ON A.manager_id = B.id";

        try {
            // Establishing connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Executing different join queries
            System.out.println("INNER JOIN Results:");
            executeQuery(conn, innerJoinQuery);

            System.out.println("\nLEFT JOIN Results:");
            executeQuery(conn, leftJoinQuery);

            System.out.println("\nRIGHT JOIN Results:");
            executeQuery(conn, rightJoinQuery);

            System.out.println("\nFULL OUTER JOIN Results:");
            executeQuery(conn, fullOuterJoinQuery);

            System.out.println("\nCROSS JOIN Results:");
            executeQuery(conn, crossJoinQuery);

            System.out.println("\nSELF JOIN Results:");
            executeQuery(conn, selfJoinQuery);

            // Closing connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to execute and print query results
    private static void executeQuery(Connection conn, String query) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();

        // Getting column count dynamically
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // Printing results
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i) + ": " + rs.getString(i) + " | ");
            }
            System.out.println();
        }
        rs.close();
        pstmt.close();
    }
}
