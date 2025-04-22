package com.example.statedesignpattern;


public class IdleState implements State {
    @Override
    public String handleRequest() {
        return "Machine is idle. Insert a coin.";
    }
}