### Input Stream

- The Java InputStream class is the superclass of all input streams.
- The input stream is used to read data from numerous input devices like the keyboard, network, etc.
- InputStream is an abstract class, and because of this, it is not useful by itself.
- However, its subclasses are used to read data.

- Java provides different types of Inputstreams based on the kind of data being written (bytes, characters, objects, etc.).

- ```FileInputStream```
- ```BufferedInputStream```
- ```ByteArrayInputStream```
- ```ObjectInputStream```

***Syntax***
```
// Creating an InputStream
InputStream obj = new FileInputStream();
```

***Common Methods of InputStream:***

- read() : Reads one byte of data from the input stream.
- read(byte[] array)() : Reads byte from the stream and stores that byte in the specified array.
- mark() : It marks the position in the input stream until the data has been read.
- available() : Returns the number of bytes available in the input stream.
- reset() : Returns the control to the point where the mark was set inside the stream.
- skips() :  Skips and removes a particular number of bytes from the input stream.
- close() : Closes the input stream.

### Why Do We Need Input Streams?

- Input streams are used to read data from various sources such as files, network connections, user input, or memory buffers.
- They provide a standardized way to handle incoming data efficiently, regardless of the source.

***FileInputStream***

- FileInputStream is a Java class in the java.io package that reads raw byte data from a file.
- It is primarily used for reading binary files such as images, audio, and serialized objects.
- Reads binary data directly from a file.
- Useful for handling non-text files like images, PDFs, and videos.
- Can be wrapped in a BufferedInputStream for performance optimization.
- Do NOT use FileInputStream when:You need to read text files (Use FileReader instead).
- You need structured parsing (Use libraries like Scanner or BufferedReader).

***BufferedInputStream***

- BufferedInputStream is a Java class in the java.io package that improves the performance of reading data from an input stream by buffering the data.
-  Instead of reading one byte at a time, it reads a large chunk of data into an internal buffer and then serves data from that buffer, reducing the number of direct I/O operations.
- ```Faster reading``` – Reads data in chunks rather than byte by byte.
- Customizable Buffer Size – Default is 8 KB (8192 bytes), but it can be set manually.


***ByteArrayInputStream***

- ByteArrayInputStream is a class in java.io that allows an array of bytes (byte[]) to be used as an input stream.
- Unlike FileInputStream, which reads data from files, ByteArrayInputStream reads from a byte array in memory.
- ```Memory-Based Input Stream``` – No need for files, reads directly from a byte array.
- You need to process data from memory instead of files.
- You need to parse byte data in memory efficiently.
- You need mark/reset functionality to re-read the data.
- You need to read from actual files (Use FileInputStream instead).
- The data is too large to fit in memory (Use buffered streams or file streams instead).

***ObjectInputStream***

- ObjectInputStream is a class in java.io that enables reading Java objects from a stream.
- It is used for deserialization, meaning it reconstructs objects that were previously serialized using ObjectOutputStream.
- Reads entire objects, not just raw bytes.
- Supports complex objects with multiple fields.
- Can read multiple objects from a single stream.

***Example***

```
package com.file;

import java.io.*;


class Person1 implements Serializable {
    private static final long serialVersionUID = 1L;  // Recommended for serialization
    String name;
    int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class InputStreamExample {

    public static void main(String[] args) {
        
        // FileInputStreamExample 

       try{
            FileInputStream fis = new FileInputStream("createFile.txt");

            // BufferedInputStreamExample
            BufferedInputStream bis = new BufferedInputStream(fis);
            int i;
            while  ((i = bis.read()) != -1)  {
                System.out.println((char) i);
            }

            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // ByteArrayInputStreamExample

        byte[] data = {65, 66, 67, 68, 69}; // A, B, C, D, E in ASCII
        ByteArrayInputStream bais = new ByteArrayInputStream(data);

        int i;
        while ((i = bais.read()) != -1) {
            System.out.print((char) i + " ");  // Convert byte to char
        }

        // ObjectInputStreamExample

        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            Person1 person = (Person1) objIn.readObject();  // Reading object
            person.display();  // Display person data

            objIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

