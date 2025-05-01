package com.example.auth.servlet;

import com.example.auth.model.User;
import com.example.auth.model.Error;
import com.example.auth.model.Success;
import com.example.auth.service.AuthService;
import com.example.auth.dao.UserDAO;
import com.example.auth.util.DBConnectionManager;
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

    private AuthService authService;  // Instance variable

    //  Constructor where we inject dependencies
    public SignupServlet() throws SQLException {
        this.authService = new AuthService(new UserDAO(), new TokenManager());  // Create AuthService instance
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();

        try {
            Connection conn = DBConnectionManager.getConnection();
            // Read the JSON from request body and map to User object
            User user = mapper.readValue(req.getInputStream(), User.class);

            // Attempt to sign up the user using AuthService
            String token = authService.signup(user);  // Now calling non-static signup()

            if (token != null) {

                // If signup is successful, return the token
                resp.setStatus(HttpServletResponse.SC_OK);
                Success success = new Success("Signup successful");
                mapper.writeValue(resp.getOutputStream(), success);  // Serialize and write the token as JSON

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
