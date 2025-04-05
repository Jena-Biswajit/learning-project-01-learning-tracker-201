### Servlet Headers

---

### What are HTTP Headers?

**Headers** are metadata sent between the client and server.  
They contain information like:
- Content type
- Encoding
- Caching rules
- Authorization tokens
- Custom app-specific info

---

### Servlet APIs for Headers

### From `HttpServletRequest`:
- `getHeader(String name)` — Get the value of a specific header.
- `getHeaderNames()` — Get all header names.
- `getHeaders(String name)` — Get all values (for repeated headers).

### From `HttpServletResponse`:
- `setHeader(String name, String value)` — Set a header.
- `addHeader(String name, String value)` — Add an extra header value.

---

### Use Cases of Headers

| Use Case            | Example                           |
|---------------------|------------------------------------|
| Content negotiation | `Accept: application/json`        |
| CORS setup          | `Access-Control-Allow-Origin: *`  |
| Authentication      | `Authorization: Bearer token`     |
| Custom headers      | `X-App-Version: 1.0`              |

---

### Example: Logging Request Headers + Adding Response Header

### Modify Your Servlet: `StudentServletExamples.java`

```java
package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.Enumeration;

@WebServlet("/student")
public class StudentServletExamples extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Log Request Headers
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println("Request Header: " + name + " = " + value);
        }

        // Add a custom response header
        resp.setHeader("X-Powered-By", "ServletHeaderExample");
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        out.print("{\"message\":\"Student created!\"}");
        out.flush();
    }
}