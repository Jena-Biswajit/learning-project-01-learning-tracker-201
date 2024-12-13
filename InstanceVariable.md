## Instance variable
- In Java, an instance variable is a variable that is declared inside a class but outside any method,
   constructor, or block. Instance variables are specific to each instance (object) of the class.
- They are used to store the state or attributes of an object. Each object of the class has its own copy of instance variables,
  and they can hold different values for different objects.

**Key Points About Instance Variables:**
- **Belong to objects:** Instance variables are associated with individual instances (objects) of a class.
- **Memory allocation:** Memory for instance variables is allocated when an object is created, and the values are stored separately for each object.
- **Access modifiers:** Instance variables can have different access levels, such as private, protected, public, or default (package-private).
- **Default values:** If an instance variable is not explicitly initialized, it will have a default value based on its type (e.g., 0 for int, null for objects, false for boolean).
- **Instance vs Static variables:** Unlike instance variables, static variables belong to the class itself, and they are shared across all instances of the class.

**Example**
```java
public class InstanceVariable
{
    String name;

    public static void main(String[] args)
    {
        // Creating objects
        InstanceVariable obj1 = new InstanceVariable();
        InstanceVariable obj2 = new InstanceVariable();

        // Assigning values to instance variables
        obj1.name = "Biswa";
        obj2.name = "Jit";

        // Accessing instance variables
        System.out.println("Object 1 Name: " + obj1.name); // Output: Alice
        System.out.println("Object 2 Name: " + obj2.name); // Output: Bob
    }
}
```
