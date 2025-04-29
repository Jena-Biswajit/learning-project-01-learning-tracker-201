### Constructor
- A constructor in Java is a special method used to initialize an object when it is created. It has the same name as the class and does not have a return type (not even void).
- A constructor is a block of code that runs when an object is instantiated (created).
- Its purpose is to initialize the object's properties.
- It is automatically called when the new keyword is used to create an object.

**Same Name as the Class:** The constructor name must match the class name.

**No Return Type:** Constructors do not have a return type (not even void).

**Automatic Call:** It is invoked automatically when the object is created.

**Overloading Allowed:** Multiple constructors can exist in the same class (constructor overloading).

Java has two main types of constructors:

**(A) Default Constructor**
- If no constructor is explicitly defined in a class, Java automatically provides a default constructor.
- It has no parameters and initializes the object with default values.
- A constructor that accepts parameters to initialize the object with specific values.
- You define the parameters to initialize fields directly when creating an object.

- **Example:**
```java
package com.oops;

class Person
{
    String name ;
    int age;
    // Default Constructor
    public  Person (){
        // this keywork used to call parameterized Constructor
        this("biswajit jena",25);
    }
    //parameterized Constructor
    public  Person(String myName,int myAge)
    {
      this.name= myName; // set name with same variable
      this.age= myAge; // set age with same variable
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

}
public class DefaultConstructorExample {
    public static void main(String[] args) {
        //creste object for MyDetails class
        Person biswajit = new Person();
        biswajit.display(); // to dispay detail
    }
}
```
### Parameterized Constructor
- A constructor that accepts parameters to initialize the object with specific values.
- The parameters to initialize fields directly when creating an object.

**Example**
```java
package com.oops;


class FindAverage {
    int num1,num2,num3;
    int avg=0;
    FindAverage(int num1,int num2,int num3) {
        avg = num1+num2+num3/3;
    }
    void display(){
        System.out.println("average = "+avg);
    }
}
public class ParamConstructorExample {
    public static void main(String[] args) {
        FindAverage average = new FindAverage (5,6,7);
        average.display();
    }
}
```
- constructors can be ```overloaded```, meaning multiple constructors with the same name but different parameter lists can exist.
- Java does not have a built-in ```copy constructor``` like C++. However, you can define one manually to create a new object by copying data from an existing object.
- The this keyword is used to call another constructor in the same class.
- Helps in reducing code duplication.
- When a class inherits from another class, the parent class constructor is called first (using super()).
- The child class can explicitly call the parent class constructor using the super keyword.

- **Constructors are Not Inherited:** Constructors of a parent class are not inherited by the child class.

- **Default Constructor Limitation:** If you define any constructor in your class, Java will not provide a default constructor.

- **Chaining with this and super:** Use this to call a constructor in the same class and super for the parent class.

- **Private Constructor:** A constructor can be private, typically used in the Singleton design pattern.