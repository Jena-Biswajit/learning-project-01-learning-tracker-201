### Debug through the servelt app and feature and undeerstand the code flow 

-  check the debug mode is on not : if not then Configure Remote Debugging in IntelliJ
  - Go to Run → Edit Configurations
  - Click ➕ → Select Remote JVM Debug
  - Fill as below:
  - Name: Tomcat Debug
  - Host: localhost 
  - Port: 8000 
  - Debugger mode: Attach to remote JVM

- 1st i gave breakpoint in each method's (sout) of my application to watch where the cursor is moving 
  when the application is start .

### Step-by-Step Debugging Flow

- STEP 1: 
  - start the application by running tomcat 
  - Set Breakpoint at contextInitialized() : this represent the event , like when the 
    app start
  - This method is triggered once when the application is deployed.
  - o/p : [AppStartupListener]Application started

- STEP 2: 
  - Set Breakpoint at sessionCreated() in HttpSessionListener .
  - This is triggered when a user first interacts with your app (first request).
  - o/p : [SessionCounterListener]New Session Created. Active Sessions:

- STEP 3:
  - Set Breakpoint at requestInitialized() : this method is called when a request starts.
  - This is triggered for every single request (POST). 

- Step 4: 
  - Set Breakpoints in: doFilter() of filter
  - init() – Called when the app starts
  - doFilter() – Called before and after servlet execution  .
  - Filters let you intercept requests/responses before reaching the servlet.

- Step -5
  - Set Breakpoints in: doPost :
  - response.getWriter() : Student created! 
  - jsonBuffer.toString() : to store json
  - insertStudentIntoDatabase : Database connected successfully

- Step - 6 
  - LoggingFilter : Response sent back to: {}",

step - 7
 - requestDestroyed : 
  - o/p : request processing finnished 

step - 8 
 -  then after stopped tomcat 
 - destroy() : Logging filter destoyed
 - contextDestroyed() : application stoped 

**Example**

```

```