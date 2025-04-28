//package com.example.auth.servlet;
//
////package com.yourapp.servlet;
//
////import com.yourapp.service.AuthService;
//import com.example.auth.dao.UserDAO;
//import com.example.auth.model.Success;
//import com.example.auth.model.User;
//import com.example.auth.service.AuthService;
//import com.example.auth.util.TokenManager;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//// Importing custom utility class for DB connection
//import com.example.auth.util.DBConnectionManager;
//
//// Importing Java I/O and SQL classes
//import java.io.*;
//import java.sql.*;
//
//
//@WebServlet("/signup")
//public class SignupServlet extends HttpServlet {
//
//    private final AuthService authService;
//
//    public SignupServlet() {
//        Connection conn = null;
//        this.authService = new AuthService(new UserDAO(conn), new TokenManager());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String username = req.getParameter("username");
////        String password = req.getParameter("password");
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        // Read the JSON from request body and map to User object
//        User user = mapper.readValue(req.getInputStream(), User.class);
//
//        // Now you have the User object ready
//        String username = user.getUsername();
//        String password = user.getPassword();
//        resp.setContentType("application/json");
//
////        if (authService.userExists(username)) {
////            resp.setStatus(HttpServletResponse.SC_CONFLICT); // 409 Conflict
////            resp.getWriter().println("{\"message\": \"User already exists\"}");
////        } else {
////            authService.registerUser(username, password);
////            resp.setStatus(HttpServletResponse.SC_CREATED); // 201 Created
////            resp.getWriter().println("{\"message\": \"User registered successfully\"}");
////        }
//
//        if (authService.userExists(username)) {
//            resp.setStatus(HttpServletResponse.SC_CONFLICT); // 409 Conflict
//            Error error = new Error("User already exists");
//            mapper.writeValue(resp.getOutputStream(), error);
//        } else {
//
//            authService.registerUser(username, password);
//            resp.setStatus(HttpServletResponse.SC_CREATED); // 201 Created
//            Success success = new Success("User registered successfully");
//            mapper.writeValue(resp.getOutputStream(), success);
////            authService.registerUser(username, password);
////            resp.setStatus(HttpServletResponse.SC_CREATED); // 201 Created
////            Error success = new Error("User registered successfully");
////            mapper.writeValue(resp.getOutputStream(), success);
//        }
//    }
//}

package com.example.auth;

import com.example.auth.dao.UserDAO;
import com.example.auth.model.Token;
import com.example.auth.model.User;
import com.example.auth.service.AuthService;
import com.example.auth.util.TokenManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private final AuthService authService;

    // Constructor where we inject dependencies: UserDAO and TokenManager
    public SignupServlet() {
        Connection conn = null;
        this.authService = new AuthService(new UserDAO(conn), new TokenManager());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");

        // Create ObjectMapper for JSON conversion
        ObjectMapper mapper = new ObjectMapper();

        // Read the JSON from request body and map to User object
        User user = mapper.readValue(req.getInputStream(), User.class);

        // Extract username and password from the User object
        String username = user.getUsername();
        String password = user.getPassword();

        // Attempt to sign up the user using AuthService
        try {
            String token = authService.signup(user);  // Call the signup method

            if (token != null) {
                // If signup is successful, return the token
                resp.setStatus(HttpServletResponse.SC_OK);
                Token newToken = new Token(token);  // Create Token object
                mapper.writeValue(resp.getOutputStream(), newToken);  // Serialize and write the token as JSON
            } else {
                // If the user already exists, respond with conflict
                resp.setStatus(HttpServletResponse.SC_CONFLICT);  // 409 Conflict
                Error error = new Error("User already exists");
                mapper.writeValue(resp.getOutputStream(), error);  // Serialize and send the error as JSON
            }
        } catch (SQLException e) {
            // If there is any SQLException, respond with internal server error
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            Error error = new Error("Database error: " + e.getMessage());
            mapper.writeValue(resp.getOutputStream(), error);  // Serialize and send the error as JSON
        }
    }
}
