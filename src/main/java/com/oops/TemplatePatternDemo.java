package com.oops;

abstract class Beverage {
    // Template method: defines the fixed structure of the process
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Steps with default implementation
    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // Abstract steps to be defined by subclasses
    protected abstract void brew();          // Brewing specific to the beverage
    protected abstract void addCondiments(); // Add condiments specific to the beverage
}
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}
public class TemplatePatternDemo {
    public static void main(String[] args) {
        System.out.println("Making Tea:");
        Beverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println("\nMaking Coffee:");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}

