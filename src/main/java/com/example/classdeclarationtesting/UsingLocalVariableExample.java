package com.example.classdeclarationtesting;

class Flower{

    static String returnName(){

        String flowerName = "yasmin";
        return flowerName;
    }
}
public class UsingLocalVariableExample {

    public static void main(String[] args) {
        String storeFlower = Flower.returnName();
        System.out.println("The flower is :" + storeFlower);
    }
}
