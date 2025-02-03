package com.example;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hello from MainClass!");
        String property = System.getProperty("myProperty", "mySampleJarClass");
        System.out.println("System Property: " + property);
    }
}
