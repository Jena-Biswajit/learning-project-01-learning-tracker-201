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

@WebServlet("/student")
public class StudentServletExamples extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(StudentServletExamples.class);
    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

    // Database Credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Employee?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root"; // Change username
    private static final String JDBC_PASSWORD = "subhasmita"; // Change password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Received POST request for Students");

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
        Student student = objectMapper.readValue(jsonInput, Student.class);

        // Insert Employee into database
        boolean inserted = insertStudentIntoDatabase(student);

        if (inserted) {

            // Convert Employee object back to JSON
            String jsonResponse = objectMapper.writeValueAsString(student);

            // Set response headers and write JSON output
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse);

            logger.info("Updated Student JSON sent: {}", jsonResponse);
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert student");
        }
    }

    // Method to insert Employee into the database
    private boolean insertStudentIntoDatabase(Student student) {
        try {
            // Ensure the driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(
                         "INSERT INTO student (id, name, age) VALUES (?, ?, ?)")) {

                logger.info("Database connected successfully!");

                statement.setInt(1, student.getId());
                statement.setString(2, student.getName());
                statement.setInt(3, student.getAge());

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
