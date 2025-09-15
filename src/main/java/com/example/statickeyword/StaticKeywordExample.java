package com.example.statickeyword;

 class StaticClassExample{
    static int age ;
    static String name ;

    static void myDetails(){
        age = 25 ;
        name = "biswa";

        System.out.println(age);
        System.out.println(name);
    }

    static void myDetails(int age,String name){
        System.out.println(age);
        System.out.println(name);
    }

    static class MyNestedClass{
        static int weight = 10 ;

        static void weightCalculation(){
             int newWeight = 50 ;
             int totalWeight = newWeight + weight ;
            System.out.println(totalWeight);

        }
    }

    static class Mynewweight extends MyNestedClass{

        static void weightCalculation(){
            int newWeight = 60 ;
            int totalWeight = newWeight + weight ;
            System.out.println(totalWeight);
        }
    }
}

public class StaticKeywordExample {
    public static void main(String[] args) {
        StaticClassExample.myDetails();
        StaticClassExample.myDetails(25 , "biswajit");


        // we can't access the nested class directly so we have acess like this way
        StaticClassExample.Mynewweight.weightCalculation();
        StaticClassExample.MyNestedClass.weightCalculation();
    }
}
