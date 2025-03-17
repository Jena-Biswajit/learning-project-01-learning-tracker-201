package com.project;

import java.sql.*;
import java.util.Scanner;

public class BusTravelingAgency {
    private static final String URL = "jdbc:mysql://localhost:3306/BusAgency";
    private static final String USER = "root";
    private static final String PASSWORD = "subhasmita";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Register\n2. Login\n3. View Buses\n4. Book Ticket");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                registerUser(scanner);
                break;
            case 2:
                loginUser(scanner);
                break;
            case 3:
                viewBuses();
                break;
            case 4:
                bookTicket(scanner);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void registerUser(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            System.out.println("User Registered Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loginUser(Scanner scanner) {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Invalid Credentials");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBuses() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM buses";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("BusID | BusName | Source | Destination | Seats");
            while (rs.next()) {
                System.out.println(rs.getInt("bus_id") + " | " +
                        rs.getString("bus_name") + " | " +
                        rs.getString("source") + " | " +
                        rs.getString("destination") + " | " +
                        rs.getInt("seats_available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void bookTicket(Scanner scanner) {
        System.out.print("Enter Your User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Bus ID to Book: ");
        int busId = scanner.nextInt();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO bookings (user_id, bus_id) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, busId);
            stmt.executeUpdate();
            System.out.println("Ticket Booked Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
