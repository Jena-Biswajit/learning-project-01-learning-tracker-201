package com.example.tomcat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class Employee {
    private String name;
    private int age;
    private String department;

    // Constructors
    public Employee() {}
    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}

public class EmployeeJsonExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = new Employee("Biswajit Jena", 25, "IT");

        try {
            // Convert Employee object to JSON and write to a file
                                                                                                                     objectMapper.writeValue(new File("employee.json"), employee);
            System.out.println("Employee JSON file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}