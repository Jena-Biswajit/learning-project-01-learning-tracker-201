package com.example.oopspractcice.methodexample;

class Bike{

    // declaring instance variable
    private int gear ;
    private String colour ;
    private int speed ;
    private int  break1;

//    public Bike(int gear , String colour , int speed , int  break1){
//        this.gear = gear;
//        this.colour = colour;
//        this.speed = speed;
//        this.break1 = break1;
//    }
//    public Bike(){
//        this.gear = gear;
//        this.colour = colour;
//        this.speed = speed;
//        this.break1 = break1;
//    }


    void sp125Deatils(){
        System.out.println("no of gear in sp125 :"+ gear);
        System.out.println("maimum of speed in sp125 :"+ speed);
        System.out.println("no of break in sp125 :"+ break1);
        System.out.println("colour of sp125 :"+ colour);

    }    void sp125Deatils(int gear ){

        System.out.println("no of gear in sp125 :"+ gear);
        System.out.println("maimum of speed in sp125 :"+ speed);
        System.out.println("no of break in sp125 :"+ break1);
        System.out.println("colour of sp125 :"+ colour);

    }    void sp125Deatils(int gear , String colour ){

        System.out.println("no of gear in sp125 :"+ gear);
        System.out.println("maimum of speed in sp125 :"+ speed);
        System.out.println("no of break in sp125 :"+ break1);
        System.out.println("colour of sp125 :"+ colour);

    }    void sp125Deatils(int gear , String colour , int break1){

        System.out.println("no of gear in sp125 :"+ gear);
        System.out.println("maimum of speed in sp125 :"+ speed);
        System.out.println("no of break in sp125 :"+ break1);
        System.out.println("colour of sp125 :"+ colour);

    }    void sp125Deatils(int gear , String colour , int break1,int  speed){

        System.out.println("no of gear in sp125 :"+ gear);
        System.out.println("maimum of speed in sp125 :"+ speed);
        System.out.println("no of break in sp125 :"+ break1);
        System.out.println("colour of sp125 :"+ colour);

        System.out.println("----------------------------");

    }

//    int getGear(){
//        // this is a proper getter method which returning instance variable
//        return this.gear;
//    }int getSpeed(){
//        return this.speed;
//    }int getBreak1(){
//        return this.break1;
//    }String getColour(){
//        return this.colour;
//    }
}

class NewClass{

    void sp125Deatils(int gear , String colour , int break1,int  speed){

        System.out.println("----------------------------");

        System.out.println("no of gear in sp125 :"+ gear);
        System.out.println("maimum of speed in sp125 :"+ speed);
        System.out.println("no of break in sp125 :"+ break1);
        System.out.println("colour of sp125 :"+ colour);

        System.out.println("----------------------------");

    }
}

public class MethodOverLoadingExample {

    public static void main(String[] args) {

        Bike ob1 = new Bike();
        ob1.sp125Deatils();
        ob1.sp125Deatils(4);
        ob1.sp125Deatils(4,"blue");
        ob1.sp125Deatils(4,"red",2);
        ob1.sp125Deatils(6,"black",2,140);

        NewClass ob2 = new NewClass();
        ob2.sp125Deatils(6,"black",2,140);
    }
}
