package com.example.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(req.getInputStream(), User.class); // Deserialize JSON

        try (Connection conn = DBUtil.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String token = UUID.randomUUID().toString();
                TokenStore.tokenMap.put(token, user.getUsername());

                resp.setContentType("application/json");
                mapper.writeValue(resp.getOutputStream(), new TokenResponse(token)); // Serialize response
            } else {
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                resp.getWriter().write("Invalid credentials");
            }
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
    }

    // Simple inner class to return token as JSON
    public static class TokenResponse {
        public String token;

        public TokenResponse(String token) {
            this.token = token;
        }
    }
}
