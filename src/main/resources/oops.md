### Class & Objects

**Class**
- A class in Java is a blueprint or template for creating objects.
- It defines the properties (fields) and behaviors (methods) that the objects created from the class will have.
- A class defines what an object will look like (its structure) and how it will behave (its actions).
- **Fields (Attributes/variables):** These store the data or state of the object.
- **Methods:** These define the actions or behaviors of the object.
- **Constructors:** Special methods to initialize objects when they are created.
- **Access Modifiers:** To control visibility (e.g., public, private, etc.).

**Obects**
- An object in Java is a specific instance of a class.
- It is a concrete representation of a blueprint (class) that combines state (data) and behavior (methods).
- A class defines what an object should have and do.
- Objects make it easy to represent real-world entities with both data (state) and actions (behavior).
- Example: A Car object represents a specific car (like a Toyota) with properties like color and speed, and actions like accelerating or braking.


## Static and Non static fields
**Non-Static Fields:**
- model, color, and speed are specific to each instance of the Car class.
  
**Static Field:**
- Only one copy of the static field exists, regardless of how many objects of the class are created.
- Static fields can be accessed using the class name (e.g., ClassName.fieldName) without creating an instance.
- Static fields are stored in a fixed location in memory (Class Area), making them efficient for shared data.
- static int totalCars is static field
  
**Example**
```java
class Car extends AbstractCar implements Vehicle {
    String model;  // Non-static field
    String color;  // Non-static field
    int speed;     // Non-static field

    static int totalCars = 0;  // Static field
}
```


## Static and Non static Method
**Static Method**
- A static method belongs to the class rather than any instance and can only access static fields directly.
- displayTotalCars() prints the total number of Car objects created.
- Calling Car.displayTotalCars() outputs the total cars created.
- A static method in Java belongs to the class rather than an instance of the class.
- It can be called without creating an object of the class.
- Static methods are useful for functionality that doesn't depend on object-specific data.
- totalCars is shared among all Car objects and counts the total cars created.
- Static methods are associated with the class, not with any specific object.
- You can call a static method using the class name, e.g., ClassName.methodName().
  
**Syntax**
```java
class ClassName {
    // Static method
    static returnType methodName(parameters) {
        // Method body
    }
}
```  
  
**Example**
```java
static void displayTotalCars() {
    System.out.println("Total cars created: " + totalCars);
}
```
**Non Static Method**
- These methods can only be called on objects of the Car class and use the instance's speed field.
- accelerate() increases the speed by 10.
- brake() decreases the speed by 10.
- Calling car1.accelerate() changes car1's speed and prints the updated value.
- A non-static method is a method that belongs to an instance of a class.
- It requires creating an object of the class to invoke it.
- These methods have access to both instance variables and static variables.
- A non-static method is declared without the static keyword.
  
**Syntax**
```java
class ClassName {
    // Non-static method
    returnType methodName(parameters) {
        // Method body
    }
}
```
**Example**
```java
void accelerate() {
    speed += 10;
    System.out.println("Accelerated. New speed: " + speed);
}

void brake() {
    speed -= 10;
    System.out.println("Braked. New speed: " + speed);
}
```

## Method overloading
- The brake() method is overloaded to accept an int parameter, allowing braking by a specific amount.
- Calling car1.brake(20) decreases the speed by 20 instead of the default 10.

**Example**
```java
void brake(int amount) {
    speed -= amount;
    System.out.println("Braked by " + amount + ". New speed: " + speed);
}
```

## Interface Declaration
- An interface in Java is a blueprint of a class that specifies a set of methods (but not their implementations) that a class must implement.
- Interfaces are used to achieve abstraction and multiple inheritance.
- The Vehicle interface declares a method start() that any class implementing Vehicle must define.
- Interfaces are used for abstraction and multiple inheritance.

