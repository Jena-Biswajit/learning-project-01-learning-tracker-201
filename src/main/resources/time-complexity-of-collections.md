### Time Complexity of Java Collections

### **1. List Implementations**

| Collection        | Read (Access)  | Write (Insert)                    | Delete                            | Explanation                                                                                                                  |
|-------------------|----------------|-----------------------------------|-----------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| **ArrayList**     | O(1)           | O(1) (amortized), O(n) (worst)    | O(n)                              | Uses dynamic array. Direct access by index is O(1), but inserting or deleting in the middle requires shifting elements.      |
| **LinkedList**    | O(n)           | O(1) at head/tail, O(n) in middle | O(1) at head/tail, O(n) in middle | Doubly linked list, so insertions/deletions at head/tail are O(1), but accessing elements is O(n) since traversal is needed. |

---

### **2. Set Implementations**

| Collection        | Read (Contains) | Write (Insert)                 | Delete   | Explanation                                                                               |
|-------------------|-----------------|--------------------------------|----------|-------------------------------------------------------------------------------------------|
| **HashSet**       | O(1)            | O(1) (amortized), O(n) (worst) | O(1)     | Uses a hash table, so operations are O(1) on average but O(n) in case of hash collisions. |
| **LinkedHashSet** | O(1)            | O(1) (amortized), O(n) (worst) | O(1)     | Similar to HashSet but maintains insertion order using a linked list.                     |
| **TreeSet**       | O(log n)        | O(log n)                       | O(log n) | Uses a Red-Black tree, which ensures log(n) time for all operations.                      |

---

### **3. Map Implementations**

| Collection       | Read (Get) | Write (Put) | Delete (Remove) | Explanation |
|-----------------|-----------|------------|----------------|-------------|
| **HashMap**       | O(1) | O(1) (amortized), O(n) (worst) | O(1) | Uses a hash table for key-value pairs. O(1) average but O(n) if hash collisions occur. |
| **LinkedHashMap** | O(1) | O(1) (amortized), O(n) (worst) | O(1) | Similar to HashMap but maintains insertion order. |
| **TreeMap**       | O(log n) | O(log n) | O(log n) | Uses a Red-Black tree, keeping keys sorted and ensuring log(n) operations. |

---

### **4. PriorityQueue**

| Operation                | Time Complexity | Explanation                                                 |
|--------------------------|-----------------|-------------------------------------------------------------|
| **Insert (offer/add)**   | O(log n)        | Uses a binary heap, inserting in log(n) time.               |
| **Delete (poll/remove)** | O(log n)        | Removes the highest/lowest priority element in log(n) time. |
| **Read (peek)**          | O(1)            | The top element can be accessed in constant time.           |

---

### **Summary:**
- **ArrayList** is best for random access but slow for inserts/removals in the middle.
- **LinkedList** is better for frequent insertions/deletions but slow for lookups.
- **HashSet, HashMap** offer O(1) average performance but degrade to O(n) in worst cases.
- **TreeSet, TreeMap** provide sorted elements with O(log n) operations.
- **PriorityQueue** is efficient for priority-based retrieval but not for random access.  
