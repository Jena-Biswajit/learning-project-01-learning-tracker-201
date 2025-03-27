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





