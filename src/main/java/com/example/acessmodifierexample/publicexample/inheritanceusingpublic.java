package com.example.acessmodifierexample.publicexample;

class Car{

    public int gear = 6 ;
    public int brake = 2 ;
    public String colour = "blue" ;
    public int speed = 240 ;

    int setBrake(int brake){
        if(brake == 1 ){
            System.out.println("break is 1");
        }
        else {
            System.out.println("break is 2");
        }
        return brake ;
    }
    int setGear(int gear){
        if(gear == 1 ){
            System.out.println("gear is 1");
        }
        else if(gear == 2) {
            System.out.println("gear is 2");
        } else if(gear == 3) {
            System.out.println("gear is 3");
        } else if(gear == 4) {
            System.out.println("gear is 4");
        }else if(gear == 5) {
            System.out.println("gear is 5");
        }else if(gear == 6) {
            System.out.println("gear is 6");
        }else{
            System.out.println("you have the limit the grear");
        }
        return gear;
    }
    int setSpeed( int speed){
        if(speed >= 120 ){
            System.out.println("you are overspeeding");
        }
        else if(speed <= 20) {
            System.out.println("you are too slow");
        }
        else if(speed >= 40 && speed <= 60) {
            System.out.println("you are on a average speed");
        }

        return speed ;
    }

}
class Alto extends Car{
    void gear(){
        gear = setGear(7);
        System.out.println("the available gear in alto is " + gear);
    }
}
class Suzuki extends Car{

}
class Hundai extends Car{

}
class Volkswagen extends Car{

}
class Audi extends Volkswagen{

}
class Mercedies extends Volkswagen{

}
public class inheritanceusingpublic {

    public static void main(String[] args) {

        Alto ob1 = new Alto();
        ob1.gear();
        ob1.setGear(4);

    }
}
