## Static Class
- In Java, a static class refers to a nested class that is marked with the static keyword.
- Static classes can only be used within the scope of their outer class.
- A static class has some important differences compared to a non-static inner class.

**Key Characteristics of a Static Class:**
- **Nested Class:** A static class is always a nested class, meaning it is defined inside another class.
- **No Reference to Outer Class Instance:** A static nested class can be instantiated without needing an instance of the outer class.
- It does not have a reference to the instance variables or methods of the outer class.
- It can only access the static members (variables and methods) of the outer class.
- **Memory Efficiency:** Since a static nested class does not hold a reference to an outer class object, it can be more memory efficient when instances of the outer class do not need to be created.

**Syntax**
```java
class OuterClass {
    static class StaticNestedClass {
        // Static nested class content
    }
}
```
**Note**
**Differences Between Static and Non-static Inner Classes:**
**1.Reference to Outer Class:**
- **Static nested class:** It does not have an implicit reference to the outer class.
- It can only access static members of the outer class.  
- **2.Non-static inner class:** It has an implicit reference to an instance of the outer class 
- can access both instance and static members of the outer class.

**2.Instantiation:**
- **Static nested class:** You can instantiate it without creating an instance of the outer class. It is associated with the class itself.
- **Non-static inner class:** You need an instance of the outer class to instantiate a non-static inner class.

**Example**
```java

