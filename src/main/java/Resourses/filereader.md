### Readers

- Readers are used to read character-based data from different sources like files, strings, and memory.
- Unlike InputStream, which works with bytes, Reader handles characters, making it ideal for text-based operations.

***Why Use Readers?***
- ```Handles Character Encoding:``` Unlike InputStream, which reads raw bytes, Reader automatically converts bytes into characters.
- ```Efficient for Text Data:``` Reading characters directly (instead of bytes) simplifies working with textual data.
- ```Higher-Level Abstraction:``` Provides methods like readLine(), making it easier to work with large text files.

### Types of Readers

```FileReader```
```BufferedReader```
```InputStreamReader```
```CharArrayReader```
```StringReader```

***FileReader***

- FileReader is a class in Java that reads character-based data from a file.
- It is a subclass of InputStreamReader and is useful for handling text files.
- Reads characters from a file.
- Used for text file reading.
- Reads one character at a time.
- Automatically decodes the file’s content based on the platform’s default encoding (UTF-8, etc.).
-  Works well for small-sized files, but not efficient for large files (use BufferedReader instead).

***FileReader Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Reader  
    ↳ java.io.InputStreamReader  
      ↳ java.io.FileReader  
```
- Since FileReader extends Reader, it provides all basic character reading capabilities.

***BufferedReader***

- BufferedReader is a Java class that reads text from a character-based input stream efficiently by using an internal buffer. 
- It is faster than FileReader because it reads chunks of characters at a time instead of reading one character at a time.
- Reads text efficiently by using buffering.
- Can read full lines using readLine().
- Works well for large text files.
- Wraps other readers like FileReader, InputStreamReader, etc.
- Reduces disk I/O operations.

***BufferedReader Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Reader  
    ↳ java.io.BufferedReader  
```
- Since BufferedReader extends Reader, it provides all basic character reading capabilities and adds buffering for better performance.

***InputStreamReader***

- InputStreamReader is a bridge between byte streams and character streams. 
-  It converts bytes (from an InputStream) into characters using a specified character encoding.
- Reads bytes and converts them into characters.
- Allows reading files, network data, or console input as character streams.
- Supports different character encodings (like UTF-8, ASCII).
- Commonly used with BufferedReader for efficient reading.

***InputStreamReader Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Reader  
    ↳ java.io.InputStreamReader  
```

- InputStreamReader extends Reader, making it a character-based reader.


***CharArrayReader***

- CharArrayReader is a character stream that allows reading characters from a character array (like char[]).
-  It acts as an in-memory character-based input stream, similar to how ByteArrayInputStream works for bytes.
- Reads data from a char[] array instead of a file.
- Useful for temporary data storage and processing.
- Allows marking and resetting to re-read characters.
- Supports buffered reading for better performance.

***Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Reader  
    ↳ java.io.CharArrayReader  
```

- CharArrayReader extends Reader, making it a character-based input stream.


***StringReader***

- StringReader is a character stream that reads characters from a String instead of a file or byte stream.
- It is a subclass of Reader and is useful for processing in-memory string data.
- Reads data from a String instead of a file.
- Works like CharArrayReader, but for String objects.
- Supports marking and resetting to re-read characters.
- More efficient than using a FileReader for in-memory text processing.

***Class Hierarchy***
```
java.lang.Object  
  ↳ java.io.Reader  
    ↳ java.io.StringReader  
```
- StringReader extends Reader, making it a character-based input stream.