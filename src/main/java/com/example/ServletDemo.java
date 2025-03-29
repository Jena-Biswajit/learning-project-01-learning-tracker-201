package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/hello")
public class ServletDemo extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ServletDemo.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Processing GET request");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello, Munna!</h1>");

        logger.info("Response sent: Hello, World!");
    }
}
