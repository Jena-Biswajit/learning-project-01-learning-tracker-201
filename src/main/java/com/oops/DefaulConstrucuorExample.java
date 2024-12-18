package com.oops;

class MyDetails
{
    String myName ;
    int myAge;
    // Default Constructor
    public  MyDetails (){
        // this keywork used to call parameterized Constructor
        this("biswajit jena",25);
    }
    //parameterized Constructor
    public  MyDetails(String myName,int myAge)
    {
      this.myName= myName; // set name with same variable
      this.myAge= myAge; // set age with same variable
    }

    void display() {
        System.out.println("Name: " + myName + ", Age: " + myAge);
    }

}
public class DefaulConstrucuorExample {
    public static void main(String[] args) {
        //creste object for MyDetails class
        MyDetails biswajit = new MyDetails();
        biswajit.display(); // to dispay detail
    }
}