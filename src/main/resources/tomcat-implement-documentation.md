### Step-by-Step Process of Tomcat implementation

### Build and Deploy a Java Servlet Application on Tomcat

### Step 1: Build the WAR File
A **WAR (Web Application Archive) file** is a package that contains your **Java web application** and is used for deployment in **Tomcat**.

### 1.1 Navigate to Your Project Folder
Open a terminal or command prompt and go to your Maven project directory:
```sh
cd /path/to/your/ServletDemo
```

### 1.2 Clean and Build the Project
Run the following Maven command to clean and build the project:
```sh
mvn clean package
```
- The `clean` command removes any previously compiled files.
- The `package` command compiles the project and generates a WAR file in the `target/` directory.

### 1.3 Locate the WAR File
After the build process completes, the `ServletDemo.war` file will be generated inside:
```
/path/to/your/ServletDemo/target/ServletDemo.war
```

---

### Step 2: Deploy the WAR File to Tomcat

### 2.1 Locate Tomcat’s Webapps Directory
Find the **webapps/** folder inside your Tomcat installation.  
For example, if you installed Tomcat in `/opt/tomcat`, the webapps folder will be:
```sh
/opt/tomcat/webapps/
```
On Windows, it may be:
```
C:\apache-tomcat-9.0\webapps\
```

### 2.2 Copy the WAR File to the Webapps Directory
Run the following command to copy the generated WAR file to Tomcat’s `webapps` directory:

**On Linux/macOS:**
```sh
cp target/ServletDemo.war /path/to/tomcat/webapps/
```

**On Windows (Command Prompt):**
```sh
copy target\ServletDemo.war C:\apache-tomcat-9.0\webapps\
```

---

### Step 3: Start Tomcat Server
Once the WAR file is in the `webapps/` directory, start the Tomcat server.

### 3.1 Start Tomcat (Linux/macOS)
Go to the Tomcat `bin/` directory and run:
```sh
cd /path/to/tomcat/bin
./startup.sh
```

### 3.2 Start Tomcat (Windows)
If you're using Windows, navigate to the `bin/` folder in the Tomcat directory and run:
```sh
cd C:\apache-tomcat-9.0\bin
startup.bat
```

### 3.1 Stop Tomcat (Linux/macOS)
Go to the Tomcat `bin/` directory and run:
```sh
cd /path/to/tomcat/bin
./shutdown.sh
```

### Step 4: Verify Deployment
After starting Tomcat, you can check whether the servlet is deployed.

### 4.1 Check Running Applications
- Open a web browser and go to:
  ```
  http://localhost:8080/manager
  ```
- If prompted, enter the Tomcat Manager username and password (configured in `tomcat-users.xml`).
- Look for `ServletDemo` in the list of deployed applications.

### 4.2 Directly Access the Servlet
Try accessing your servlet using a browser or a tool like **Postman**.

For example, if your servlet is mapped to `/employee`, open:
```
http://localhost:8080/ServletDemo/employee
```

If you're using **cURL**, test the API:
```sh
curl -X GET http://localhost:8080/ServletDemo/employee
```

---

### Step 5: Check Logs for Errors
If the deployment fails, check Tomcat’s logs for error messages.

### 5.1 View Tomcat Logs
Run:
```sh
tail -f /path/to/tomcat/logs/catalina.out
```
On Windows, open:
```
C:\apache-tomcat-9.0\logs\catalina.out
```

---

### Step 6: Restart Tomcat (If Needed)
If your application doesn’t deploy correctly, try restarting Tomcat.

**On Linux/macOS:**
```sh
cd /path/to/tomcat/bin
./shutdown.sh
./startup.sh
```

**On Windows:**
```sh
cd C:\apache-tomcat-9.0\bin
shutdown.bat
startup.bat
```

---

### Bonus: Automate Deployment Using Maven Tomcat Plugin
Instead of manually copying the WAR file, you can deploy directly using Maven.

### 1. Add the Tomcat Plugin to `pom.xml`
```xml
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <url>http://localhost:8080/manager/text</url>
        <server>TomcatServer</server>
        <path>/ServletDemo</path>
    </configuration>
</plugin>
```

### 2. Configure Tomcat Credentials
Edit `~/.m2/settings.xml` (or create it) and add:
```xml
<servers>
    <server>
        <id>TomcatServer</id>
        <username>admin</username>
        <password>admin</password>
    </server>
</servers>
```

### 3. Deploy Using Maven
Run:
```sh
mvn tomcat7:deploy
```

---

