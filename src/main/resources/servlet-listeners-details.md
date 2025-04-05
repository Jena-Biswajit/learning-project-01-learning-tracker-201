### Servlet Listener Feature in Java Web Applications

### What is a Listener?

A **Servlet Listener** is a special Java class that listens for **lifecycle events** in a servlet-based web application, such as:

- Application start/stop
- HTTP session creation/destruction
- Request initialization/destroy

Listeners let you execute custom logic automatically at these events.

---

### List of Listeners Implemented

| Listener Interface            | Triggered When                                         |
|------------------------------|--------------------------------------------------------|
| `ServletContextListener`     | Web app starts or stops                                |
| `HttpSessionListener`        | New session is created or invalidated                  |
| `ServletRequestListener`     | HTTP request is received or completed                  |

---

### 1. ServletContextListener

### File: `AppStartupListener.java`

```java
package com.example;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("🚀 Application started: " + sce.getServletContext().getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("🛑 Application stopped: " + sce.getServletContext().getContextPath());
    }
}
```

**Use Case**: Logging when the app is deployed or shut down.

---

### 2. HttpSessionListener

### File: `SessionListener.java`

```java
package com.example;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("📦 New session created with ID: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("❌ Session destroyed with ID: " + se.getSession().getId());
    }
}
```
**Use Case**: Track when users connect or leave.

---

###  3. ServletRequestListener

###  File: `RequestListener.java`

```java
package com.example;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("📥 Request received from IP: " + sre.getServletRequest().getRemoteAddr());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("📤 Request completed for IP: " + sre.getServletRequest().getRemoteAddr());
    }
}
```
**Use Case**: Monitor all HTTP requests to the server.

---

### How to Test if Listeners Work

###  1. Build WAR and Deploy
```bash
mvn clean package
```
Copy the generated WAR to:
```
$TOMCAT_HOME/webapps/
```

###  2. Start Tomcat Server
```bash
cd $TOMCAT_HOME/bin
./startup.sh
```

### 3. Open Logs or Console Output

### To test `ServletContextListener`:
- Check console right after starting Tomcat:
```
Application started: /StudentServletExamples-1.0
```
- When you stop Tomcat:
```
🛑 Application stopped: /StudentServletExamples-1.0
```

### To test `HttpSessionListener`:
- Open browser and send a request to your servlet (e.g., POST `/students`)

### To test `ServletRequestListener`:
- Send any HTTP request to your servlet.

---

### Verify WAR Includes Listeners

Run this:
```bash
jar tf StudentServletExamples-1.0.war | grep Listener
```

Expected output:
```
WEB-INF/classes/com/example/AppStartupListener.class
WEB-INF/classes/com/example/SessionListener.class
WEB-INF/classes/com/example/RequestListener.class
```

---

| Listener                 | Trigger Time                 | Testing Method                        |
|--------------------------|------------------------------|---------------------------------------|
| `ServletContextListener` | App start/stop               | Start/stop Tomcat and check console   |
| `HttpSessionListener`    | Session create/destroy       | Send request and close session        |
| `ServletRequestListener` | Each request begin/end       | Send any HTTP request to the servlet  |

