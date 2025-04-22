package com.example.singleton.enumbased;

public enum EnumSingleton {
    INSTANCE; // This is the singleton instance

    // You can define methods here
    public void showMessage() {
        System.out.println("Hello from Enum Singleton!");
    }
}
