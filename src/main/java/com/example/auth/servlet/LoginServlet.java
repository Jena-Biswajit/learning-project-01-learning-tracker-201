package com.example.auth.servlet;

//import com.yourapp.service.AuthService;
import com.example.auth.dao.UserDAO;
import com.example.auth.service.AuthService;
import com.example.auth.util.TokenManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Importing custom utility class for DB connection
import com.example.auth.DBUtil;

// Importing Java I/O and SQL classes
import java.io.*;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final AuthService authService;

    public LoginServlet() {
        this.authService = new AuthService(new UserDAO(), new TokenManager());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String token = authService.authenticateUser(username, password);

        if (token != null) {
            resp.setStatus(HttpServletResponse.SC_OK);  // 200 OK
            resp.getWriter().println("{\"token\": \"" + token + "\"}");
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  // 401 Unauthorized
            resp.getWriter().println("{\"message\": \"Invalid credentials\"}");
        }
    }
}