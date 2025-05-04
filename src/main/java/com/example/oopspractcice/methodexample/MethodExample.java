package com.example.oopspractcice.methodexample;

public class MethodExample {

    // private state declaration so that it can't be accessible to other classes
    private int gear = 4 ;
    private String colour = "blue";

    // constructor initialization for ensuring that the object has valid initial valuse
    // before it's uded .

    public MethodExample(int gear , String colour){

        // this keyword is a reference key to ensure that parameter
        this.gear = gear;
        this.colour = colour ;

        System.out.println("constuctor to initialize the object values ");
        System.out.println("constuctor to check the intialization ");
    }


    void printBike(){

        System.out.println("no of gear in bike is :"+ getGear());
        System.out.println("colour of bike is :"+ getColour());

    }

    // getter setter for directly not using the variables

    int getGear(){
        return gear;
    }String getColour(){
        return colour;
    }


    public static void main(String[] args) {

        MethodExample ob1 = new MethodExample( 6 ,  "blue");
        ob1.printBike();
    }

}
