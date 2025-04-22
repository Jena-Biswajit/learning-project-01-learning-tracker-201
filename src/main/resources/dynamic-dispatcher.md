# 🔄 Dynamic Dispatcher Concept

## 📘 What is Dynamic Dispatch?

**Dynamic dispatch** is a programming mechanism that determines which implementation of a method to call **at runtime**, based on the actual object (not just the reference type). It enables **runtime polymorphism**.

In Java, this means when a method is **overridden**, the JVM chooses the correct implementation to invoke **dynamically**, depending on the object that is referenced.

---

## 🧠 Why is Dynamic Dispatch Important?

Dynamic dispatch is crucial because:

- It allows **polymorphism**.
- Enables **extensibility** — behavior can be changed by substituting implementations.
- Encourages **decoupling** — callers don’t need to know the exact class.

---

## 🧩 Where Is It Used?

Dynamic dispatch is a core part of **object-oriented languages** and is used in many design patterns, including:

| Design Pattern        | Usage of Dynamic Dispatch                                     |
|-----------------------|---------------------------------------------------------------|
| Strategy              | Calls the selected strategy’s method dynamically.             |
| State                 | Changes object behavior based on internal state dynamically.  |
| Command               | Executes the correct command implementation.                  |
| Visitor               | Uses **double dispatch** (visitor + visited object).          |
| Factory Method        | Returns an interface or superclass, methods called dynamically.|

---

## 🛠 Real-World Example: Strategy Pattern Using Dynamic Dispatch

```java
// Step 1: Define Strategy Interface
public interface PaymentProcessor {
    String processPayment(double amount);
}
```

```java
// Step 2: Concrete implementations
public class CreditCardProcessor implements PaymentProcessor {
    public String processPayment(double amount) {
        return "Paid ₹" + amount + " using Credit Card.";
    }
}

class PayPalProcessor implements PaymentProcessor {
    public String processPayment(double amount) {
        return "Paid ₹" + amount + " using PayPal.";
    }
}
```

```java
// Step 3: Caller method
public class PaymentService {
    public String makePayment(PaymentProcessor processor, double amount) {
        return processor.processPayment(amount); // 🔥 Dynamic Dispatch
    }
}
```

```java
// Step 4: Client Code
public class DynamicDispatchExample {
public static void main(String[] args) {
PaymentService service = new PaymentService();

        // The actual method called is decided at runtime 🔽
        System.out.println(service.makePayment(new CreditCardProcessor(), 500));
        System.out.println(service.makePayment(new PayPalProcessor(), 800));
    }
}
```

### Code Explanation
- PaymentProcessor is an interface.
- CreditCardProcessor and PayPalProcessor implement the interface.
- PaymentService depends only on the interface, not on any specific implementation.
- When you call makePayment(...), Java decides at runtime which version of processPayment() to execute.
