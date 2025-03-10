package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetriveTableExample {
    static String url = "jdbc:mysql://localhost:3306/mydatabase";
    static String user = "root";
    static String password = "subhasmita";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String query = "select * from students";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");

                System.out.println("id :"+id);
                System.out.println("name :"+name);
                System.out.println("age :"+age);
                System.out.println("marks :"+marks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
