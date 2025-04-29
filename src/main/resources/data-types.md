## Java Data types

**primitive Data types**

| Data Type   | Size (in bytes) | Description                                        |
|-------------|-----------------|--------------------------------------              |
| `byte`      | 1               | Stores whole numbers from -128 to 127.             |
| `short`     | 2               | Stores whole numbers from -32,768 to 32,767.       |
| `int`       | 4               | Stores whole numbers from -2^31 to 2^31-1.         |
| `long`      | 8               | Stores whole numbers from -2^63 to 2^63-1.         |
| `float`     | 4               | Stores fractional numbers, up to 7 decimal places. |
| `double`    | 8               | Stores fractional numbers, up to 15 decimal places.|
| `char`      | 2               | Stores a single 16-bit Unicode character.          |
| `boolean`   | 1 (or 1 bit)    | Stores `true` or `false`.                          |

**Non-primitive Data types**

**Strings**
- Sequence of characters.
- Example: String s = "Hello, Java!";

**Arrays**
- Collection of elements of the same data type.
- Example: int[] numbers = {1, 2, 3, 4, 5};

**Classes**
- User-defined data types that can contain fields and methods.
**Example:**
```
class Car {
    String model;
    int speed;
}
```
**Interfaces and Enums**
- Interfaces define a contract for classes.
- Enums represent a fixed set of constants.
**Example:**
```
enum Day { MONDAY, TUESDAY, WEDNESDAY }
```
- Primitive Data Types Stored in	Stack
- Non-Primitive Types Stored in	Heap
