package com.example.arrayexample;

public class ArrayExample {
    // creating or declaring  a array
    private static int [] array = {0,1,2,3,4,5,6,7,8,9} ;
    static int len = array.length;
    public static void main(String[] args) {
        int temp =0 ;
        for (int i =0 ; i< len ; i++){

            temp = temp + array[i] ;
        }

        System.out.println("sum of all element od array is :"+temp);
    }
}
