package com.oops;

class OverLoad {
    int num1 = 2, num2 = 3;
    int result;

    public void addition() {
        result = num1 + num2;
        System.out.println(result);
    }

    //Overloading Method
    public void addition(int tempNum, int tempNum1) {
        result = tempNum + tempNum1;
        System.out.println(result);
    }
}

public class OverLoadingExample {
    public static void main(String[] args) {
        OverLoad add = new OverLoad(); // create object for Overload
        int number1 = 7, number2 = 8;
        add.addition();                // calling method with 0 argument
        add.addition(number1, number2); // calling same method 2 argument
    }
}