package com.example.methodexample;

public class MethodPassing {

    int x = 20 ;
    // passing different types of arguments
    private static void passMethod(int p ){

         p = 20 ;
        System.out.println(" after invoking the method the p is = "+ p);
    }

    public static void main(String[] args) {

        int x = 10 ;
        passMethod(x);

        System.out.println(" after invoking the method the x is = "+ x);


    }
}
