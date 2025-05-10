package com.collections;

import java.util.HashSet;

public class HashSetUsingEmployeeClass {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();

        Employee1 e1 = new Employee1(1, "Biswajit");
        Employee1 e2 = new Employee1(2, "jit");
        Employee1 e3 = new Employee1(1, "Biswajit"); // Duplicate

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        // Should print only two employees (no duplicate)
        System.out.println("Employees in HashSet: " + employees);
    }
}

