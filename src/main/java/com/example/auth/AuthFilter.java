package com.example.auth;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebFilter("/api/hello")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String token = request.getHeader("token");
        if (token != null && TokenStore.tokenMap.containsKey(token)) {
            chain.doFilter(req, res);
        } else {
            response.setStatus(403);
            response.getWriter().write("Forbidden: Invalid token");
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
