### 1) Breaking of Singleton in Serialization and Deserialization

When you make a `Serializable` Singleton and don’t guard against it, Java’s deserialization mechanism will create a *new* instance—breaking your one-only-one guarantee.

### Example

```java
package com.example.singleton.serialization;

import java.io.Serializable;

public class SingletonSerialize implements Serializable {
    private static final long serialVersionUID = 1L;

    // Eagerly initialized Singleton instance
    private static final SingletonSerialize INSTANCE = new SingletonSerialize();

    // Private constructor prevents external instantiation
    private SingletonSerialize() {
        System.out.println("SingletonSerialize constructor called");
    }

    public static SingletonSerialize getInstance() {
        return INSTANCE;
    }

    /**
     * Ensures that the existing INSTANCE is returned during deserialization.
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}
```

**Testcase**
```java
package com.example.singleton.serialization;

import java.io.*;

public class SingletonSerializeTest {
    public static void main(String[] args) throws Exception {
        // 1) Get the Singleton instance
        SingletonSerialize s1 = SingletonSerialize.getInstance();

        // 2) Serialize it to a byte array
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bout)) {
            oos.writeObject(s1);
        }

        // 3) Deserialize it back
        SingletonSerialize s2;
        try (ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()))) {
            s2 = (SingletonSerialize) ois.readObject();
        }

        // 4) Compare references
        System.out.println("s1 hashCode = " + s1.hashCode());
        System.out.println("s2 hashCode = " + s2.hashCode());
        System.out.println("Same instance? " + (s1 == s2));
    }
}
```

**O/p**

![Image](https://github.com/user-attachments/assets/6b791825-818b-4e7f-9e98-44a2996a965c)

**Why this happens:**
- During deserialization, Java doesn’t reuse the existing `INSTANCE`.
- Instead, it allocates a fresh object, populates its fields, and returns it.

---

### 2) How to Stop Singleton Breaking in the Above Use Case

To prevent the Singleton from breaking during deserialization, add a `readResolve()` method to your Singleton class.

### Modified Singleton with `readResolve()`

```java
package com.example.singleton.serialization;
import java.io.Serializable;

public class SingletonSerialize implements Serializable {
    private static final long serialVersionUID = 1L;

    // Eagerly initialized Singleton instance
    private static final SingletonSerialize INSTANCE = new SingletonSerialize();

    // Private constructor prevents external instantiation
    private SingletonSerialize() {
        System.out.println("SingletonSerialize constructor called");
    }

    public static SingletonSerialize getInstance() {
        return INSTANCE;
    }

    /**
     * Ensures that the existing INSTANCE is returned during deserialization.
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}
```

### How It Works
1. **Serialization**: Writes the state of `INSTANCE` to the output stream.
2. **Deserialization**: JVM creates a temporary object and invokes `readResolve()`.
3. **Replacement**: The result of `readResolve()` (the real singleton instance) replaces the temporary one.


### Verification

```
// Serialize
SingletonSerialize s1 = SingletonSerialize.getInstance();
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.ser"));
oos.writeObject(s1);
oos.close();

// Deserialize
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.ser"));
SingletonSerialize s2 = (SingletonSerialize) ois.readObject();
ois.close();

// Validate
System.out.println(s1 == s2); // true
```
**o/p**

![Image](https://github.com/user-attachments/assets/7087007a-13eb-4d6f-afa8-2d817fd1ea05)

With `readResolve()`, `s1` and `s2` refer to the same instance, preserving the Singleton property.

---


### Breaking Singleton with Cloning

- Even if Singleton is protected from serialization, it can still be broken by cloning the object using the clone() method from Object class.

**Example**

```
package com.example.singleton.cloning;

public class SingletonClone implements Cloneable {
    private static final SingletonClone INSTANCE = new SingletonClone();

    private SingletonClone() {
        // private constructor
    }

    public static SingletonClone getInstance() {
        return INSTANCE;
    }

    // default clone method
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return INSTANCE;  // return the existing instance
//    }
}
```

**TestCase**
```
package com.example.singleton.serialization;

import com.example.singleton.cloning.SingletonClone;

public class SingletonCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonClone s1 = SingletonClone.getInstance();
        SingletonClone s2 = (SingletonClone) s1.clone();

        System.out.println("s1 hashCode = " + s1.hashCode());
        System.out.println("s2 hashCode = " + s2.hashCode());
        System.out.println("Same instance? " + (s1 == s2));
    }
}
```

**Output**

![Image](https://github.com/user-attachments/assets/c2facb2a-ca32-49c0-b505-075cf07c88a4)

### Why this happens

- The clone() method creates a new instance of the class by copying field values.

- This bypasses the private constructor and violates the Singleton rule.

### 4) How to Prevent Singleton Breaking via Cloning

- Override the clone() method to return the same singleton instance instead of creating a new one.

- Fixed SingletonClone Class

**Example**

```
package com.example.singleton.cloning;

public class SingletonClone implements Cloneable {
    private static final SingletonClone INSTANCE = new SingletonClone();

    private SingletonClone() {
        // private constructor
    }

    public static SingletonClone getInstance() {
        return INSTANCE;
    }

    // default clone method
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return INSTANCE;  // return the existing instance
    }
}
```

**o/p**

Now cloning will no longer create a new object.

![Image](https://github.com/user-attachments/assets/92b81f1c-02c4-4880-9109-1908453e1be0)
