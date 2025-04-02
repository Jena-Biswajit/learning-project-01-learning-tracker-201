### Jackson library
- Jackson is a popular Java library used for converting Java objects to JSON and vice versa.
- It provides a fast and flexible way to handle JSON data in Java applications.

### Key Features of Jackson
  1. **Serialization** – Converts Java objects to JSON.
  2. **Deserialization** – Converts JSON to Java objects.
  3. **Annotations Support** – Allows customization using @JsonProperty, @JsonIgnore, etc.
  4. **Streaming API** – Reads and writes JSON efficiently.
  5. **Tree Model API** – Allows working with JSON like a tree structure.

### Jackson Core Modules
- **jackson-core** – Provides low-level streaming API.
- **jackson-annotations** – Enables annotations for customization.
- **jackson-databind** – Provides ObjectMapper for reading and writing JSON.

### What is FasterXML?
- **FasterXML** is the organization that develops and maintains the Jackson library, which is widely used in Java for handling JSON data.
- The name "FasterXML" comes from their goal of providing fast and efficient XML and JSON processing tools.

### Why is FasterXML Important?
- It develops Jackson, which is one of the most popular JSON processing libraries for Java.
- It provides high-performance serialization and deserialization of JSON data.
- It supports various formats like YAML, XML, CBOR, and Avro in addition to JSON.

### FasterXML Projects

- **Jackson Databind** – Converts Java objects to/from JSON.
- **Jackson Core** – Provides the core functionality for parsing JSON.
- **Jackson Annotations** – Supports annotations like @JsonIgnore, @JsonProperty.
- **Jackson DataFormats** – Supports formats like XML, YAML, and CBOR.

### What is ObjectMapper in Jackson?
- **ObjectMapper** is a class from the Jackson library (from com.fasterxml.jackson.databind) that allows us to convert Java objects to JSON and vice versa.
- It's commonly used in REST APIs, file handling, and data serialization.

### Common Use Cases
- Convert a Java object to JSON (Serialization).
- Convert JSON back to a Java object (Deserialization)
- Read and write JSON files

### writeValue
- The **writeValue()** method in Jackson's ObjectMapper is used to convert a Java object to JSON and write it to a file, output stream, or string.

### writeValue() Method Variants
  - **writeValue(File file, Object value):** Writes JSON to a file.
  - **writeValue(OutputStream out, Object value)** Writes JSON to an output stream (e.g., HTTP response).
  - **writeValueAsString(Object value** :Converts object to JSON string.
  - writeValueAsBytes(Object value)


## Understanding `logback.xml` - Statement by Statement

**Example**
```shell
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

<!-- know each statement -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%level] %msg%n</pattern>
        </encoder>
    </appender>

    <logger name="com.example.servletdemo" level="debug"/>
    <root level="info">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>

```
- The **`logback.xml`** file is used to configure **Logback**, which is a popular logging framework in Java.
- It is an alternative to **log4j** and is often used with **SLF4J (Simple Logging Facade for Java)**.

---

### **Why Do We Need `logback.xml`?**
1. **Manages logging levels** (DEBUG, INFO, ERROR, etc.).
2. **Formats log messages** for readability.
3. **Specifies where logs should be written** (console, file, database, etc.).
4. **Filters logs** based on different log levels.

---

### **Where Do We Use `logback.xml`?**
- It is placed in the `resources` folder of a **Spring Boot** or **Jakarta EE** project.
- Logback automatically loads `logback.xml` from `src/main/resources`.

---

### **Code Breakdown**

```xml
<?xml version="1.0" encoding="UTF-8"?>
```
- Declares the XML version and character encoding.
- **Ensures correct parsing** of the file.

---

```xml
<configuration>
```
- **Defines the root tag** for Logback configuration.

---

### **Defining a Console Appender**
```xml
<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
```
- **Creates an appender named `STDOUT`**.
- **Uses `ConsoleAppender`**, meaning logs will be printed to the **console**.

---

### **Setting Log Format**
```xml
<encoder>
    <pattern>%d{yyyy-MM-dd HH:mm:ss} [%level] %msg%n</pattern>
</encoder>
```
- **Encodes log messages** before printing.
- **Pattern explanation**:
    - `%d{yyyy-MM-dd HH:mm:ss}` → **Timestamp** (Date and Time).
    - `[%level]` → **Log level** (DEBUG, INFO, ERROR).
    - `%msg` → **Actual log message**.
    - `%n` → **Newline character** (moves to the next line).

---

### **Configuring a Specific Logger**
```xml
<logger name="com.example.servletdemo" level="debug"/>
```
- **Defines a logger** for the package `com.example.servletdemo`.
- **Sets the log level to `DEBUG`**, meaning it will log:
    - DEBUG
    - INFO
    - WARN
    - ERROR

---

### **Configuring the Root Logger**
```xml
<root level="info">
    <appender-ref ref="STDOUT"/>
</root>
```
- **Defines the root logger** (applies globally).
- **Sets the default log level to `INFO`**, meaning only:
    - `INFO`
    - `WARN`
    - `ERROR`
    - will be logged (DEBUG logs won't be shown unless explicitly configured).
- **Attaches the `STDOUT` appender**, meaning logs will be printed to the console.

---

### **How This Works in a Servlet or Spring Boot Application**
1. **Logback initializes** when the application starts.
2. If a log statement like:
   ```shell
   Logger logger = LoggerFactory.getLogger(ServletDemoJson.class);
   logger.debug("Debug message");
   ```
    - Appears in `com.example.servletdemo`, it will be printed **because** of:
      ```xml
      <logger name="com.example.servletdemo" level="debug"/>
      ```
    - But, in **other packages**, only **INFO+ logs** will be printed.

---


