package com.example.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestLoggerListener implements ServletRequestListener {

    // This method is called when a request starts.
    // It logs the client's IP address using getRemoteAddr().
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("➡️ [RequestLoggerListener]Request Received from IP: " + sre.getServletRequest().getRemoteAddr());
    }

    // This method is called after the request is completed.
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("⬅️ [RequestLoggerListener]Request Processing Finished");
    }
}

