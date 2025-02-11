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

### Why Do We Need Output Streams?
- Output Streams are used to write data to files, network sockets, or other destinations.
- Java provides different types of output streams based on the kind of data being written (bytes, characters, objects, etc.).

***FileOutputStream***

– Writing Bytes to a File

***Example***
```java

```
