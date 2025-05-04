package com.example.oopspractcice.methodexample;

public class ThisKeyWordValidation {

    private int thisState = 12;
    private boolean thisInstanceVariable;

    // check the state without parameter
    public ThisKeyWordValidation(int thatState , boolean checkState){
        System.out.println(thatState);
        System.out.println(thisState);
        thisState = thatState;
        thisInstanceVariable = checkState;

        System.out.println(thisState);
        System.out.println(thatState);

    }

    // method to check validtion

    boolean checkThis(){

        if(thisState == thisState){
            System.out.println("retun true");
            return true;
        }

        else {
            System.out.println("retun false");
            return false;
        }
    }

    public static void main(String[] args) {
        ThisKeyWordValidation obj1 = new ThisKeyWordValidation(5 , true);
        obj1.checkThis();
    }

}
