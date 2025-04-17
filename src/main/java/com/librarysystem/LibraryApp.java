package com.librarysystem;

import java.sql.*;
import java.util.Scanner;

public class LibraryApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Library");
            System.out.println("2. Add Genre");
            System.out.println("3. Add Book");
            System.out.println("4. Add User");
            System.out.println("5. Display Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1: addLibrary(); break;
                case 2: addGenre(); break;
                case 3: addBook(); break;
                case 4: addUser(); break;
                case 5: displayBooks(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option");
            }
        } while (choice != 0);
    }

    private static void addLibrary() {
        System.out.print("Enter library name: ");
        String name = scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO libraries (library_id, library_name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, generateId());
            stmt.setString(2, name);
            stmt.executeUpdate();
            System.out.println("Library added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addGenre() {
        System.out.print("Enter genre name: ");
        String name = scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO genres (genre_id, genre_name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, generateId());
            stmt.setString(2, name);
            stmt.executeUpdate();
            System.out.println("Genre added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre_id: ");
        int genreId = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt(); scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO books (book_id, title, author, genre_id, quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, generateId());
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setInt(4, genreId);
            stmt.setInt(5, quantity);
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addUser() {
        System.out.print("Enter first name: ");
        String fname = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lname = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO users (user_id, first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, generateId());
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.setString(4, email);
            stmt.setString(5, phone);
            stmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayBooks() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT b.book_id, b.title, b.author, g.genre_name, b.quantity FROM books b LEFT JOIN genres g ON b.genre_id = g.genre_id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nBooks:");
            while (rs.next()) {
                System.out.printf("ID: %d | Title: %s | Author: %s | Genre: %s | Qty: %d\n",
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre_name"),
                        rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int generateId() {
        // Simple random ID generator (you can improve this)
        return (int)(Math.random() * 100000);
    }
}
