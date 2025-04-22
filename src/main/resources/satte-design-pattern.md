### State Design Pattern

### What is the State Design Pattern?

The **State Design Pattern** is a behavioral design pattern that allows an object to change its behavior when its internal state changes. It looks like the object has changed its class.

This pattern encapsulates state-specific logic into separate classes, making code more modular, testable, and easier to manage.

---

### Why Use the State Pattern?

- To manage complex state-dependent behaviors cleanly.
- To eliminate large `if-else` or `switch-case` statements.
- To allow easy extension of new states without altering existing logic.

---

### Where Is It Used?

- **Vending Machines** (e.g., idle → coin inserted → item selected → dispense)
- **ATMs** (e.g., card inserted → authenticated → transaction)
- **Media Players** (play → pause → stop)
- **Traffic Light Systems**
- **UI components** (e.g., enabled, hovered, focused)

---

---

### Real-World Analogy

Imagine a **vending machine**:

- When it's **idle**, it's waiting for a coin.
- When you insert a coin, it goes into the **HasCoinState**.
- After making a selection, it moves to **DispensingState**.
- Each state has different behavior even though the object (vending machine) is the same.

---

### Code Explanation

###  State Interface
```java
public interface State {
    String handleRequest();
}
```
- All state classes will implement this interface to define their own behavior.

```java
public class IdleState implements State {
    public String handleRequest() {
        return "Machine is idle. Insert a coin.";
    }
}
```
- Represents the initial state of the machine.

```java
public class HasCoinState implements State {
    public String handleRequest() {
        return "Coin inserted. Please make a selection.";
    }
}
```
- Represents when a coin has been inserted and the user must select an item.

```java
public class DispensingState implements State {
    public String handleRequest() {
        return "Dispensing item... Please wait.";
    }
}
```
- Represents when the machine is dispensing the selected item.

```java
public class VendingMachine {
    private State state;

    public VendingMachine() {
        this.state = new IdleState(); // default state
    }

    public void setState(State state) {
        this.state = state;
    }

    public String performAction() {
        return state.handleRequest();
    }
}
```

- Holds a reference to the current State.
- Delegates the behavior to the current state.
- Allows state to be changed dynamically at runtime.


### Advantages
- Cleaner code through separation of concerns.
- Each state class is responsible for its own behavior.
- Adding new states requires minimal changes.
- Makes behavior changes easier and localized.

### Disadvantages
- Increases the number of classes in your codebase.
- Transitions between states must be managed explicitly.

