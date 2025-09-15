package com.example.acessmodifierexample.protectedexample;

class ProtectedMethod{
    protected void printProtectedTest(){
        System.out.println("protected method1");
    }

    // we can overload a protected method
    protected void printProtectedTest(String name){
        System.out.println("overloaded protected method");
    }
}

public class ProtectedMethodExample {
    public static void main(String[] args) {

        ProtectedMethod ob1 = new ProtectedMethod();
        ob1.printProtectedTest();
        ob1.printProtectedTest("biswajit");

    }
}
