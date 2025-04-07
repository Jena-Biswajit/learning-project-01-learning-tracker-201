//package com.example;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebFilter("/*") // applies to all requests
//public class AuthFilter implements Filter {
//
//    // This is our valid token for testing
//    private static final String VALID_TOKEN = "123456";
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("[AuthFilter] Initialized");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//
//        // Allow unauthenticated access to some endpoints if needed
//        String path = req.getRequestURI();
//        if (path.contains("health") || path.endsWith("index.jsp")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        // Get token from header
//        String token = req.getHeader("X-Auth-Token");
//
//        // Validate token
//        if (VALID_TOKEN.equals(token)) {
//            System.out.println("[AuthFilter] ✅ Authenticated Request");
//            chain.doFilter(request, response); // continue to servlet
//        } else {
//            System.out.println("[AuthFilter] ❌ Unauthorized Request");
//            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            resp.setContentType("application/json");
//            resp.getWriter().write("{\"error\": \"Unauthorized - Invalid or Missing Token\"}");
//        }
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("[AuthFilter] Destroyed");
//    }
//}