```
interface InterfaceName {
    // Constant fields (implicitly public, static, and final)
    type CONSTANT_NAME = value;

    // Abstract methods (implicitly public and abstract)
    returnType methodName(parameters);

    // Default methods (introduced in Java 8, can have a body)
    default void defaultMethod() {
        // method body
    }

    // Static methods (introduced in Java 8, can have a body)
    static void staticMethod() {
        // method body
    }
}
```
- Any field declared in an interface is automatically public, static, and final.
- This means they must be constants and cannot be changed.
- Abstract Methods declared in an interface are implicitly public and abstract.
- Implementing classes must provide definitions for these methods.

**Example**
```java
interface Vehicle {
    void start();
}
```
## Abstract Class Declaration
- abstract class is a class that cannot be instantiated on its own.
-  It can have both abstract methods (methods without a body) and non-abstract methods (methods with a body).
- Abstract classes are used as a base for other classes to extend, allowing the subclasses to implement or override the abstract methods.
- An abstract class provides a base for other classes with or without complete implementations.
- honk() is an abstract method, so any subclass must implement it.
- The toString() method overrides the Object class method to provide a custom string representation of the Car object.
- The Car class extends AbstractCar and implements the honk() method.
- 

**Example**
```java
abstract class AbstractCar {
    abstract void honk();

    @Override
    public String toString() {
        return "This is a car object.";
    }
}
```

## Consrtuctor
- The constructor initializes model, color, and speed for a Car object using the this keyword.
- It increments the static field totalCars to keep track of the number of Car instances created.
- When new Car("Toyota", "Red", 60) is called, this constructor initializes the Toyota car's attributes.

**Example**
```java
Car(String model, String color, int speed) {
    this.model = model;
    this.color = color;
    this.speed = speed;
    totalCars++;
}
```

**Example**
```java
// Define the class Car
// Define an Interface
interface Vehicle {
    void start();
}

// Abstract class defining shared properties of vehicles
abstract class AbstractCar {
    abstract void honk(); // Abstract method, must be implemented by subclasses

    // Example of a method from the Object class being overridden
    @Override
    public String toString() {
        return "This is a car object.";
    }
}

// Main Car class
class Car extends AbstractCar implements Vehicle {
    // Non-static fields (instance variables)
    String model;
    String color;
    int speed;

    // Static field (shared among all objects)
    static int totalCars = 0;

    // Constructor to initialize the Car object
    Car(String model, String color, int speed) {
        this.model = model;
        this.color = color;
        this.speed = speed;
        totalCars++; // Increment static field
    }

    // Non-static method (requires an instance to call)
    void accelerate() {
        speed += 10;
        System.out.println("Accelerated. New speed: " + speed);
    }

    // Non-static method (requires an instance to call)
    void brake() {
        speed -= 10;
        System.out.println("Braked. New speed: " + speed);
    }

    // Method overloading (same name, different parameter list)
    void brake(int amount) {
        speed -= amount;
        System.out.println("Braked by " + amount + ". New speed: " + speed);
    }

    // Static method (does not depend on an instance)
    static void displayTotalCars() {
        System.out.println("Total cars created: " + totalCars);
    }

    // Implementation of abstract method from AbstractCar
    @Override
    void honk() {
        System.out.println("Honk! Beep Beep!");
    }

    // Implementation of interface method
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    // Non-static method to display car details
    void display() {
        System.out.println("Model: " + model + ", Color: " + color + ", Speed: " + speed);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create objects of Car class
        Car car1 = new Car("Toyota", "Red", 60);
        Car car2 = new Car("Honda", "Blue", 70);

        // Non-static method calls
        car1.display();
        car1.accelerate();
        car1.brake();
        car1.brake(20); // Demonstrates method overloading
        car1.honk();
        car1.start();

        // Static method call (using the class name)
        Car.displayTotalCars();

        // Non-static method call for second object
        car2.display();

        // Overridden method from Object class
        System.out.println(car1.toString());
    }
}
```

