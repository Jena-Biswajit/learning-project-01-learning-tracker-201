### File Handling Hierarchy

- This File Class is inside the java.io package.
- The File class can be used to create an object of the class and then specifying the name of the file.

***Why File Handling is Required?***

- File Handling is an integral part of any programming language as file handling enables us to store the output of any particular program in a file and allows us to perform certain operations on it.
- file handling means reading and writing data to a file.
![java_file_handling_flowchart.drawio.png](..%2F..%2F..%2F..%2F..%2F..%2FDesktop%2Fjava_file_handling_flowchart.drawio.png)


***Streams in Java***

- A sequence of data is known as a stream. 
- This concept is used to perform I/O operations on a file.

***1. Input Stream***

- The Java InputStream class is the superclass of all input streams. 
- The input stream is used to read data from numerous input devices like the keyboard, network, etc. 
- InputStream is an abstract class, and because of this, it is not useful by itself. 
- However, its subclasses are used to read data.

```
   FileInputStream
   ByteArrayInputStream
   ObjectInputStream
```

***2. Output Stream***

- This stream is used to read or write character data. Character stream is again subdivided into 2 types which are as follows:
- Character Input Stream: Used to read character data from different devices.
- Character Output Stream: Used to write character data to different devices.
- Owing to the fact that you know what a stream is, let’s polish up File Handling in Java by further understanding the various methods that are useful for performing operations on the files like creating, reading, and writing files.

### File Operations

- The several operations that can be performed on a file in Java:

```
Create a File
Read from a File
Write to a File
Delete a File
```