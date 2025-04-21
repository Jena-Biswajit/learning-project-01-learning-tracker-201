### Factory Design Pattern

- The **Factory Design Pattern** is a creational pattern that provides a way to delegate the instantiation logic to child classes.

---

###  Intent

To **encapsulate object creation logic** and allow the code to refer to the newly created object via a common interface.

---

### Real-World Analogy

A **logistics company** might create different types of transportation:
- Road logistics → Truck
- Sea logistics → Ship

You use a factory to create the right type of transport without knowing how it's created.

---

### Code and Explanation

**1. `Transport` Interface**

```java
public interface Transport {
    void deliver();
}
```

**2. `Truck` and `Ship` Implementations**

```java
public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by road in a truck");
    }
}

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea in a ship");
    }
}
```

**3. `TransportFactory`**

```java
public class TransportFactory {
    public static Transport getTransport(String type) {
        if ("truck".equalsIgnoreCase(type)) {
            return new Truck();
        } else if ("ship".equalsIgnoreCase(type)) {
            return new Ship();
        } else {
            throw new IllegalArgumentException("Unknown transport type");
        }
    }
}
```

**4. JUnit Test**

```java
import org.junit.jupiter.api.Test;

public class FactoryPatternTest {

    @Test
    public void testTruckDelivery() {
        Transport transport = TransportFactory.getTransport("truck");
        transport.deliver();
    }

    @Test
    public void testShipDelivery() {
        Transport transport = TransportFactory.getTransport("ship");
        transport.deliver();
    }
}
```
**O/P**

![Image](https://github.com/user-attachments/assets/c9c116bd-1e02-475e-9849-4f3ba2f98b91)

![Image](https://github.com/user-attachments/assets/f0e58f75-12c4-4fb7-a9cc-9c3570cf37b3)
---

### When to Use

- When object creation is **complex** or **repetitive**.
- When you want to **decouple the client** from the actual implementation classes.

---

### Real-World Scenarios

| Use Case | Description |
|----------|-------------|
| GUI Toolkits | Creating buttons for different OS types |
| Notification Systems | Sending SMS, Email, or Push Notifications |
| Payment Gateways | Choosing between PayPal, Stripe, etc. |

---

### Advantages

- Simplifies object creation logic.
- Increases flexibility and **maintainability**.
- Promotes **loose coupling**.

### Disadvantages

- Adds extra classes.
- Complexity increases for very simple instantiations.

---

### Summary

| Component | Role |
|----------|------|
| `Transport` | Interface for products |
| `Truck`, `Ship` | Concrete product classes |
| `TransportFactory` | Factory class that creates instances |
| `FactoryPatternTest` | JUnit test to validate behavior |

---
