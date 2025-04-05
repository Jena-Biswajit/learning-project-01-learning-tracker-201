### OAuth Filter Implementation 

- This document explains how to implement and test an **OAuth Filter** in a Java Servlet-based web application.

---

### Goal
To authenticate incoming HTTP requests using a **Bearer Token** (OAuth-style) in the request header.

---

### Java Class: `OAuthFilter.java`

```java
package com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/student")
public class OAuthFilter implements Filter {

    private static final String VALID_TOKEN = "mock-oauth-token-123"; // Mock token

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Remove "Bearer "

            if (VALID_TOKEN.equals(token)) {
                System.out.println("✅ OAuth token validated successfully.");
                chain.doFilter(request, response);
                return;
            }
        }

        System.out.println("❌ Invalid or missing OAuth token.");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("Unauthorized: Invalid OAuth token.");
    }
}
```

---

## 📌 Explanation - Line by Line

| Line                     | Description                                                          |
|--------------------------|----------------------------------------------------------------------|
| `@WebFilter("/student")` | This filter applies only to `/student` endpoint                      |
| `VALID_TOKEN`            | A mock OAuth token that the server accepts                           |
| `Authorization` header   | Expected in the format `Bearer <token>`                              |
| `substring(7)`           | Extracts the token by removing `Bearer ` prefix                      |
| `chain.doFilter(...)`    | Passes the request to the next filter or servlet if token is valid   |
| `SC_UNAUTHORIZED`        | Sends HTTP 401 if token is invalid or missing                        |

---

### How to Test in Postman

1. Open Postman and select **POST** method.
2. URL: `http://localhost:8080/your-app-name/student`
3. Go to **Headers** tab:
    - Key: `Authorization`
    - Value: `Bearer mock-oauth-token-123`
4. Go to **Body** tab → choose **raw** → select **JSON** type
5. Enter JSON payload:

```json
{
  "name": "John",
  "age": 22
}
```

6. Click **Send**.

###  Valid Token Output
- Status: `200 OK`
- Output: JSON with student info
- Console log: `✅ OAuth token validated successfully.`

### ❌ Invalid Token Test
- Change token to `Bearer invalid-token`
- Status: `401 Unauthorized`
- Output: `Unauthorized: Invalid OAuth token.`
- Console log: `❌ Invalid or missing OAuth token.`

---

### Common Issues

### 1. Multiple Filters Conflict
- If you have another filter like `AuthFilter` on `/*`, it might run **before** `OAuthFilter` and reject the request.

###  Fix
- Either disable conflicting filter
- OR exclude `/student` path from that filter

### 2. Missing Header
- Ensure that `Authorization` header is sent correctly from Postman.

---

## 📦 Summary
- Implemented `OAuthFilter` for `/student`
- Validates `Authorization: Bearer <token>`
- Can be tested using Postman
- Protects your endpoint from unauthorized access

---

