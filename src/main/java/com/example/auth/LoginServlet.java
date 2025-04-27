package com.example.auth;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter(); // print the formatted output to streams or files ex:

        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // credentials valid → generate token
                //UUIDs:A Universally Unique IDentifier (UUID) URN Namespace, section 4.2 "Algorithms for Creating a Time-Based UUID".
                String token = UUID.randomUUID().toString(); // The UUID is generated using a cryptographically strong pseudo random number generator.
                TokenStore.tokenMap.put(token, username);

                resp.setStatus(HttpServletResponse.SC_OK);
                out.printf("{\"token\":\"%s\"}", token);
            } else {
                // invalid credentials
                resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                out.println("{\"message\":\"Invalid credentials\"}");
            }
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.printf("{\"error\":\"%s\"}", e.getMessage());
        }
    }
}
