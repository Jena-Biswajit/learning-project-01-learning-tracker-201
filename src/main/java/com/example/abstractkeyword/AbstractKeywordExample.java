package com.example.abstractkeyword;

abstract class Scool{
   abstract void studentDisplay();
}

class Student extends Scool{

    // do using static
    void studentDisplay(){

       String name = "biswa";
       int age = 23;

        System.out.println(name);
        System.out.println(age);
    }
}

 class AbstractKeywordExample {

    public static void main(String[] args) {

        Scool s = new Student();
        s.studentDisplay();

//        Student.studentDisplay();

    }
}
