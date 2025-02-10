package com.collections;
import java.util.*;

class Employee1 {
    int id;
    String name;
    public Employee1(int id , String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj1){
        if(this == obj1){
            return true ;
        }
        if ((obj1== null) || (getClass()!= obj1.getClass())){
            return false;
        }
        Employee1 employee = (Employee1) obj1;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }
    @Override
    public String toString(){
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

}
public class EmployeeClassExampleRevise {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"bisw"));
        employees.add(new Employee1(3,"bis"));
        employees.add(new Employee1(1,"biswaa"));
        employees.add(new Employee1(4,"biswa"));
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"biswq"));

        System.out.println("employee details is "+employees);
    }
}