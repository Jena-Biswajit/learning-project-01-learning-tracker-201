package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//The class implements Filter interface, which means: It can intercept and process HTTP requests/responses.
// To define custom logic to run before and after any servlet is called.
@WebFilter("/*") // Applies to all URLs
public class LoggingFilter implements Filter {

    //Helps in debugging, tracking requests, or auditing user actions.
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);


    //Runs once when the filter is first created (during app startup).
    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("[LoggingFilter]LoggingFilter initialized");
    }


    //
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Logs the incoming request’s IP address.
        logger.info("[LoggingFilter]Request received at: {}", request.getRemoteAddr());

        // Passes the request to the next filter or servlet.
        chain.doFilter(request, response);

        // Logs after the response is generated (i.e., going back to the client)
        logger.info("[LoggingFilter]Response sent back to: {}", request.getRemoteAddr());
    }


    // Runs when the application is shutting down or the filter is removed.
    @Override
    public void destroy() {
        logger.info("[LoggingFilter]LoggingFilter destroyed");
    }
}

