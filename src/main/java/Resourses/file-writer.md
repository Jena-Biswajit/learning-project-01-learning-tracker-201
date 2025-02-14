### Writers

- the Writer class and its subclasses are used for writing character-based data to different output destinations, such as files, strings, and character arrays. 
- It is part of the java.io package and is the counterpart of the Reader class.
- Java provides byte-based streams (OutputStream) for writing binary data.
- However, for handling text (characters and strings) efficiently, Java provides character-based streams (Writer).
- Writers are more suitable for internationalization (handling different character sets like UTF-8, UTF-16).

***Writer Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Writer  
    ↳ java.io.OutputStreamWriter  
      ↳ java.io.FileWriter  
      ↳ java.io.BufferedWriter  
      ↳ java.io.PrintWriter  
    ↳ java.io.StringWriter  
    ↳ java.io.CharArrayWriter  
```

- Writer is the abstract base class for all character-based output streams.
- Subclasses extend Writer to write characters to different destinations.

### FileWriterExample

- FileWriter is a Java class from the java.io package that allows writing character-based data to a file.
- It is a subclass of OutputStreamWriter and is used when you need to store text in files.
- Supports overwriting or appending text to a file.
- Can be used with BufferedWriter for better performance.
- Requires proper closing to prevent memory leaks.

***FileWriter Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Writer  
    ↳ java.io.OutputStreamWriter  
      ↳ java.io.FileWriter  
```

- FileWriter extends OutputStreamWriter, which converts characters into bytes using a specified encoding (default: UTF-8).


### BufferedWriterExample

- BufferedWriter is a Java class from the java.io package that provides efficient character-based writing by buffering data before writing it to a file or stream.
- Improves performance by reducing the number of write operations.
- Writes character-based data (text files).
- Buffers data in memory before writing to the file.
- Supports newLine() for writing platform-independent new lines.
- Works with FileWriter and OutputStreamWriter for efficient file writing.

***BufferedWriter Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Writer  
    ↳ java.io.BufferedWriter
```

- BufferedWriter extends Writer, meaning it provides methods for writing text data efficiently.

### PrintWriterExample

- PrintWriter is a Java class used for writing formatted text data to files, console, or output streams.
- It is a wrapper over Writer that provides additional features such as:
- Auto-flushing capability.
- Formatted writing (print(), println(), printf()).
- Buffered output for efficiency.
- Error checking (checkError()).

***PrintWriter Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Writer  
    ↳ java.io.PrintWriter
```

- PrintWriter extends Writer and provides advanced text writing features.

### OutputStreamWriterExample

- OutputStreamWriter is a bridge between byte streams (OutputStream) and character streams (Writer). 
- It converts characters into bytes using a specified character encoding (UTF-8, ASCII, etc.).
- Writes character data to byte-based streams.
- Supports encoding conversion (e.g., UTF-8, ISO-8859-1).
- Can wrap around FileOutputStream, ByteArrayOutputStream, etc.

***OutputStreamWriter Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Writer  
    ↳ java.io.OutputStreamWriter  
```

- OutputStreamWriter extends Writer, making it a character-based writer.

### StringWriterExample

- StringWriter is a character-based writer that writes data directly into a string buffer (in memory) instead of a file or output stream. 
- It extends Writer and is useful when you need to collect output as a string.
- Writes character data to memory (not files or streams).
- Efficient for processing text data dynamically.
- Does not require external resources like files or network connections.

***StringWriter Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Writer  
    ↳ java.io.StringWriter  
```

- StringWriter extends Writer, making it a character-based writer.

### CharArrayWriterExample

- CharArrayWriter is a character-based writer that writes data directly into a character array (in memory) instead of a file or output stream.
- It extends Writer and works like a StringWriter, but it uses a resizable character array instead of a StringBuffer.
- Writes character data into a dynamic char[] buffer (not a file or stream).
- Efficient for temporary text storage and manipulation.
- Automatically resizes when more data is added.

***CharArrayWriter Class Hierarchy***

```
java.lang.Object  
  ↳ java.io.Writer  
    ↳ java.io.CharArrayWriter  
```

- CharArrayWriter extends Writer, making it a character-based writer.

***Example***

```

```