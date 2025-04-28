package com.example.auth.servlet;

//package com.yourapp.servlet;

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


@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private final AuthService authService;

    public SignupServlet() {
        Connection conn = null;
        this.authService = new AuthService(new UserDAO(conn), new TokenManager());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (authService.userExists(username)) {
            resp.setStatus(HttpServletResponse.SC_CONFLICT); // 409 Conflict
            resp.getWriter().println("{\"message\": \"User already exists\"}");
        } else {
            authService.registerUser(username, password);
            resp.setStatus(HttpServletResponse.SC_CREATED); // 201 Created
            resp.getWriter().println("{\"message\": \"User registered successfully\"}");
        }
    }
}