package com.collections;
import java.util.*;

    class Employee12 {
        int id;
        String name;
        String city;

        public Employee12(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Employee12 employee = (Employee12) obj;
            return id == employee.id && name.equals(employee.name);
        }

        @Override
        public String toString() {
            return id + " " + name;
        }
    }

    public class EqualHashCode {
        public static void main(String[] args) {
            Set<Employee12> employees = new HashSet<>();

            Employee12 e1 = new Employee12(1, "biswajit");
            Employee12 e2 = new Employee12(2, "biswa");

            employees.add(e1);
            employees.add(e2);

            System.out.println("Employees Set: " + employees);
            System.out.println("e1.equals(e2): " + e1.equals(e2));
        }
    }
