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
import java.sql.*;

@WebServlet("/student")
public class StudentServletExamples extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(StudentServletExamples.class);
    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

    // Database Credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
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

        // Convert JSON to Student object
        Student student = objectMapper.readValue(jsonInput, Student.class);

        // Insert Student into database
        boolean inserted = insertStudentIntoDatabase(student);

        if (inserted) {
            // Convert Student object back to JSON
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

    // Method to insert Student into the database
    private boolean insertStudentIntoDatabase(Student student) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO student (name, age) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            logger.info("Database connected successfully!");

            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());

            int rowsInserted = statement.executeUpdate();

            // Retrieve generated ID if needed
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        student.setId(generatedKeys.getInt(1)); // Assuming Student has a setId() method
                    }
                }
            }

            return rowsInserted > 0;
        } catch (SQLException e) {
            logger.error("Database error: {}", e.getMessage(), e);
        }
        return false;
    }
}
