### Garbage Collection 

- ***Garbage collection*** in Java is an automatic memory management process that helps Java programs run efficiently.
- Java programs compile to bytecode that can be run on a Java Virtual Machine (JVM).
- When Java programs run on the JVM, objects in the heap, which is a portion of memory dedicated to the program.
- Eventually, some objects will no longer be needed.
- The garbage collector finds these unused objects and deletes them to free up memory.
- The garbage collector automatically finds and removes objects that are no longer needed, freeing up memory in the heap.
- It runs in the background as a daemon thread, helping to manage memory efficiently without requiring the programmer’s constant attention.

### Working of Garbage Collection
- Java garbage collection is an automatic process that manages memory in the heap.
- It identifies which objects are still in use (referenced) and which are not in use (unreferenced).
- Unreferenced objects can be deleted to free up memory.
- The programmer does not need to mark objects to be deleted explicitly. The garbage collection implementation lives in the JVM. 

### Types of Activities in Java Garbage Collection

- ***Minor or incremental Garbage Collection:*** This occurs when unreachable objects in the Young Generation heap memory are removed.
- ***Major or Full Garbage Collection:*** This happens when objects that survived minor garbage collection are removed from the Old Generation heap memory. 
- It occurs less frequently than minor garbage collection.

***1. Unreachable Objects***
- An object is said to be unreachable if it doesn’t contain any reference to it.

***Exaple***
```
Note: Objects which are part of the island of isolation are also unreachable.

Integer i = new Integer(4);
// the new Integer object is reachable  via the reference in ‘i’

i = null;
// the Integer object is no longer reachable. 
```

***2. Eligibility for Garbage Collection***

- An object is said to be eligible for garbage collection if it is unreachable. 
- After i = null, integer object 4 in the heap area is suitable for garbage collection in the above Example.

***How to Make an Object Eligible for Garbage Collection?***

- ***Nullifying the reference variable:*** Set the reference to null.
- ***Re-assigning the reference variable:*** Assign a new object to the reference.
- ***An object created inside the method:*** Objects created within a method are eligible for garbage collection once the method completes.
- ***Island of Isolation:*** Objects that are isolated and not referenced by any reachable objects.

### Ways to Request JVM to Run Garbage Collection
- Once an object is eligible for garbage collection, it may not be destroyed immediately.
- The garbage collector runs at the JVM’s discretion, and you cannot predict when it will occur.
- We can also request JVM to run Garbage Collector. There are two ways to do it :
- ***Using System.gc():*** This static method requests the JVM to perform garbage collection.
- ***Using Runtime.getRuntime().gc():*** This method also requests garbage collection through the Runtime class.

### 3. Finalization

- Before destroying an object, the garbage collector calls the finalize() method to perform cleanup activities. 
- The method is defined in the Object class as follows:

- **protected void finalize() throws Throwable**

***Note:***

- The finalize() method is called by Garbage Collector, not JVM.
- The default implementation of finalize() is empty, so overriding it is recommended for resource cleanup.
- The finalize() method is called only once per object.
- If an uncaught exception is thrown by the finalize() method, the exception is ignored, and the finalization of that object terminates.
- 
- ***Advantages of Garbage Collection in Java***
- It makes java memory-efficient because the garbage collector removes the unreferenced objects from heap memory.
- It is automatically done by the garbage collector(a part of JVM), so we don’t need extra effort.
