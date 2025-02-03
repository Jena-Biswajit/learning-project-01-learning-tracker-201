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
        System.out.println(obj);
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee1 employee = (Employee1) obj;
        return id == employee.id && Objects.equals(name, employee.name);
//        return false ;
    }
    // if same hashcode is produce then it will go to same bucket index by using hashing algo .
    // while adding p1 if  no element found at bucket index it places the object p1.
    // while adding p2 if an element found (p1) at bucket index then it calls p1.equals(p2).
    // if equals returns true then p1 is replaced by p2 .
    // if equals returns false then p2 is appended to p1.

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
//        return 1;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}

public class EmployeeClassExample {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();

        employees.add(new Employee1(1, "Alice"));
        employees.add(new Employee1(2, "Bob"));
        employees.add(new Employee1(1, "Alice")); // Duplicate

        System.out.println(new Employee1(1,"Alice" ).hashCode());
        System.out.println(new Employee1(2, "Bob").hashCode());
        System.out.println(new Employee1(1,"Alice" ).hashCode());

        System.out.println("Employees class Example: " + employees);
    }
}
