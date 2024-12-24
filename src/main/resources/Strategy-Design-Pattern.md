### Strategy Design Pattern
- The Strategy Design Pattern is like a toolbox of solutions where you can pick the most appropriate tool (algorithm) for a specific problem. It enables you to:

- **Define a group of algorithms** (different ways to solve a problem).
- **Encapsulate each algorithm** into a separate class.
- **Switch between algorithms** easily without affecting the main logic of your program.
- **Flexibility:** You can change the behavior of your program without modifying its structure.
- **Clean Code:** It avoids many if-else or switch statements.
- **Extensibility:** You can add new strategies (algorithms) without changing existing code.

- Imagine you're traveling from one city to another. You have multiple options to reach your destination:
- **Drive a car.**
- **Take a train.**
- **Fly by airplane.**
- Each mode of transportation is a strategy.
- Depending on the situation (distance, cost, time), you can choose the one that suits you best.
- The process of traveling remains the same (decide a mode, start traveling), but the mode of transportation can change dynamically.

- **Strategy Interface:** Defines a common method for all algorithms (e.g., travel method for all transportation modes).
- **Concrete Strategies:** Implement the different algorithms (e.g., car, train, airplane).
- **Context Class:** Uses a Strategy object to execute the chosen algorithm.

**Example**

- Step 1: Define the Strategy Interface
```java
interface TravelStrategy {
    void travel(String destination);
}
```

- Step 2: Create Concrete Strategies
```java
class CarTravel implements TravelStrategy {
    @Override
    public void travel(String destination) {
        System.out.println("Traveling to " + destination + " by Car.");
    }
}

class TrainTravel implements TravelStrategy {
    @Override
    public void travel(String destination) {
        System.out.println("Traveling to " + destination + " by Train.");
    }
}

class AirTravel implements TravelStrategy {
    @Override
    public void travel(String destination) {
        System.out.println("Traveling to " + destination + " by Airplane.");
    }
}
```

- Step 3: Create the Context Class
```java
class TravelContext {
    private TravelStrategy strategy;

    // Set the strategy at runtime
    public void setTravelStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    // Execute the chosen strategy
    public void travelTo(String destination) {
        if (strategy == null) {
            System.out.println("No travel strategy selected!");
        } else {
            strategy.travel(destination);
        }
    }
}
```

- Step 4: Use the Strategy in the Main Program
```java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        TravelContext context = new TravelContext();

        // Travel by Car
        context.setTravelStrategy(new CarTravel());
        context.travelTo("New York");

        // Travel by Train
        context.setTravelStrategy(new TrainTravel());
        context.travelTo("Chicago");

        // Travel by Airplane
        context.setTravelStrategy(new AirTravel());
        context.travelTo("Los Angeles");
    }
}
```
- **Interchangeable Algorithms:**
- The main program (TravelContext) does not care about how traveling happens.
- You can easily switch between CarTravel, TrainTravel, and AirTravel without modifying the TravelContext code.

- **Decoupled Logic:**
- The logic for each strategy (algorithm) is in its own class, making the code clean and modular.

- **Extensibility:**
- If you want to add a new travel mode (e.g., BikeTravel), you only need to create a new class that implements TravelStrategy. No existing code is modified.

**Where to Use the Strategy Pattern?**
- When you have multiple ways to perform an operation (e.g., sorting algorithms, payment methods, transportation modes).
- When you want to avoid if-else or switch statements that make the code hard to read and maintain.
- When you want to add new algorithms easily without changing existing code.
