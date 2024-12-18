package com.oops;


class FindAverage {
    int num1,num2,num3;
    int avg=0;
    FindAverage(int num1,int num2,int num3) {
        avg = num1+num2+num3/3;
    }
    void display(){
        System.out.println("average = "+avg);
    }
}
public class ParamConstructorExample {
    public static void main(String[] args) {
        FindAverage average = new FindAverage (5,6,7);
        average.display();
    }
}
