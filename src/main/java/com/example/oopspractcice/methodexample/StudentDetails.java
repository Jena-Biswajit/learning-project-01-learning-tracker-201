package com.example.oopspractcice.methodexample;

public class StudentDetails {

    // private to only accessible in the same calss
    private int id ;
    private String name ;

    // constructor to initialize the states to ensure it is a valid state

    public StudentDetails(int id , String name){

        // this refernece keyword for the state is a valid state name
        // if i'm not using "this" it will get confused that what is id =id
        // it will return id is :0 and name is :null
        // if i will use this then it will show id is :1 , name is :biswa
        // which is correct .
        this.id = id ;
        this.name = name ;

    }

    // method to print student details
    void studentDetails(){
        System.out.println("student id is :" + getId());
        System.out.println("student name is :" + getName());
    }

    // getter for not use directly yhe state or method

    int getId(){
        return id;
    } String  getName(){
        return name;
    }

    // main method to create object and access the state and method

    public static void main(String[] args) {
        StudentDetails ob1 = new StudentDetails(1 ,"biswa");
        ob1.studentDetails();
    }

}
