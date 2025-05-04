package com.example.task;

import com.example.task1.SubClass;

public class App2 {

    final String message = "biswajit" ;

    protected void protectedExample(){
        System.out.println(" show message" + message);
    }

    static{
        System.out.println("static block app2");
    }

    public static void main(String[] args) {
        SubClass ob1 = new SubClass();
        ob1.accssProtected();
    }
}
