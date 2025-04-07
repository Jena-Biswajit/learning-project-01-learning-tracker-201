package com.example.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;       // Represents a session event (created or destroyed).
import jakarta.servlet.http.HttpSessionListener;   // Interface for listening to session lifecycle.


// Implements HttpSessionListener, so it can respond to session creation/destruction
// this class should be called when a session is created or ends."
@WebListener
public class SessionCounterListener implements HttpSessionListener {

    //A static variable that tracks how many sessions are active.
    private static int sessionCount = 0;


    //Runs automatically when a new user connects to your app and a new session is created.
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
        System.out.println("🔵 [SessionCounterListener]New Session Created. Active Sessions: " + sessionCount);
    }


   // Runs automatically when a session is destroyed (timeout or user leaves).
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount--;
        System.out.println("🔴[SessionCounterListener] Session Destroyed. Active Sessions: " + sessionCount);
    }
}
