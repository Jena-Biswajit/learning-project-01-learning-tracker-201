
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
    public class OopsExample {
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
            car2.start();
            car2.honk();

            // Overridden method from Object class
            System.out.println(car1.toString());
        }
    }
