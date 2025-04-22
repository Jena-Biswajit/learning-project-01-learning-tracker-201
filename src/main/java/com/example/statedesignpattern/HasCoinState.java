package com.example.statedesignpattern;

public class HasCoinState implements State {
    @Override
    public String handleRequest() {
        return "Coin inserted. Please make a selection.";
    }
}