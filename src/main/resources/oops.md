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

**Example**
```java
// Define the class Car
class Car {
    String model;
    String color;
    int speed;

    // Constructor for initializing the object
    Car(String model, String color, int speed) {
        this.model = model;
        this.color = color;
        this.speed = speed;
    }

    // Method inside the class to accelerate the car
    void accelerate() {
        speed += 10;
        System.out.println("Accelerated. New speed: " + speed);
    }

    // Method inside the class to brake the car
    void brake() {
        speed -= 10;
        System.out.println("Braked. New speed: " + speed);
    }

    // Method to display car details
    void display() {
        System.out.println("Model: " + model + ", Color: " + color + ", Speed: " + speed);
    }
}

// Main class where program execution starts
public class Main {
    public static void main(String[] args) {
        // Create an object of Car class
        Car myCar = new Car("Toyota", "Red", 60);

        // Call methods on the object
        myCar.display();
        myCar.accelerate();
        myCar.brake();
    }
}
```
