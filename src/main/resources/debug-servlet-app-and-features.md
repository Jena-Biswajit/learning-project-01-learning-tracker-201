### Debug through the servelt app and feature and undeerstand the code flow 

-  check the debug mode is on not : if not then Configure Remote Debugging in IntelliJ
  - Go to Run → Edit Configurations
  - Click ➕ → Select Remote JVM Debug
  - Fill as below:
  - Name: Tomcat Debug
  - Host: localhost 
  - Port: 8000 
  - Debugger mode: Attach to remote JVM

- 1st i gave breakpoint in each method (sout) of my application to watch where the cursor is moving 
  when the application is start .

### Step-by-Step Debugging Flow

- STEP 1: 
  - start the application by running tomcat . so after server is starts it will 1st lead to the
    ServletContextListener . 
  - Set Breakpoint at contextInitialized() of ServletContextListener interface : this represents the event , 
    like when the app starts.
  - This method is triggered once when the application is deployed.
  - o/p : [AppStartupListener]Application started

**Example**

---
![alt text](<application started  and filter initialized.png>)

---


- STEP 2: 
  - Set Breakpoint at sessionCreated() in HttpSessionListener .
  - Implements HttpSessionListener, so it can respond to session creation.
  - This is triggered when a user first interacts with your app (first request).
  - This class should be called when a session is created . 
  - And this method returns , o/p : [SessionCounterListener]New Session Created. Active Sessions:


- STEP 3:
  - Set Breakpoint at requestInitialized() of ServletRequestListener :
  - This method is called when a request starts.
  - It logs the client's IP address using getServletRequest().getRemoteAddr().
  - This method called to log or track where requests are coming from.
  - This is triggered for every single request (POST).  

**Example**

---
![alt text](<ServletRequestListener . request received ip.png>)

---


- Step 4:
  - Set Breakpoints in: doFilter() of filter . The class implements Filter interface, which means:
    It can intercept and process HTTP requests/responses.
  - init() – Runs once when the filter is first created (during app startup).
  - o/p :
  - doFilter() – Called before and after servlet execution.
  - This method Logs the incoming request’s IP address using request.getRemoteAddr() method .
  - o/p :
  - Filters let you intercept requests/responses before reaching the servlet.
  - ```chain.doFilter(request, response);``` : Passes the request to the next filter or servlet.

**Example**

---
![alt text](<request received at- filter .png>)

---


- Step -5
  - Before this step all the listener and filters are prints all initial logs.
  - Set Breakpoints in: doPost :
  - When a client (like a browser) sends a POST request (e.g., submitting a form), this method is triggered.
  - So when it will hit the doPost method it will log : [StudentServletExamples]Received POST request for Students 
    .let to know that post request received from client . Then it do all the operation .
  - response.getWriter() : Student created! 
  - Received JSON: {}.
  - [StudentServletExamples]Updated Student JSON sent: {}
  - insertStudentIntoDatabase : Database connected successfully


**Example**

---
![alt text](<dopost method.png>)

![alt text](<database created successfully.png>)

---


- Step - 6 
  - Then again it came to filter interface after response sent back to client .
  - LoggingFilter : Response sent back to: {}",


**Example**

---
![alt text](<ServletRequestListener log for completion of request.png>)

---


- step - 7
  - After the request process is complete . It goes to again requestDestroyed() of ServletRequestListener.
  - requestDestroyed : It called when request process from client is complete .
  - o/p : request processing finnished . 


**Example**

---
![alt text](<ServletRequestListener log for completion of request.png>)

---  

step - 8 
 - Then in last when server tomcat stopped it goes to destroy() method of filter and contextDestroyed() of ServletContextListener
   to log the process is complete and server is stopped 
 - destroy() : o/p : Logging filter destoyed
 - contextDestroyed() : o/p:  application stoped 

**Example**

---
![alt text](<filter log after shutdown tomcat server.png>)

![alt text](<contextDestroyed (application-stoped ).png>)

---  

**Example**

- follow these complete logs for more clarification

---
![alt text](<complete log.png>)

---