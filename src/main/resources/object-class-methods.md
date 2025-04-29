## Object class Methods
- The Object class in Java is the ultimate superclass from which every class is derived.
- Its methods provide foundational functionality for all Java objects.
- Understanding and effectively using these methods is crucial for Java programming.

**1. getClass()**
- The getClass() method returns the runtime class of the object. It helps identify the exact type of an object during runtime.
```
public final Class<?> getClass();
```
- Useful in debugging, logging, or when working with polymorphism to determine the exact class of an object.

**Example**
```
class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("Class: " + demo.getClass().getName());
    }
}
```

**hashCode()**
- The hashCode() method returns an integer that represents the hash code of the object.
- It's used in collections like HashMap and HashSet for efficient storage and retrieval.
- If two objects are considered equal (equals returns true), they must have the same hash code.
- Two objects with the same hash code are not necessarily equal.
```
public native int hashCode();
```
- The default implementation uses the memory address of the object.
**Example:**
```
class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("HashCode: " + demo.hashCode());
    }
}
```
**Overriding:**
- In custom classes, override hashCode() to maintain consistency with equals().
```
@Override
public int hashCode() {
    return 31 * id + name.hashCode();
}
```
**3. toString()**
- Converts an object to its string representation.
- By default, it returns the class name, the @ symbol, and the hash code in hexadecimal.
```
public String toString();
```
- The default implementation is generally not useful for debugging.

**Example:**
```
class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("ToString: " + demo.toString());
    }
}
```
**Overriding:**
- Custom implementations provide meaningful information.
```
@Override
public String toString() {
    return "Demo{name='" + name + "', value=" + value + "}";
}
```
**4. equals(Object obj)**
- Determines whether two objects are logically equal. By default, it checks reference equality.
```
public boolean equals(Object obj);
```
- Returns true if both references point to the same object.
**Example:**
```
class Demo {
    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
        System.out.println("Equals: " + demo1.equals(demo2)); // false
    }
}
```
**Overriding:**
Override equals to define logical equality.
```
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Demo demo = (Demo) obj;
    return id == demo.id && name.equals(demo.name);
}
```
