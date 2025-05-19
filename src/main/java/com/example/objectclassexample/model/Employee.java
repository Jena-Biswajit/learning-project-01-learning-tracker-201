package com.example.objectclassexample.model;

public class Employee {

    int id ;
    String name ;
    int salary ;


    public int employeeID(int id){
        this.id = id ;
        return  this.id;
    }

    public String employeeName(String name){
        this.name = name ;
        return  this.name;
    }

    public int employeeSalary(int salary){
        this.salary = salary ;
        return  this.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.employeeID(100);
        employee.employeeName("biswajit");
        employee.employeeSalary(1200);
        System.out.println(employee);
    }
}
