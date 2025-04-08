### Authentication Filter in Servlet

### What is a Filter?
A **Filter** in a servlet application is used to intercept requests and responses to and from the servlet. It can:
- Log request/response data
- Modify headers
- Perform security checks
- Wrap requests/responses

### Purpose of `AuthFilter`
This custom `AuthFilter` checks for a custom request header named `X-Auth-Token`. If the token is missing or invalid, the request is denied.

---

### Code Explanation

### 1. Filter Class: `AuthFilter.java`
```java
package com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*") // applies to all requests
public class AuthFilter implements Filter {

    // This is our valid token for testing
    private static final String VALID_TOKEN = "123456";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[AuthFilter] Initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // Allow unauthenticated access to some endpoints if needed
        String path = req.getRequestURI();
        if (path.contains("health") || path.endsWith("index.jsp")) {
            chain.doFilter(request, response);
            return;
        }

        // Get token from header
        String token = req.getHeader("X-Auth-Token");

        // Validate token
        if (VALID_TOKEN.equals(token)) {
            System.out.println("[AuthFilter] ✅ Authenticated Request");
            chain.doFilter(request, response); // continue to servlet
        } else {
            System.out.println("[AuthFilter] ❌ Unauthorized Request");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.setContentType("application/json");
            resp.getWriter().write("{\"error\": \"Unauthorized - Invalid or Missing Token\"}");
        }
    }

    @Override
    public void destroy() {
        System.out.println("[AuthFilter] Destroyed");
    }
}
```

### 2. What Each Part Does
| Section                                  | Purpose                                             |
|------------------------------------------|-----------------------------------------------------|
| `@WebFilter("/students")`                | Applies the filter to requests matching `/students` |
| `authToken = httpRequest.getHeader(...)` | Reads custom token from header                      |
| Checks if token equals `123456`          | Allows only specific token for authentication       |
| `httpResponse.setStatus(...)`            | Sends HTTP 401 Unauthorized if token is invalid     |

---

### How to Test if Filter is Working

###  Successful Test
```bash
test post api using postman
```
- Response: JSON data returned
- Console Logs:
```
➡️ Request Received from IP: ::1
[AuthFilter] ✅ Authenticated Request
⬅️ Request Processing Finished
```

###  Failed Test (Missing/Invalid Token)
```bash
test post api using postman
```
- Response: `Unauthorized: Invalid Token`
- HTTP Status: `401`
- Console Logs:
```
➡️ Request Received from IP: ::1
[AuthFilter] ❌ Unauthorized Request
⬅️ Request Processing Finished
```

---

### Summary
- This `AuthFilter` adds basic security to your servlet.
- You can change the header name (`X-Auth-Token`) and value as needed.
- It uses `@WebFilter` to auto-register itself during deployment.
- You don’t need to change web.xml.

---

