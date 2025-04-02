### **Serialization and deserialization**

### **What is Serialization?**
- Serialization in Java is the process of **converting an object into a byte stream** so that it can be **saved to a file, sent over a network, or stored in a database**. 
- The reverse process (converting bytes back to an object) is called **deserialization**.

---

### **Why Use Serialization?**
✅ **Save objects for later use** (e.g., storing game progress, user sessions).  
✅ **Send objects over a network** (e.g., chat applications, APIs).  
✅ **Write objects to files or databases** (e.g., caching, object storage).  
✅ **Remote Method Invocation (RMI)** (for distributed computing).

---

### **How to Make a Class Serializable?**
To make an object serializable, the class must:  
- Implement the **`Serializable`** interface.  
- Declare a **serialVersionUID** (optional but recommended).  
- Use `ObjectOutputStream` for **writing** the object.  
- Use `ObjectInputStream` for **reading** the object.

---

### **Basic Example of Serialization and Deserialization**
```java
import java.io.*;

// Step 1: Implement Serializable interface
class Person implements Serializable {
    private static final long serialVersionUID = 1L;  // Step 2: Add serialVersionUID
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Person p = new Person("Alice", 30);

        // Step 3: Serialize the object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            out.writeObject(p);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 4: Deserialize the object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Name: " + deserializedPerson.name + ", Age: " + deserializedPerson.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```
### **Output**
```
Object serialized successfully.
Name: Alice, Age: 30
```

---

### **Understanding serialVersionUID**
`serialVersionUID` is a unique identifier for a class. It helps during deserialization to ensure that the **same version of the class is used**.

Example:
```java
private static final long serialVersionUID = 1L;
```
🔹 If the class structure changes, objects with a different `serialVersionUID` will **fail to deserialize**.

---

### **Handling Transient Fields (Avoiding Serialization of Sensitive Data)**
🔹 Sometimes, we don’t want certain fields (like passwords) to be serialized. We can use the **`transient`** keyword to exclude them.

### **Example**
```java
import java.io.*;

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    String username;
    transient String password;  // This will NOT be serialized

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
```

---

### **Custom Serialization Using readObject() and writeObject()**
Sometimes, you may want to **customize** how an object is serialized (e.g., encrypting passwords before saving).

### **Example**
```java
import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    transient int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Custom serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();  // Serialize non-transient fields normally
        out.writeInt(salary * 2);  // Custom transformation
    }

    // Custom deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();  // Deserialize non-transient fields normally
        salary = in.readInt() / 2;  // Revert transformation
    }
}
```

---

### What Happens to Objects in a Simple Java Program?how it is differentiate from serialization

- When you create an object in Java and run the program without serialization, the object is simply stored in memory (RAM) and managed by the JVM (Java Virtual Machine).

### **Example:**
```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        p1.display();  // Just prints data, no serialization
    }
}
```

### **Output:**
```
Name: Alice, Age: 30
```

---

### **What Happens Internally?**

### **1. Object is Created in Heap Memory:**
- When `new Person("Alice", 30);` is executed, the object is stored in the **heap memory**.
- The reference `p1` points to that object.

### **2. Method Execution Happens in Stack Memory:**
- When `p1.display();` is called, the method runs in **stack memory**.

### **3. No Byte Conversion Happens:**
- Since we are just printing values and not saving/transmitting them, there is **no serialization happening**.

### **4. Garbage Collection:**
- The JVM manages objects, and when the program ends, the object is **garbage collected** if it's no longer needed.

---