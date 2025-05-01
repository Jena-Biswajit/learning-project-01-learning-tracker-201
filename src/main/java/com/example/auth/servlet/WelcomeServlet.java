package com.example.auth.servlet;

import com.example.auth.dao.UserDAO;
import com.example.auth.model.Error;
import com.example.auth.model.Token;
import com.example.auth.model.User;
import com.example.auth.service.AuthService;
import com.example.auth.util.DBConnectionManager;
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

@WebServlet("/api/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.getWriter().write("Welcome Servlet Response");
    }
}
