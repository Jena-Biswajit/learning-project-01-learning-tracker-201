package com.example;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*") // Applies to all URLs
public class LoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        logger.info("Request received at: {}", request.getRemoteAddr());

        // Continue the request chain
        chain.doFilter(request, response);

        logger.info("Response sent back to: {}", request.getRemoteAddr());
    }

    @Override
    public void destroy() {
        logger.info("LoggingFilter destroyed");
    }
}

