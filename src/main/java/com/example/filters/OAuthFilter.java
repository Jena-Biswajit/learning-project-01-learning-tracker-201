//package com.example;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebFilter("/student")
//public class OAuthFilter implements Filter {
//
//    private static final String VALID_TOKEN = "mock-oauth-token-123"; // Mock token
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        String authHeader = httpRequest.getHeader("[OAuthFilter]Authorization");
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            String token = authHeader.substring(7); // Remove "Bearer "
//
//            if (VALID_TOKEN.equals(token)) {
//                System.out.println("✅ [OAuthFilter]OAuth token validated successfully.");
//                chain.doFilter(request, response);
//                return;
//            }
//        }
//
//        System.out.println("❌ [OAuthFilter]Invalid or missing OAuth token.");
//        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        httpResponse.getWriter().write("[OAuthFilter] Unauthorized: Invalid OAuth token.");
//    }
//}
