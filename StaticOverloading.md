## Static Overloading
- Static overloading in Java refers to the concept of method overloading in static methods.
- Method overloading is when you define multiple methods in the same class with the same name but different parameters
  (i.e., different types, numbers, or order of parameters).
- The same principle applies to static methods, and static overloading simply means overloading static methods in the same way you would with instance methods.

**Static Methods:** Static methods belong to the class rather than instances of the class. 
- They can be called using the class name without creating an object of the class.
**Overloading:** Overloading occurs when you define multiple methods with the same name but with different parameter lists.
- The method signature must differ by the number or types of parameters.
- **Same Method Name:** The overloaded methods must have the same name.
- **Different Parameters:** The methods must differ in their parameter list (either by number of parameters, type of parameters, or both).
- **Return Type Doesn't Matter:** Overloading is determined based on the parameter list, not the return type. You cannot overload methods based solely on a different return type.

**Syntax**
```java
class ClassName {
    static <return_type> method_name(<parameters>) {
        // Method body
    }
}
```

