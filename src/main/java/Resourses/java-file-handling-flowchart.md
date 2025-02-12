### File Handling Hierarchy

- This File Class is inside the java.io package.
- The File class can be used to create an object of the class and then specifying the name of the file.

***Why File Handling is Required?***

- File Handling is an integral part of any programming language as file handling enables us to store the output of any particular program in a file and allows us to perform certain operations on it.
- file handling means reading and writing data to a file.



- ***Streams in Java***

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

###  What Is File Handling in Java?
- File handling in Java refers to reading and writing data to/from files using classes from java.io and java.nio.
- Java provides various classes for file operations:

```File``` – To create, delete, and check file properties.

```FileReader, FileWriter``` – To read/write text files.

```FileInputStream, FileOutputStream``` – To handle binary files.

```BufferedReader, BufferedWriter``` – To efficiently handle large text files.

### Why Do We Need File Handling?
File handling is required for:
- ```Persistent Storage:``` Unlike variables (which are temporary), files store data permanently.
- ```Large Data Handling:``` Files can store large amounts of data beyond memory limits.
- ```Data Sharing:``` Data can be read/written from files for communication between programs.
- ```Log and Configuration Files:``` Storing logs, user preferences, or configuration settings.


### What Is a Stream and Its Types?

- A stream in Java is a sequence of data (bytes or characters) used for input or output.

- ```InputStream:``` Reads data from a source (keyboard, file, network).

- ```OutputStream:``` Writes data to a destination (file, console, network).

- There are two types of streams in Java:

***Byte Streams:** Used for binary data (e.g., images, audio).
- ```InputStream``` (for reading bytes)
- ```OutputStream``` (for writing bytes)

***Character Streams:*** Used for text data.
- ```Reader``` (for reading characters)
- ```Writer``` (for writing characters)

### Which Streams Handle Bytes and Which Handle Characters?

***Byte Streams – Handles Binary Data***
- These classes work with raw bytes and are useful for binary files (images, audio, video).

- ***Byte Input Streams (InputStream)***

- ```FileInputStream```
- ```BufferedInputStream```
- ```DataInputStream```
- ```ObjectInputStream```

- ***Byte Output Streams (OutputStream)***
- ```FileOutputStream```
- ```BufferedOutputStream```
- ```DataOutputStream```
- ```ObjectOutputStream```

***Character Streams – Handles Text Data***

- These classes work with character data (Unicode), making them suitable for text files.

- ***Character Input Streams (Reader)***
- ```FileReader```
- ```BufferedReader```
- ```InputStreamReader```

- ***Character Output Streams (Writer)***
- ```FileWriter```
- ```BufferedWriter```
- ```OutputStreamWriter```