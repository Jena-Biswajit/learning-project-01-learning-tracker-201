package com.example.statedesignpattern;

public class VendingMachine {
    private State state;

    public VendingMachine() {
        this.state = new IdleState(); // default state
    }

    public void setState(State state) {
        this.state = state;
    }

    public String performAction() {
        return state.handleRequest();
    }
}