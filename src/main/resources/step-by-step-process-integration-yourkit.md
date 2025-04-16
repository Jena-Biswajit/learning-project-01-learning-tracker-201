### Set up YourKit Integration

### Download from: https://www.yourkit.com/

**In IntelliJ:** 
  1. Right-click your main() class → Modify Run Configuration
  2. In VM Options, paste this:
```
-agentpath:/Applications/YourKit\ Java\ Profiler.app/Contents/Resources/bin/mac/libyjpagent.dylib
```
### Run the App

**Example**

```
package com.example.yourkitdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCYourKitDemo {
    static String url = "jdbc:mysql://localhost:3306/student";
    static String user = "root";
    static String password = "subhasmita";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO student(name,age) VALUES(?,?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "krishna");
            statement.setInt(2, 26);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("data inserted successfully");
            } else {
                System.out.println("data not inserted ");
            }

            // 👇 Add this delay to keep app alive for profiling
            System.out.println("Sleeping for profiling... check YourKit now.");
            Thread.sleep(300000); // 60 seconds

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

0/p : data inserted successfully
      Sleeping for profiling... check YourKit now.
```
### Open YourKit & Profile
 1. Open YourKit Java Profiler.app
 2. It auto-scans running apps.
 3. 0/p : ```com.example.yourkitdemo.JDBCYourKitDemo```
 4. Double-click it to connect.

### Analyze in YourKit
  - Go to **“Telemetry”** → View CPU/Memory stats
  - Go to **“Threads”** → See thread activity

### What is the need for YourKit?
- YourKit Java Profiler is a powerful performance analysis tool designed for Java applications. 
- It's mainly used to find bottlenecks, detect memory leaks, and analyze CPU, memory, and thread usage — all while your app is running.

### Why You Need YourKit
 1. Understand What Your App Is Doing Internally
   - YourKit shows live profiling data like: 
   - Which methods are taking the most time (CPU usage)?
   - How much memory is being used by objects?
   - Are threads blocked or waiting?

 2. Detect Performance Issues
   - If your app is slow, YourKit helps you:
   - Find slow methods or loops.
   - Spot unoptimized code.
   - Identify frequent garbage collection (GC) cycles.

 3. Fix Memory Leaks
   - It shows which objects are not getting garbage collected.
   - Helps identify who is holding references to memory that should be freed.

 4. Monitor DB and I/O Calls (like JDBC)
   - You can view:
   - When a DB connection is opened or closed.
   - Which SQL queries were run.
   - How long those queries took

 5. Thread and Concurrency Analysis
   - Helps when you're working with multithreading.
   - Shows thread states: running, waiting, blocked.
   - Helps detect deadlocks or race conditions.

 
