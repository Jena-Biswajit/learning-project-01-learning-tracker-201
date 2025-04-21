### Strategy Design Pattern

### Definition

- The **Strategy Design Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable. 
- This allows the algorithm to vary independently from clients that use it.

---

### Intent

To enable selecting an algorithm at runtime depending on the context, **without changing the code that uses it**.

---

### Real-World Analogy

Imagine a **navigation app** (like Google Maps). You can choose a route **strategy**:
- Fastest route
- Shortest route
- Avoid tolls

The app uses the **same interface**, but the logic underneath varies depending on the selected strategy.

---

### Code and Explanation

**1. `PaymentStrategy` Interface**

```java
public interface PaymentStrategy {
    void pay(int amount);
}
```

- This is the **common interface** for all payment methods (strategies).  
- Each strategy will implement this differently.

---

**2. `CreditCardPayment` Strategy**

```java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}
```

This strategy represents payment via Credit Card. It includes the card number and prints a message on payment.

---

**3. `UPIPayment` Strategy**

```java
public class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI ID: " + upiId);
    }
}
```

This strategy represents payment via UPI (Unified Payments Interface).

---

**4. `ShoppingCart` – Context Class**

```java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        paymentStrategy.pay(amount);
    }
}
```

**Explanation:**
- The cart doesn't care **how** payment is made.
- It just **uses the strategy** to complete payment.
- This allows switching strategies dynamically.

---

**5.  JUnit Test**

```java
import org.junit.jupiter.api.Test;

public class StrategyPatternTest {

    @Test
    public void testCreditCardPayment() {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9999"));
        cart.checkout(500);  // Output: Paid 500 using Credit Card: 1234-5678-9999
    }

    @Test
    public void testUPIPayment() {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new UPIPayment("user@upi"));
        cart.checkout(300);  // Output: Paid 300 using UPI ID: user@upi
    }
}
```

**O/P**

![Image](https://github.com/user-attachments/assets/e8c91888-aa97-4027-97a6-386db419bfe1)

![Image](https://github.com/user-attachments/assets/8cbad18f-c6f7-4a8c-8bed-c136b4ecf1ba)

---

### When to Use

- When you have multiple algorithms for a task and you want to switch between them.
- When you want to avoid a large switch/case block.
- When the behavior changes based on user selection or context.

---

## 🌍 Real-World Scenarios

| Use Case | Description |
|----------|-------------|
| Payment Gateways | Select between PayPal, Credit Card, UPI, etc. |
| Compression Tools | Switch between ZIP, RAR, 7Z algorithms |
| Sorting Algorithms | Use quicksort, mergesort, heapsort dynamically |
| Navigation Systems | Route by shortest, fastest, eco-friendly paths |

---

### Advantages

- Clean code with **encapsulated behaviors**.
- Open/Closed Principle – easy to add new strategies.
- Avoids conditional logic (like if/else or switch).

### Disadvantages

- More classes to manage.
- Client needs to understand which strategy to use.

---

### Summary

| Component | Role |
|----------|------|
| `PaymentStrategy` | Common strategy interface |
| `CreditCardPayment`, `UPIPayment` | Concrete strategies |
| `ShoppingCart` | Context that uses a strategy |
| `StrategyPatternTest` | JUnit tests |

---
