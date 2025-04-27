package com.example.auth;

// Importing Servlet API classes
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Importing custom utility class for DB connection
import com.example.auth.DBUtil;

// Importing Java I/O and SQL classes
import java.io.*;
import java.sql.*;

// Servlet mapped to the /signup endpoint
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Extracting 'username' and 'password' from POST form-data
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Setting response type to JSON
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();  //Prints formatted representations of objects to a text-output stream.
                                             // Used to send response body back

        //  // Try-with-resources to ensure DB connection is closed properly
        try (Connection conn = DBUtil.getConnection()) {

            // Check if user already exists
            String checkQuery = "SELECT COUNT(*) FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);      // Prepared to avoid SQL injection
            checkStmt.setString(1, username);                        // Binding the input username
            ResultSet rs = checkStmt.executeQuery();                              // Execute the SELECT query
            rs.next();                                                            // Move to the first (and only) row

            if (rs.getInt(1) > 0) {
                resp.setStatus(HttpServletResponse.SC_CONFLICT); // 409
                out.println("{\"message\": \"User already exists\"}");
                return;
            }

            // Insert new user
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password); // plain password for now, will improve later
            insertStmt.executeUpdate();

            resp.setStatus(HttpServletResponse.SC_OK);
            out.println("{\"message\": \"Signup successful\"}");

        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
