
## OutputStream
- Output Streams are used to write data to files, network sockets, or other destinations. - Java provides different types of output streams based on the kind of data being written (bytes, characters, objects, etc.).

- ```FileOutputStream```
- ```BufferedOutputStream```
- ```ByteArrayOutputStream```
- ```ObjectOutputStream```

### Why Do We Need Output Streams?
- Output Streams are used to write data to files, network sockets, or other destinations.
- Java provides different types of output streams based on the kind of data being written (bytes, characters, objects, etc.).

***FileOutputStream***

- It is a Java class in the java.io package used for writing binary data to files. 
- It is part of byte streams, meaning it writes raw bytes rather than characters.
– Writing Bytes to a File.
- Write simple text data in byte format.
- Append data to an existing file.
- Overwrite existing data in a file.

***How FileOutputStream Works?***

- converts data into bytes and writing it to a file.
- If the file does not exist, it creates a new file.
- If the file exists, it overwrites the file unless you specify the append mode.
- Always close streams to free system resources. Use try-with-resources to avoid manual closing. It’s important to close streams after writing to prevent resource leaks.


***BufferedOutputStream***

- It is a buffered byte stream in Java that enhances performance by reducing the number of  direct writes to the file or output stream. 
- It is part of Java’s I/O package (java.io) and provides buffering to FileOutputStream or any other byte output stream.
- ***Buffers data before writing*** – improves efficiency by minimizing direct I/O operations.
- ***Reduces disk access*** – writes data in chunks instead of byte by byte.  
- ***Wraps around a byte output stream*** – mainly used with FileOutputStream.

***Why Do We Need BufferedOutputStream?***
- Writing data directly using FileOutputStream can be inefficient because it writes each byte separately, which increases I/O operations and slows performance.

- ***Without buffering*** – every byte is written directly to the file, causing more disk access.-
- ***With buffering*** – multiple bytes are stored in memory first, then written in one go, reducing system overhead.

***How BufferedOutputStream Works?***
- It stores data in a buffer (default size: 8 KB) before writing it to the actual output stream.
- Instead of writing every byte separately, it writes the buffer in a single operation.
- This reduces the number of disk accesses, improving performance.

***ByteArrayOutputStream***

- ByteArrayOutputStream is a byte stream in Java that writes data to a byte array in memory instead of a physical file.
- Writes data to memory (RAM), not a file or console
- Allows conversion to byte array (toByteArray())
- Can be used for temporary storage and modification
- Supports resizing, as it grows dynamically

***Why Do We Need***
- ```Efficient for handling temporary byte data``` – No need to write to a file immediately.
- ```Used for conversions``` – Convert strings, images, or other data to byte arrays.
- ```Avoids frequent disk I/O``` – Everything happens in memory (RAM), making it faster.

***How ByteArrayOutputStream Works?***
- Unlike FileOutputStream, which writes to a file, ByteArrayOutputStream stores data in a byte array (in memory).
- The stored data can be retrieved as a byte array using toByteArray().
- You can write multiple data chunks and retrieve them later.  

***ObjectOutputStream***
- ObjectOutputStream is a byte stream in Java that allows you to write Java objects to an output stream (such as a file, socket, or memory).
- It is part of Java’s I/O package (java.io) and is used for object serialization, which means converting an object into a byte stream that can be saved or transmitted.
- Writes objects, not just raw bytes or text.
- Supports object serialization – Converts objects into a byte stream.
- Can write to files, sockets, or other output streams.
- Used in networking, databases, and caching.

***Why Do We Need ObjectOutputStream?***
- To save objects to a file or database for later use.
- To send objects over a network (Sockets, RMI, etc.).
- To store object states and restore them later.
- To transfer objects between different applications.

***How ObjectOutputStream Works?***
- Converts Java objects into a binary format (byte stream).
- Can be saved to a file or sent over a network.
- The stored object can be read back using ObjectInputStream.

***Example***
```java
package com.file;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
// import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
    String name ;
    int age;
    Person(String name , int age){
        this.name = name ;
        this.age = age;
    }
}


public class OutPutStreamExample {
    public static void main(String[] args) {

        // using FileOutputStream
        String data = "covert string to byte and write in file using FileOutputStream ";
        try (FileOutputStream fos = new FileOutputStream("createFile.txt")) {

            fos.write(data.getBytes()); // method to convert string to bytes and write
            System.out.println("data written successfully");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // using BufferedOutputStream 

        String bufferedData = "Buffered OutputStream example. ";

        try (FileOutputStream bfos = new FileOutputStream("createFile.txt");
            BufferedOutputStream bos = new BufferedOutputStream(bfos)){
            bos.write(bufferedData.getBytes());
            System.out.println("buffered data written successfully");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // using ByteArrayOutputStream 

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write("ByteArrayOutputStream Example".getBytes());
            String output = baos.toString();
            System.out.println("data stored in byte array"+ output);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // using ObjectOutputStream 
         
        try (FileOutputStream ofos = new FileOutputStream("createFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(ofos)) {

            Person p = new Person("biswa",25);
            oos.writeObject(p); 
            System.out.println("object serialized successfully ");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
```
