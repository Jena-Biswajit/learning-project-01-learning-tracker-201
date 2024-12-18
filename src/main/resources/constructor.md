## Default Constructor
- A default constructor is a constructor provided by Java (or explicitly written by the programmer) that has no parameters.
- Its purpose is to initialize an object with default values.
- If no constructor is defined in the class, Java automatically provides a no-argument constructor, known as the default constructor.

- **No Parameters:** It does not accept any arguments.
- **Implicitly Defined:** If you don’t write any constructor, the Java compiler provides a default constructor.
- **Does Nothing by Default:** The default constructor created by the compiler initializes instance variables to
  their default values (e.g., 0 for numbers, null for objects, false for booleans).
- If no constructors are explicitly defined in the class, Java automatically inserts a default constructor at compile time.
- If you write any constructor in your class (e.g., a parameterized constructor), Java will no longer provide a default constructor 
  automatically.
- If you still need a default constructor in such cases, you must define it explicitly.

- A default constructor using this in Java is a constructor that uses the this keyword to invoke another constructor of the same class.
- This approach avoids repeating initialization logic across constructors, promoting code reuse and cleaner design.
- In Java, the this keyword refers to the current object.
- It can also be used to call one constructor from another within the same class. This is called constructor chaining.
**Example**
```java
```
## parameterized Constructor
- A parameterized constructor is a constructor in Java that accepts one or more parameters.
- It allows you to initialize an object with specific values when it is created.
- This is useful for setting up object properties dynamically at the time of object creation, rather than relying on default values.
- **Accepts Parameters:** Unlike the default constructor, it requires arguments to be passed when creating an object.
- **Used for Initialization:** Helps initialize object fields (instance variables) with specific values.
- **Overloading:** A class can have multiple parameterized constructors, allowing flexibility in object initialization.
- **Dynamic Initialization:** They allow the object to be initialized with specific values at runtime, rather than hardcoding default values.
  
**Syntax**
```
class ClassName {
    // Constructor with parameters
    ClassName(parameter1, parameter2, ...) {
        // Constructor body
    }
}
```

**Example**
```
```

