package com.example.acessmodifierexample.publicexample;

class PublicMethod{
    public static void employeeDetails(int age , String name , int id){

        // local variable of employeeDetails method
        age = 29 ;
        name = "raghab";
        id = 100 ;
        System.out.println("name is "+ name);
        System.out.println("id is "+ id);
        System.out.println("age is "+ age);
    }
}
public class PublicMethodExample {
    public static void main(String[] args) {

        // modifier public for field id not allowed here
        // you can't define a method inside method

         // local variable of main method
         int age = 25 ;
         String name = "biswajit" ;
         int id = 10 ;
         PublicMethod.employeeDetails(age,name,id);
         System.out.println("-----");
         System.out.println("name is "+ name);
         System.out.println("id is "+ id);
         System.out.println("age is "+ age);
    }
}
