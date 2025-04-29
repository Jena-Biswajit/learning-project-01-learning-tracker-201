package com.oops;

class Parent {
    String name;
    public Parent(String name) {
        this.name = name;
        System.out.println("Parent constructor called: " + name);
    }
}

class Child extends Parent {
    int age;

    public Child(String name, int age) {
        super(name); // Calls the parent constructor
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + super.name); // Access parent field
        System.out.println("Age: " + age);
    }
    public static void main(String[] args) {
        Child child = new Child("Biswajit", 25);
        child.display();
    }
}
