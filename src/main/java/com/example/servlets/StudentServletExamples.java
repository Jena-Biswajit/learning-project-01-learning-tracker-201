package com.example.servlets;

import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Enumeration;

import com.example.daos.StudentDao;
import com.example.daos.StudentDaoImpl;
import com.example.dto.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/student")
public class StudentServletExamples extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(StudentServletExamples.class);
    private ObjectMapper objectMapper ; // Jackson ObjectMapper
    private StudentDao studentDao  ;

    @Override
    public void init() throws ServletException {
        super.init();
        objectMapper = new ObjectMapper();
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("[StudentServletExamples]Received POST request for Students");


        // Log Request Headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println("[StudentServletExamples]Request Header: " + name + " = " + value);
        }

        // Add a custom response header
        response.setHeader("X-Powered-By", "ServletHeaderExample");
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.print("{\"message\":\"Student created!\"}");
        out.flush();

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
        boolean inserted = false;
        try {
            inserted = studentDao.save(student) ;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (inserted) {
            // Convert Student object back to JSON
            String jsonResponse = objectMapper.writeValueAsString(student);

            // Set response headers and write JSON output
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse);

            logger.info("[StudentServletExamples]Updated Student JSON sent: {}", jsonResponse);
        } else {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert student");
        }
    }

    // Method to insert Student into the database

}
