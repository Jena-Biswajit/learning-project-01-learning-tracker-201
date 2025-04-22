package com.example.statedesignpattern;

public class DispensingState implements State {
    @Override
    public String handleRequest() {
        return "Dispensing item... Please wait.";
    }
}