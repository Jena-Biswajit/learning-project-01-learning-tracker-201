package com.example.templatedesignpattern;

public abstract class Beverage {
    // Template method
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps to be implemented by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
}