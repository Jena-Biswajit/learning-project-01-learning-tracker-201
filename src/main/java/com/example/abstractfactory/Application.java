package com.example.abstractfactory;

public class Application {
    private Button button;

    public Application(GUIFactory factory) {
        button = factory.createButton();
    }

    public void renderUI() {
        button.paint();
    }
}