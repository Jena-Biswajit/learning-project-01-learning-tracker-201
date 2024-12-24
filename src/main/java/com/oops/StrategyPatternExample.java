package com.oops;


//Define the Strategy Interface
interface TravelStrategy {
    void travel(String destination);
}

//Create Concrete Strategies
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


//Create the Context Class
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

public class StrategyPatternExample {
        public static void main(String[] args) {
            TravelContext context = new TravelContext();

            // Travel by Car
            context.setTravelStrategy(new CarTravel());
            context.travelTo("Uttarakhand");

            // Travel by Train
            context.setTravelStrategy(new TrainTravel());
            context.travelTo("Manali");

            // Travel by Airplane
            context.setTravelStrategy(new AirTravel());
            context.travelTo("Kashmir");
        }
}

