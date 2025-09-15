package com.example.constructor;

public class UsingMorethanOneConstructors {

    UsingMorethanOneConstructors(){
        System.out.println("constructor one with 0 parameter");
    }

    UsingMorethanOneConstructors(int num1){
        int tempNum =9 ;
        tempNum = tempNum+ num1;
        System.out.println(" total no is :"+ tempNum);
    }

    UsingMorethanOneConstructors(int num1 , int num2){

        int currentToatl = num2-num1 ;
        System.out.println("difference between num2 and num1 is :" + currentToatl);
    }

    UsingMorethanOneConstructors(int num1 , int num2 , int num3){

        int addNumber = num1+num2+num3;

        System.out.println(" total no is :"+ addNumber);

    }

    UsingMorethanOneConstructors(int num1 , int num2 , int num3 , int num4){
        int mulNumber = num1*num2*num3*num4;

        System.out.println(" total no is after 5 const multiplication :"+ mulNumber);
    }

    public static void main(String[] args) {
        UsingMorethanOneConstructors ob1 = new UsingMorethanOneConstructors();
        UsingMorethanOneConstructors ob2 = new UsingMorethanOneConstructors(4);
        UsingMorethanOneConstructors ob3 = new UsingMorethanOneConstructors(4,5);
        UsingMorethanOneConstructors ob4 = new UsingMorethanOneConstructors(4,5,5);
        UsingMorethanOneConstructors ob5 = new UsingMorethanOneConstructors(4,5,5,6);

    }
}
