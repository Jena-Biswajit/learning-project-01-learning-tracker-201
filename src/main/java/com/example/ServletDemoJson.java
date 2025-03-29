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

@WebServlet("/employee")
public class ServletDemoJson extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ServletDemo.class);
    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

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

        // Modify salary (increase by 10%)
        employee.setSalary(employee.getSalary() * 1.1);

        // Convert Employee object back to JSON
        String jsonResponse = objectMapper.writeValueAsString(employee);

        // Set response headers and write JSON output
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);

        logger.info("Updated Employee JSON sent: {}", jsonResponse);
    }
}
