package com.example.acessmodifierexample.packageprivateexample;

// default class declaration
class DefaultClassTest{

    // default field
    String name = "biswajit" ;

    // default method
    void showName(){
        System.out.println("the name is :"+ name);
    }
}
public class DefaultClassExample {
    public static void main(String[] args) {
        DefaultClassTest ob1 = new DefaultClassTest();
        ob1.showName();
    }

}
