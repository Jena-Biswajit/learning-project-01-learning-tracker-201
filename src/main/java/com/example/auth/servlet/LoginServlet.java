package com.example.auth.servlet;

import com.example.auth.dao.UserDAO;
import com.example.auth.model.Token;
import com.example.auth.model.User;
import com.example.auth.service.AuthService;
import com.example.auth.util.TokenManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final AuthService authService;

    // Constructor where we inject dependencies: UserDAO and TokenManager
    public LoginServlet() {
        Connection conn = null;
        this.authService = new AuthService(new UserDAO(conn), new TokenManager());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        // Create ObjectMapper for JSON conversion
        ObjectMapper mapper = new ObjectMapper();

        // Read the JSON from request body and map to User object
        User user = mapper.readValue(req.getInputStream(), User.class);

        // Extract username and password from the User object
        String username = user.getUsername();
        String password = user.getPassword();

        // Authenticate user using AuthService
        String token = null;
        try {
            token = authService.authenticateUser(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // If token is generated successfully, respond with 200 OK and the token
        if (token != null) {
            resp.setStatus(HttpServletResponse.SC_OK);
            Token newToken = new Token(token); // Create Token object
            mapper.writeValue(resp.getOutputStream(), newToken); // Serialize and write the token as JSON
        } else {
            // If authentication fails, respond with 401 Unauthorized
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            Error error = new Error("Invalid credentials");
            mapper.writeValue(resp.getOutputStream(), error); // Serialize and send the error as JSON
        }
    }
}
