package com.example.yourkitdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class JDBCYourKitDemo {
    static String url = "jdbc:mysql://localhost:3306/student";
    static String user = "root";
    static String password = "subhasmita";



    public static void main(String[] args) {
        ExecutorService service =  Executors.newFixedThreadPool(10);

        for(int i =0 ; i<10 ; i++){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    extracted1();
                }
            });
        }
    }

    private static void extracted1() {
        while(true){
            extracted();
        }
    }

    private static void extracted() {
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
            Thread.sleep(100); // 60 seconds

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
