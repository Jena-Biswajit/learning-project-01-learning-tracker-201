---

## Abstract Factory Design Pattern

### ✅ Purpose
The Abstract Factory Pattern provides an interface for creating **families of related or dependent objects** without specifying their concrete classes.

> It's like a factory of factories.

### 💡 Real-World Analogy
Think of a UI toolkit that supports multiple themes (e.g., Light Theme, Dark Theme). Each theme provides different versions of UI elements like buttons and checkboxes. The Abstract Factory allows you to create entire families (theme sets) of elements without knowing the exact classes.

---

### 🧱 Components
- **Abstract Factory**: Declares interfaces for a set of related objects.
- **Concrete Factory**: Implements the creation of objects for a particular family.
- **Abstract Product**: Declares interface for a type of product.
- **Concrete Product**: Implements the product for a specific variant.
- **Client**: Uses only interfaces from Abstract Factory and Abstract Product.

---

### 🔧 Code Example (Java)
#### Abstract Factory and Product Interfaces
```java
// Abstract Product
public interface Button {
    void paint();
}

// Concrete Product
public class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a Windows Button");
    }
}

public class MacOSButton implements Button {
    public void paint() {
        System.out.println("Rendering a MacOS Button");
    }
}

// Abstract Factory
public interface GUIFactory {
    Button createButton();
}

// Concrete Factories
public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
}

public class MacOSFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }
}
```

#### Client Code
```java
public class Application {
    private Button button;

    public Application(GUIFactory factory) {
        button = factory.createButton();
    }

    public void renderUI() {
        button.paint();
    }
}
```
---

### ✅ Unit Test with JUnit
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractFactoryTestJUnit {
    @Test
    void testWindowsFactoryButton() {
        GUIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        assertNotNull(button);
    }

    @Test
    void testMacOSFactoryButton() {
        GUIFactory factory = new MacOSFactory();
        Button button = factory.createButton();
        assertNotNull(button);
    }
}
```
**O/P**

![Image](https://github.com/user-attachments/assets/68d8ca26-0e80-4a8e-bf18-df156774ba69)

![Image](https://github.com/user-attachments/assets/1d8da0ec-c727-403d-87b9-eac1b7b43cf2)
---

### ✅ Explanation of Code
- `GUIFactory` is the abstract factory.
- `WindowsFactory` and `MacOSFactory` are concrete factories.
- `Button` is an abstract product.
- `WindowsButton` and `MacOSButton` are concrete products.
- The `Application` class (client) uses only abstract interfaces, making the application portable across platforms.

---

### ✅ Advantages
- Promotes consistency among products.
- Isolates concrete classes.
- Makes it easy to swap families of products.

### ⚠️ Disadvantages
- More complex due to multiple factory and product classes.
- Adding new product types requires changes to all factories.

---

### 🌐 Real-World Use Cases
- GUI libraries that support multiple operating systems.
- Database drivers supporting multiple DBMS types.
- Cross-platform game engines (e.g., Unity supporting Android/iOS builds).

---

### ✅ Summary Table
| Role              | Example Class        |
|-------------------|----------------------|
| Abstract Factory  | `GUIFactory`         |
| Concrete Factory  | `WindowsFactory`, `MacOSFactory` |
| Abstract Product  | `Button`             |
| Concrete Product  | `WindowsButton`, `MacOSButton`   |
| Client            | `Application`        |



