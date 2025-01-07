### Understanding Hashing and Collision

### **What is Hashing?**
Hashing is a technique used to map data of arbitrary size to fixed-size values, called hash values or hash codes, using a hash function. It is widely used in various data structures (like hash tables) and algorithms to ensure fast data retrieval.

### Key Features:
- Converts input (keys) into a fixed-size hash value.
- Designed to minimize collisions (two different inputs mapping to the same hash value).
- Efficient for searching, inserting, and deleting operations.

### Example:
Suppose we have a list of student names and we need to store their roll numbers:

| Student Name | Roll Number |
|--------------|-------------|
| Alice        | 101         |
| Bob          | 102         |
| Carol        | 103         |

A hash function can map these names to a memory location, ensuring efficient retrieval.

---

### **What is a Collision?**
A collision occurs when two different keys produce the same hash value using a hash function. This is inevitable because the range of hash values is limited, while the possible inputs are infinite.

### Example:
Using a simple hash function `h(x) = x % 10`:
- `h(15) = 15 % 10 = 5`
- `h(25) = 25 % 10 = 5`

Here, both 15 and 25 map to the same hash value (5), resulting in a collision.

---

### **Handling Collisions**
Various strategies are used to handle collisions in hash tables:

### 1. **Chaining**
- Uses a linked list to store multiple keys that map to the same hash value.
- Each bucket of the hash table contains a linked list of keys.

#### Example:
```java
// Example of chaining
HashMap<Integer, List<String>> hashTable = new HashMap<>();
hashTable.put(5, List.of("Alice", "Bob")); // Both hash to 5
System.out.println(hashTable.get(5)); // Output: [Alice, Bob]
```

### 2. **Open Addressing**
- Stores all keys in the hash table itself.
- When a collision occurs, it searches for the next available slot using a probing technique.

#### Probing Techniques:
- **Linear Probing:** Search for the next available slot linearly.
- **Quadratic Probing:** Use a quadratic formula to find the next slot.
- **Double Hashing:** Use a second hash function to calculate the next slot.

#### Example:
```
int[] hashTable = new int[10];
int hash = 5;
if (hashTable[hash] != 0) {
    hash = (hash + 1) % 10; // Linear probing
}
hashTable[hash] = 25;
```

### 3. **Separate Hashing**
- Uses a secondary hash function to resolve collisions.

---

### **Properties of a Good Hash Function**
1. **Deterministic:** Same input always produces the same output.
2. **Uniform Distribution:** Hash values are distributed evenly to reduce collisions.
3. **Efficient Computation:** Should be quick to compute the hash value.
4. **Minimizes Collisions:** Reduces the probability of two different keys producing the same hash value.

### Example of a Hash Function:
```
public int hashFunction(String key, int tableSize) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash = (hash * 31 + c) % tableSize;
    }
    return hash;
}
```

---

### **Applications of Hashing**
1. **Hash Tables:** Efficient for searching, insertion, and deletion.
2. **Data Deduplication:** Quickly find duplicate data using hash values.
3. **Cryptography:** Hashing algorithms like SHA and MD5 are used for data integrity.
4. **Caching:** Fast access to cached resources.
5. **Load Balancing:** Distributing tasks based on hash values.

---

### Summary
Hashing is a powerful tool for efficient data management. Collisions are an inherent challenge, but techniques like chaining and open addressing help resolve them effectively. A well-designed hash function minimizes collisions and ensures optimal performance.
