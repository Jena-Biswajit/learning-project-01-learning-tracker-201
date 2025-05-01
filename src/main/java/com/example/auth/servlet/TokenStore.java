package com.example.auth.servlet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenStore {
    // token → username
    public static final Map<String, String> tokenMap = new ConcurrentHashMap<>();
}
