//package com.example.auth.filters;
//
//import com.example.auth.model.Error;
//import com.example.auth.model.Success;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//
//@WebServlet("/api/hello")
//public class AuthFilter extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        // Extract the Authorization header (the token is just a UUID string, no "Bearer " prefix)
//        String authHeader = req.getHeader("Authorization");
//
//        // If the Authorization header is missing or the token is invalid, return a 401 Unauthorized response
//        if (authHeader == null || !isValidToken(authHeader)) {
//            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
//            resp.setContentType("application/json");
//
//            // Create ObjectMapper to serialize error message as JSON
//            ObjectMapper mapper = new ObjectMapper();
//            Error error = new Error("Unauthorized access. Please provide a valid token.");
//            mapper.writeValue(resp.getOutputStream(), error); // Serialize and send the error as JSON
//            return; // Don't proceed to send the success message if the user is not authenticated
//        }
//
//        resp.setContentType("application/json");
//        ObjectMapper mapper = new ObjectMapper();
//        Success success = new Success("Hello, authenticated user!");
//        mapper.writeValue(resp.getOutputStream(), success);
//    }
//
//    // Check if the token is valid (in this case, a valid UUID)
//    private boolean isValidToken(String authHeader) {
//
//
//        // Check if it's a valid UUID format (can be adjusted as needed)
//        String tokenPattern = "^[a-fA-F0-9-]{36}$"; // Regex for UUID
//        return authHeader != null && authHeader.matches(tokenPattern);
//
//    }
//}
//


package com.example.auth.filters;

import com.example.auth.model.Error;
import com.example.auth.servlet.TokenStore; // Added import for token store
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

@WebServlet("/api/*")
public class AuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    // pre processing
    System.out.println("req pre-processing: "+ Map.of(
        "url", req.getRequestURI(),
        "method", req.getMethod()
    ));

    boolean isAuthenticated = doAuthentication(req, response);

    if (!isAuthenticated) {
      System.out.println("user is not authenticated");
      return;
    }

    System.out.println("auth success: " + req.getRequestURI());

    System.out.println("req delegating: "+ Map.of(
        "url", req.getRequestURI(),
        "method", req.getMethod()
    ));

    filterChain.doFilter(servletRequest, servletResponse);

    System.out.println("req post-processing: "+ Map.of(
        "url", req.getRequestURI(),
        "method", req.getMethod()
    ));
  }

  private boolean doAuthentication(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // Extract the Authorization header (the token is just a UUID string, no "Bearer " prefix)
    String authTokenValue = req.getHeader("Authorization");
    // If the Authorization header is missing or the token is invalid, return a 401 Unauthorized response
    if (authTokenValue == null || !isValidToken(authTokenValue)) {
      resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized

      // Create ObjectMapper to serialize error message as JSON
      ObjectMapper mapper = new ObjectMapper();
      Error error = new Error("Unauthorized access. Please provide a valid token.");
      mapper.writeValue(resp.getOutputStream(), error); // Serialize and send the error as JSON
      return false;
    }

    return true;
  }

  // Check if the token is valid by checking presence in TokenStore
  private boolean isValidToken(String authTokenValue) {
    return authTokenValue != null && TokenStore.tokenMap.containsKey(authTokenValue);
  }
}
