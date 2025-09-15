package com.example.constructor;

public class ComputePayments {

    public int a = 9;
    public int b = 10;

    ComputePayments(){
        int c = a+b;
        System.out.println(c);
    }

    public static void main(String[] args) {
        ComputePayments ob1 = new ComputePayments();

    }
}
