package com.collections;

import java.util.*;

class Employee11 {
    int id;
    String name, city;

    public Employee11(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + city;
    }
}

public class SortEmployeeClass {
    public static void main(String[] args) {

        List<Employee11> sortEmployee = new ArrayList<>();

        sortEmployee.add(new Employee11(1,"biswajit","bbsr"));
        sortEmployee.add(new Employee11(2,"bisw","ctc"));
        sortEmployee.add(new Employee11(3,"biswaj","bbsr"));
        sortEmployee.add(new Employee11(4,"biswaj","ctc"));
        sortEmployee.add(new Employee11(5,"biswaji","bbsr"));

        sortEmployee.sort(Comparator.comparing((Employee11 e )-> e.city).thenComparing(e->e.name));

        for (Employee11 emp : sortEmployee) {
            System.out.println(emp);
        }

    }

}