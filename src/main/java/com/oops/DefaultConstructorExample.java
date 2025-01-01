package com.oops;

class Person
{
    String name ;
    int age;
    // Default Constructor
    public  Person (){
        // this keyword used to call parameterized Constructor
        this("biswajit jena",25);
    }
    //parameterized Constructor
    public  Person(String myName,int myAge) {
      this.name= myName; // set name with same variable
      this.age= myAge; // set age with same variable
    }


    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

}
public class DefaultConstructorExample {
    public static void main(String[] args) {
        //create object for MyDetails class
        Person biswajit = new Person();
        biswajit.display(); // to display detail
    }
}