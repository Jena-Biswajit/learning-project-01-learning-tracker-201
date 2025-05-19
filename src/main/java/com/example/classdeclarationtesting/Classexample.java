package com.example.classdeclarationtesting;


// this program demonstrate using static and nonstatic field
public class Classexample {

    static String name = "abc";
     String colour = "blue";


    public static void main(String[] args) {

        // always check the field is static or not when yopu are accessing
        // even in the same class if the field are different like one static and other is non-static
        // and you are directly trying access the field then it will show the error .
        // like below example
        name = "biswa";
        System.out.println(name);

        Classexample ob1 = new Classexample();
        ob1.colour = "red";
        System.out.println("new colour is "+ob1.colour);
    }
}
