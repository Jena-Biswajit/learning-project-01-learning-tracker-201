package com.example.factorydesignpattern;

public class TransportFactory {
    public static Transport getTransport(String type) {
        if ("truck".equalsIgnoreCase(type)) {
            return new Truck();
        } else if ("ship".equalsIgnoreCase(type)) {
            return new Ship();
        } else {
            throw new IllegalArgumentException("Unknown transport type");
        }
    }
}