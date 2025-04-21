### Template Method Design Pattern

The **Template Method Design Pattern** defines the skeleton of an algorithm in a superclass but lets subclasses override specific steps of the algorithm without changing its structure.

---

### Intent

- To achieve code reuse by putting invariant parts of an algorithm in a base class and allowing subclasses to implement the variable parts.

---

### Real-World Analogy

Consider making **tea or coffee**:
- **Boil water**
- **Brew** tea or coffee (varies)
- **Pour in cup**
- **Add condiments** (varies)

The steps are the same (skeleton), but some actions differ based on the drink type. The template pattern fits perfectly here.

---

### Code and Explanation

**1. `Beverage` Abstract Class (Template)**

```java
public abstract class Beverage {
    // Template method
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps to be implemented by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
}
```

**Explanation:**
- `prepareBeverage()` is the **template method**.
- `brew()` and `addCondiments()` are **abstract steps** to be defined by subclasses.

---

**2. `Tea` Subclass**

```java
public class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}
```

**3. `Coffee` Subclass**

```java
public class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
```

---

**4.  JUnit Test**

```java
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    public void testTeaPreparation() {
        Beverage tea = new Tea();
        tea.prepareBeverage();
        // Output: Boiling water, Steeping the tea, Pouring into cup, Adding lemon
    }

    @Test
    public void testCoffeePreparation() {
        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
        // Output: Boiling water, Dripping coffee, Pouring into cup, Adding sugar and milk
    }
}
```
O/p

![Image](https://github.com/user-attachments/assets/4dbde687-e4ef-4b9f-a355-6e3208f1b2e6)

![Image](https://github.com/user-attachments/assets/9088471c-2a01-43a6-a5c9-22c79f353d54)
---

### When to Use

- When you have an algorithm with **common steps** but with some **variation** in the implementation.
- When you want to ensure a **fixed sequence** of operations.

---

### Real-World Scenarios

| Use Case | Description |
|----------|-------------|
| Cooking Process | Recipes with shared steps but differing ingredients |
| Report Generation | Fixed steps like header, body, footer generation |
| Game Frameworks | Define game loop but allow custom rules or visuals |

---

### Advantages

- Promotes **code reuse** and avoids duplication.
- Follows the **Hollywood Principle**: “Don't call us, we’ll call you.”
- Defines the **control flow** in a single place.

### Disadvantages

- Harder to **read** if there are too many abstract steps.
- **Inheritance**-based (less flexible than composition).

---

### Summary

| Component | Role |
|----------|------|
| `Beverage` | Abstract class containing the template method |
| `Tea`, `Coffee` | Subclasses that customize specific steps |
| `TemplateMethodTest` | JUnit test to validate behavior |

---
