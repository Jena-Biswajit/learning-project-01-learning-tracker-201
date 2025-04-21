package com.example.factorydesignpattern;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by road in a truck");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea in a ship");
    }
}