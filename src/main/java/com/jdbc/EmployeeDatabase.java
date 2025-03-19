package com.jdbc;
import java.sql.*;

public class EmployeeDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "Bbiswajit@408";

    public void insertEmployee(String name, String department, double salary) {
        String query = "INSERT INTO Employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Employee inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, String name, String department, double salary) {
        String query = "UPDATE Employee SET name = ?, department = ?, salary = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Employee updated successfully."); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM Employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAllEmployees() {
        String query = "SELECT * FROM Employee";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Department: " + rs.getString("department") +
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectEmployeeById(int id) {
        String query = "SELECT * FROM Employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Department: " + rs.getString("department") +
                            ", Salary: " + rs.getDouble("salary"));
                } else {
                    System.out.println("No employee found with ID: " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeDatabase dao = new EmployeeDatabase();
        dao.insertEmployee("John Doe", "IT", 50000);
        dao.updateEmployee(1, "John Doe", "HR", 55000);
        dao.selectAllEmployees();
        dao.selectEmployeeById(1);
        dao.deleteEmployee(1);
    }
}
