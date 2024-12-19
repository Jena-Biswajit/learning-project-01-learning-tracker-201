## Static Block
- A static block is used to initialize static variables or execute code that needs to run only once when the class is loaded into memory.
- It is executed only once, no matter how many objects of the class are created.
- Multiple static blocks are executed in the order they appear in the class.
- Static blocks are for class-level initialization and execute only once.
- Static blocks execute before main(), and non-static blocks execute before constructors during object creation.
- **Class Loading Phase:**
- When the class is loaded by the JVM, all static blocks are executed in the order they appear.
- staticVar is initialized in static blocks.

**Example**
```java
```
  
**Static Method :** Static method is always call once.
  
## Non-Static Block
- A non-static block is used to initialize instance variables or execute code for each object.
- It is executed every time an object is created, before the constructor.
- Multiple non-static blocks are executed in the order they appear in the class.
- Non-static blocks are for object-level initialization and execute before the constructor for each object.
- **Object Creation Phase:**
- Each time an object is created:
- Non-static blocks are executed in the order they appear.
- The constructor is executed after all non-static blocks.

**Main Method Execution:**
- The main() method starts execution after all static blocks are executed.
- The order of execution for blocks within their type (static or non-static) is top to bottom.

**Example**
```java
```
