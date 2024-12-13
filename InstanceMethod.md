## Instance method
- In Java, an instance method is a method that belongs to an instance of a class, meaning it operates on data
  that belongs to a specific object created from the class. To call an instance method, you must first create an instance (or object) of the class.
- Instance methods typically operate on instance variables, which are variables that are specific to each object of the class.

- **Instance methods** can access instance variables and other instance methods of the class.
- They are called using an object of the class.
- They can be non-static, which means they are bound to a specific instance of the class, not to the class itself.

**Syntax:**
```java
<access_modifier> <return_type> <method_name>(<parameters>) {
    // Method body
}
```
**Example**
```java
public class InstanceMethod
{
    // Instance variable
    int age;
    // Instance method
    public void setAge(int newAge)
    {
        age = newAge; // Modifying the instance variable
    }
    public int getAge()
    {
        return age; // Accessing the instance variable
    }

    public static void main(String[] args)
    {
        // Creating an object
        InstanceMethod person = new InstanceMethod();

        // Using instance method to set age
        person.setAge(25);

        // Using instance method to get age
        System.out.println("Person's Age: " + person.getAge()); // Output: 25
    }
}
```
