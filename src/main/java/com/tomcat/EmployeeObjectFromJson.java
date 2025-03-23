package com.tomcat;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class EmployeeObjectFromJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON from file and convert it to Employee object
            Employee employee = objectMapper.readValue(new File("employee.json"), Employee.class);
            System.out.println("Employee Details:");
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Department: " + employee.getDepartment());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
