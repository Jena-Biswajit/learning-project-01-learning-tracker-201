### Apache Tomcat

- Apache Tomcat is an **open-source web server** and ***servlet container** used to deploy and run Java-based web applications.
- Widely used for running Java Servlets, JSP (JavaServer Pages), and Java Web Applications.

### Step by step of using Tomcat

***Start Tomcat Using .bat File in bin Folder***
  - Navigate to the bin directory inside the extracted Tomcat folder.
  - Run the following command in the terminal (Command Prompt):

### List of Tomcat Folders
  - After extracting Tomcat, you will see the following folders:

    **bin** – Contains startup and shutdown scripts (startup.bat, shutdown.bat).

    **conf** – Configuration files, including server.xml, web.xml.

    **lib** – Contains required libraries (JAR files).

    **logs** – Stores log files.

    **webapps** – The folder where deployed web applications are stored.

    **temp** – Temporary files used by Tomcat.

    **work** – Used for compiled JSP files.

### Check Tomcat Logs
  - Logs are stored in the logs directory.
  - To view logs, check the catalina.out

### Access Tomcat URL
  - By default, Tomcat runs on port 8080.
```
http://localhost:8080
```

### Why Do We Need Tomcat?
  1. To Run Java Web Applications 
    - Java-based web applications need a server to execute Java Servlets and JSP pages.
    - Tomcat provides a lightweight, fast, and reliable environment for these applications.

  2. Servlet and JSP Support
    - Tomcat is specifically designed to execute servlets and JSP files, which generate dynamic web content.

  3. HTTP Web Server for Java  
    - Tomcat acts as a web server for Java applications, handling HTTP requests and responses.

  4. Enterprise Applications Deployment
    - Many enterprise-level applications use Tomcat as a middleware to serve Java-based web applications.

### Uses of Apache Tomcat
  1. Hosting Java Web Applications
    - Tomcat is widely used to deploy and manage Java-based web applications.

  2. Running Servlets & JSP
    - It is used to run Java Servlets and JSP pages, which are essential for Java-based web development.

  3. Load Balancing & Scalability
    - Tomcat can be configured to handle high traffic by using clustering and load balancing.

  4. Secure Web Applications
    - Tomcat supports HTTPS, SSL/TLS encryption, and authentication mechanisms, making it a secure choice for web applications.

  5. Embedded Tomcat in Applications  
    - Developers often use embedded Tomcat in Spring Boot applications to run Java web apps without installing a separate server.

### How Tomcat Works?
  1. Receives HTTP Request
   - A user sends a request (e.g., http://localhost:8080).

  2. Processes the Request
   - Tomcat processes the request using servlets and JSP.

  3. Generates Response
   - The servlet/JSP executes the business logic and returns an HTML response.

  4. Sends Response to Client
   - The response is sent back to the web browser.  


### What is a Servlet?

- A Servlet is a Java program that runs on a web server and handles HTTP requests & responses.
- It is used to create dynamic web applications (like login pages, form submissions, etc.).

### Why Use Servlets?
  - Handles HTTP requests & responses (GET, POST, etc.).
  - Generates dynamic content (unlike static HTML).
  - Can interact with databases, APIs, and other web services.
  - Runs inside a Servlet Container (like Tomcat).

### How Does a Servlet Work?

  1. Client (Browser) sends a request (e.g., typing http://localhost:8080/MyApp/LoginServlet).
  2. Tomcat (Servlet Container) receives the request.
  3. Tomcat calls the corresponding Servlet (LoginServlet.java).
  4. Servlet processes the request (fetch data, validate, etc.).
  5. Servlet generates a response (HTML page, JSON, etc.).
  6. Tomcat sends the response back to the client.

### Servlet Flow Diagram

```
Client (Browser)  --->  Tomcat  --->  Servlet  --->  Process Request  --->  Generate Response  --->  Back to Client
```



