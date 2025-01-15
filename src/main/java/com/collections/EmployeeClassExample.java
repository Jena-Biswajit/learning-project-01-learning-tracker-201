package com.collections;

import java.util.HashSet;
import java.util.Objects;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class EmployeeClassExample {
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();

        employees.add(new Employee(1, "Alice"));
        employees.add(new Employee(2, "Bob"));
        employees.add(new Employee(1, "Alice")); // Duplicate

        System.out.println("Employees class Example: " + employees);
    }
}
