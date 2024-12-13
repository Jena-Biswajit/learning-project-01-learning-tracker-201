## Non-static overloading
- Non-static overloading in Java refers to the concept of method overloading with non-static (instance) methods.
- Similar to static method overloading, non-static overloading occurs when a class has multiple methods with the same name but different parameter lists
  (different number of parameters, types, or the order of parameters).
- These methods can then be called on an object of the class, and the appropriate method is selected based on the arguments passed at the time of the method call.

- **Non-static Methods:** Non-static methods belong to instances of a class, meaning they are called on objects of the class.
- These methods can access both instance and static variables and methods of the class.
- **Overloading:** Overloading occurs when there are multiple methods with the same name but different parameter lists within the same class.
- The method signature (method name and parameter list) must differ in the number or types of parameters.

- **Same Method Name:** All overloaded methods must have the same name.
- **Different Parameters:** The methods must differ by the number of parameters, type of parameters, or the order of parameters.
- **Return Type Doesn't Matter:** Overloading is determined based on the parameter list, not the return type. You cannot overload methods by changing only the return type.

**Example**
```java
public class NonstaticOverloading
{

        // Non-static method to multiply two integers
        public int multiply(int a, int b)
        {
            return a * b;
        }

        // Overloaded non-static method to multiply three integers
        public int multiply(int a, int b, int c)
        {
            return a * b * c;
        }

        // Overloaded non-static method to multiply two doubles
        public double multiply(double a, double b)
        {
            return a * b;
        }

        public static void main(String[] args)
        {
            NonstaticOverloading multiplier = new NonstaticOverloading(); // Create an object

            // Calling different versions of the non-static 'multiply' method
            System.out.println("Multiplication of two integers: " + multiplier.multiply(5, 10)); // 50
            System.out.println("Multiplication of three integers: " + multiplier.multiply(2, 3, 4)); // 24
            System.out.println("Multiplication of two doubles: " + multiplier.multiply(5.5, 1.2)); // 6.6
        }
}
```
