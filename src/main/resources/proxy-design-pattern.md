### Proxy Design Pattern

> The **Proxy Design Pattern** provides a surrogate or placeholder for another object to control access to it. 
> It is a structural design pattern used to **add an extra level of control** over an object.

---

### When and Why to Use It?

The Proxy pattern is useful when:
- You want to **control access** to an object (e.g., admin checks)
- You want to **add extra logic** (e.g., logging, caching, lazy loading)
- The actual object is **expensive or resource-heavy** to create

---

### Real-World Analogy

Imagine a secured **office folder**:
- Only the **admin** can open it.
- A **receptionist (proxy)** checks your ID before granting access.
- If you're not authorized, you’re **denied**.

---

### Class Diagram

### 1. `Folder` Interface

```java
public interface Folder {
    void access();
}
```

- This is a common interface implemented by both the RealFolder and the ProxyFolder.
- It ensures the proxy and the real object can be used interchangeably.

### RealFolder – The Actual Resource

```java
package com.example.proxydesignpattern;

public class RealFolder implements Folder {
    @Override
    public void access() {
        System.out.println("Accessing the real folder...");
    }
}
```
- This is the actual implementation. It represents the secured folder.
- Calling access() here means the folder is opened.

### 3. ProxyFolder – The Proxy or Gatekeeper

```java
package com.example.proxydesignpattern;

public class ProxyFolder implements Folder {
    private RealFolder realFolder;
    private String userRole;

    public ProxyFolder(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void access() {
        if ("Admin".equalsIgnoreCase(userRole)) {
            realFolder = new RealFolder();
            realFolder.access();
        } else {
            System.out.println("Access Denied. Only Admin can access the folder.");
        }
    }
}
```

- ProxyFolder checks if the user role is "Admin".
- If yes, it creates the real object and delegates the call.
- If not, access is denied.
- This helps control who can interact with RealFolder.

### When to Use
- When you want to add security or access control.
- To perform lazy initialization (e.g., loading files, DB connections).
- To log access to an object or resource.
- When using remote objects or caching mechanisms.

### Real-World Scenarios

- File Access System :Restrict access to certain folders/files
- Virtual Proxy	:Load images/files only when needed (e.g., in image viewers)
- Remote Proxy	:Access remote services via local proxy (e.g., Java RMI)
- Smart Proxy	:Add logging, counting, or tracking logic to existing objects

### Advantages
- Adds an additional layer of security or behavior.
- Supports lazy loading and resource management.
- Promotes separation of concerns.

### Disadvantages
- Increased complexity due to an extra layer.
- Slight overhead in performance.

**TestCase**

```java
package com.example.singleton.proxytest;

import com.example.proxydesignpattern.Folder;
import com.example.proxydesignpattern.ProxyFolder;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    public void testAdminAccess() {
        Folder adminFolder = new ProxyFolder("Admin");
        adminFolder.access();  // should print: Accessing the real folder...
    }

    @Test
    public void testGuestAccess() {
        Folder guestFolder = new ProxyFolder("Guest");
        guestFolder.access();  // should print: Access Denied
    }
}
```

**0/p**

![Image](https://github.com/user-attachments/assets/decd4d8d-f789-476c-af43-571889e15aaa)

![Image](https://github.com/user-attachments/assets/9a2a136a-0cd4-4e8a-ac10-f30374f28655)
