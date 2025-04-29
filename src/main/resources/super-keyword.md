### Super Constructor
- The super keyword in Java is used to refer to the parent class (also called the superclass) of the current class.
- It is particularly useful when dealing with inheritance.

#### Super Keyword
- Call the parent class constructor from the child class.
- Access methods and fields of the parent class from the child class.

Using ```super``` to Call the Parent Class Constructor
- When a child class inherits from a parent class, the parent class constructor must be called to initialize its properties.
- By default, Java automatically calls the no-argument constructor of the parent class.
- If the parent class doesn't have a no-argument constructor or if you want to call a specific constructor, you use super.
- If a method is overridden in the child class, you can still call the parent class version using super.
- If the child class defines a field with the same name as the parent class, you can use super to access the parent class field explicitly.
- When used to call a parent constructor, super must be the first statement in the constructor.
- If the child class constructor does not explicitly call a parent constructor, Java automatically inserts super(); (calls the no-argument constructor of the parent class).
  If the parent class does not have a no-argument constructor, the code will fail to compile.
- super cannot access private fields or methods of the parent class because they are not inherited.
- You cannot use super in a static method because super refers to an instance.
- **Example**
```java
Child(String name, int age) {
    super(name); // Must be first
    this.age = age;
}
```
**Syntax** 
```
super(arguments);
```
**Example**
```java
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

// o/p  
// Parent Constructor called: Biswajit
// Child Constructor called: 25
```
