### Servlet Filters 

---

### What is a Filter?

A **Filter** in Java Servlet is a reusable class that can:
- Intercept **incoming requests** before they reach the servlet (pre-processing)
- Intercept **outgoing responses** before they go to the client (post-processing)

---

### Use Cases of Filters

- Logging (e.g., requests/responses)
- Authentication / Authorization
- Input Validation
- Compression / Encryption
- Modifying Request or Response Headers
- Wrapping Request/Response Objects

---

### Basic Concepts

### `Filter` Interface Methods:
| Method         | Description                                      |
|----------------|--------------------------------------------------|
| `init()`       | Called when the filter is initialized (once)     |
| `doFilter()`   | Called every time a request/response is passed   |
| `destroy()`    | Called when the filter is removed (server stops) |

---

### Example: Logging Filter Implementation

### Filter Class

```java
package com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*") // This filter applies to all incoming requests
public class LoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(com.example.filters.LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        logger.info("Request received at: {}", request.getRemoteAddr());

        // Continue the rest of the filter chain (next filter or servlet)
        chain.doFilter(request, response);

        logger.info("Response sent back to: {}", request.getRemoteAddr());
    }

    @Override
    public void destroy() {
        logger.info("LoggingFilter destroyed");
    }
}
```
---

### How to Compile & Deploy?
- Open terminal and run: ```mvn clean package```
- Copy the target/YourApp.war file to: ```tomcat/webapps/```
- Start Tomcat: ```./startup.sh```

### How to Test If Filter Works?
- Open Postman or browser and hit: ```POST http://localhost:8080/YourApp/student```

### What Happens When You Shut Down Server?
- If you shut down Tomcat using: ```./shutdown.sh```
- You will see in logs: ```INFO LoggingFilter destroyed```