### Why Use Threads in a Process?

***What is a Thread?***
 - A thread is the smallest unit of execution within a process. 
 - A process can have multiple threads, and these threads share the same memory space but execute independently.

***Why Use Threads Instead of Multiple Processes?***

 ***Threads***

    - ```Memory Usage``` :  Share the same memory space .

    - ```Context Switching``` : Faster (since memory is shared).

    - ```Intercommunication``` : Easier (threads can directly share variables).

    - ```Creation Overhead``` : Lightweight.
    
    - ```Use Case``` : Best for tasks that need shared data (e.g., web servers, gaming, simulations).
  
  ***Processes***

    - ```Memory Usage``` : Each process has a separate memory space.

    - ```Context Switching``` : Slower (since memory must be reloaded).

    - ```Intercommunication``` : Harder (requires IPC like pipes, message queues).  

    - ```Creation Overhead``` : Heavy.          

    - ```Use Case``` : Best for independent tasks (e.g., running different applications).                   

***Benefits of Using Threads***  
  1. ***Faster Execution (Concurrency & Parallelism)*** 
     - Threads can run concurrently (even on a single-core CPU).
     - On multi-core CPUs, threads can run truly in parallel, boosting performance. 

  2. ***Efficient Resource Utilization***
     - Threads share memory instead of duplicating it like separate processes.
     - Saves memory and reduces the overhead of process creation.

  3. ***Easy Inter-Thread Communication***
     - Threads share global variables and heap memory, making communication simple.
     - Processes require Inter-Process Communication (IPC), which is complex.

  4. ***Lower Context SwitchingCost***
  - Switching between threads is faster than switching between processes because:
     - No need to reload page tables.
     - No TLB flush required.
     - Caches remain warm (no cache invalidation).

  5. ***Multithreading is Ideal for I/O-Bound Tasks***
  - ***Example:*** A web server handling multiple users.
      - While one thread waits for I/O (network, disk), another thread can run.

***When to Use Threads?***
  - Web servers (handling multiple user requests simultaneously).
  - Gaming applications (handling AI, physics, rendering separately).
  - Data processing (parallel computations).
  - Background tasks (e.g., autosaving in applications).

*** Avoid threads when:***
  - Tasks need strict isolation (use separate processes instead).
  - The OS handles it better (e.g., database queries, system calls).

- ***TODO*** 

### Steps to create a thread

- ***TODO*** 


### Steps to stop a thread

- ***TODO*** 

### Thread states 

- ***TODO*** 

### Thread Priority

- ***TODO*** 

### Daemon Thread 

- ***TODO*** 

