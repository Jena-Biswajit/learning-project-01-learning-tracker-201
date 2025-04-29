### Template Design Pattern
- The Template Design Pattern defines the skeleton of an algorithm in a base class but allows the implementation of specific steps to be overridden by subclasses.
- This pattern is useful when you have a fixed overall structure (or process) but need variations in certain steps.

**How It Works?**
- **Abstract Class:** Defines the template method, which outlines the structure of the algorithm. It contains both fixed steps and abstract methods for customizable steps.
- **Concrete Classes:** Provide implementations for the abstract methods defined in the abstract class.
- The template method calls the concrete methods in a fixed order, ensuring the overall structure remains unchanged.

- **Real-Life Analogy**
- Think about making tea and coffee:

- **Steps for Tea:** Boil water → Add tea leaves → Pour into a cup → Add sugar/milk.
- **Steps for Coffee:** Boil water → Add coffee powder → Pour into a cup → Add sugar/milk.
- The overall process is the same (boiling, pouring, adding extras), but the specifics (tea leaves or coffee powder) differ.

**Step 1: Abstract Class with Template Method**
```java
abstract class Beverage {
// Template method: defines the fixed structure of the process
public final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    addCondiments();
}

    // Steps with default implementation
    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // Abstract steps to be defined by subclasses
    protected abstract void brew();          // Brewing specific to the beverage
    protected abstract void addCondiments(); // Add condiments specific to the beverage
}
```

**Step 2: Concrete Classes**
```java
class Tea extends Beverage {
    @Override
    protected void brew() {
    System.out.println("Steeping the tea...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
    System.out.println("Dripping coffee through filter...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}
```

- **Step 3: Use the Template Method in the Main Program**
```java
public class TemplatePatternDemo {
        public static void main(String[] args) {
        System.out.println("Making Tea:");
        Beverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println("\nMaking Coffee:");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
```

- The prepareRecipe method defines the fixed sequence of steps for making a beverage.
- It ensures that the overall process (boiling, pouring, adding extras) is consistent across subclasses.
**Customizable Steps:**

- **Subclasses** (Tea, Coffee) implement the specific steps (brew and addCondiments) as needed.

- **Reusability:**
- The common steps (boilWater, pourInCup) are implemented in the abstract class and reused by all subclasses.

- **Extensibility:**
- If a new beverage (e.g., HotChocolate) is introduced, you only need to create a new subclass and implement the specific steps.

- **Where to Use the Template Pattern?**
- When you have an overall process that stays the same but specific steps may vary.
- To avoid duplicating common steps in different implementations.
- To enforce a consistent structure while allowing flexibility in certain parts of the process.