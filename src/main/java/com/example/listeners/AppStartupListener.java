package com.example.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppStartupListener implements ServletContextListener {

    // This method runs automatically when your web application starts up.
    //To log or perform setup when the app starts — very useful for initializing connections, config, etc.
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(" [AppStartupListener]Application started: " + sce.getServletContext().getContextPath());
    }

   //This method runs automatically when your web application shuts down.
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(" [AppStartupListener]Application stopped: " + sce.getServletContext().getContextPath());
    }
}
