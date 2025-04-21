package com.example.abstractfactory;

// Abstract Product
public interface Button {
    void paint();
}

// Concrete Product
 class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a Windows Button");
    }
}

 class MacOSButton implements Button {
    public void paint() {
        System.out.println("Rendering a MacOS Button");
    }
}

// Abstract Factory
 interface GUIFactory {
    Button createButton();
}

// Concrete Factories
 class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
}

class MacOSFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }
}