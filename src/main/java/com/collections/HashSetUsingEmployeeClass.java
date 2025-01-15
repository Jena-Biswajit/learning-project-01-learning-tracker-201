package com.collections;

import java.util.HashSet;

public class HashSetUsingEmployeeClass {
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();

        Employee e1 = new Employee(1, "Biswajit");
        Employee e2 = new Employee(2, "jit");
        Employee e3 = new Employee(1, "Biswajit"); // Duplicate

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        // Should print only two employees (no duplicate)
        System.out.println("Employees in HashSet: " + employees);
    }
}

