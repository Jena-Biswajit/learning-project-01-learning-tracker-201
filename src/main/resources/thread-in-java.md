### What is the role of cpu.

- The CPU is the brain of a computer.
- Containing all the circuitry needed to process input, store data, and output results.
- The CPU is constantly following instructions of computer programs that tell it which data to process and how to process it. 
- Without a CPU, we could not run programs on a computer.

### Inside the CPU

- At the hardware level, a CPU is an integrated circuit, also known as a chip.
- An integrated circuit "integrates" millions or billions of tiny electrical parts,arranging them into circuits and fitting them all into a compact box.
- It helps input and output devices to communicate with each other and perform their respective operations.

- ***Elements of a CPU*** : 
- Control Unit (CU).
- Arithmetic Logic Unit (ALU).
- Registers.
- Cache.
- Bus Interface Unit (BIU).
- Instruction Decoder.
- Clock.
- Pipeline.
- Floating-Point Unit (FPU).

### Functions of a CPU

***Fetching Instructions:***

- The CPU normally retrieves instructions from the computer’s memory in a specific order set by the ```programme counter```.
- It collects the instructions one at a time and gets them ready for processing.
- It involves retrieving an instruction from memory (RAM) into the CPU for execution.

***Steps in Fetching an Instruction***

- ```Program Counter (PC) Fetches Address``` : The PC (Program Counter) holds the memory address of the next instruction to be executed.

- ```Address Sent to Memory Unit``` : he address stored in the PC is sent to the Memory Unit (RAM).

- ```Instruction Loaded into Instruction Register (IR)``` : The memory unit sends the instruction to the Instruction Register (IR) inside the CPU.

- ```Increment Program Counter (PC)``` : The PC is incremented to point to the next instruction in memory.

***Components Involved in Fetching Instructions***

- Program Counter (PC) : Holds address of the next instruction.
- Memory Address Register (MAR) : Stores the memory address from which the instruction is fetched.
- Memory Data Register (MDR) : Holds the actual instruction retrieved from memory.
- Instruction Register (IR) : Stores the fetched instruction for decoding.
- Control Unit (CU) : Sends control signals to fetch the instruction.

***Example: Step-by-Step Fetching Process***

- Let's assume we have the following assembly-like instructions stored in memory:

- ```CPU initializes:``` 

- PC = 1000 (Points to first instruction)
- MAR = 1000 (Sends address to memory)

- ```Memory fetches instruction:```

- Instruction (LOAD A, 5) is retrieved from memory address 1000.
- Stored in MDR (Memory Data Register) → then moved to IR (Instruction Register).

- ```Program Counter (PC) increments:```

- PC = 1001 (Points to next instruction).

***How This Works Internally?***
- Each fetch cycle consists of:
- 1) Loading the memory address from the Program Counter (PC) into the Memory Address Register (MAR).
- 2) Reading the instruction from memory and storing it in the Memory Data Register (MDR).
- 3) Copying the instruction from MDR into the Instruction Register (IR).
- 4) Incrementing the PC to fetch the next instruction.

***Fetching in a Multi-Core CPU***

- Core 1 fetches instruction from address 1000
- Core 2 fetches instruction from address 2000
- Core 3 fetches instruction from address 3000

***Role of the Control Unit in Fetching Instructions***

- The Control Unit sends a signal to the Program Counter (PC) to fetch the instruction address.
- Sending signals to fetch the instruction from memory.
- Directing data flow between the CPU and memory.
- Coordinating the use of registers (PC, MAR, MDR, IR).
- Ensuring the program counter is updated correctly after fetching.
- Managing timing signals for smooth execution.

***Decoding Instructions:***
- The control unit of the CPU decodes the instructions after they have been fetched.
- It occurs after fetching the instruction and before executing it.

***What is Instruction Decoding?***
 - Once the Control Unit (CU) fetches an instruction, it must determine what the instruction means and what operations must be performed.
 - This process is called Instruction Decoding.

***Key Responsibilities of Decoding:***

```Extract the Opcode (Operation Code)```
 - Identify the operation (Opcode).
 - Identify operands (if any).
- Prepare CPU components (ALU, Registers, etc.) for execution.

- ***Example:***
 - If the instruction in IR = ADD A, B, the Opcode is ADD.

```Identify the Operands```
 - The CU determines the operands (data or registers involved).
 - For ADD A, B, the operands are A and B.

```Decode the Instruction Using the Instruction Decoder```
 - The CU uses an Instruction Decoder to translate the Opcode into signals.
 - It determines whether the instruction needs:
  - Arithmetic Logic Unit (ALU)
  - Registers
  - Memory access
  - I/O operations

```Control Signals Are Sent```
 - The CU generates control signals to prepare the CPU components.
 - Example: If it is an arithmetic operation, the ALU is prepared.

***Steps in the Decoding Phase***

 - The Instruction Register (IR) holds the fetched instruction.
 - The CU extracts the Opcode, which tells what operation to perform.



***Executing Instructions:***
 - After decoding, the CPU carries out the required calculations, data manipulations, or control flow activities to carry out the instructions.
 - Addition, subtraction, comparisons, and Boolean operations are only a few of the mathematical and logical operations that the arithmetic logic unit (ALU) is in charge of doing.
 - Get the instruction from memory.
 - Identify the operation and operands.
 - Perform the required computation using ALU.


***Managing Registers:***
 - Operands, addresses, and other information needed for calculations are temporarily stored in these registers.
 - Data transfer between registers and memory is controlled by the CPU.


***Controlling Program Flow:*** 
 - The programme counter and any conditionals or branching instructions determine the next instruction to be executed. 
 - Because of this, the CPU may choose among various execution paths and make decisions.


***Handling Interrupts:*** 
 - Both internal and external events might cause interruptions, such as keyboards and timers.
 - In order to respond to the interrupt, the CPU pauses the currently running process, saves its state, and then jumps to an interrupt handler code. 



***Managing Caches:*** 
 - Caches reduce memory access latency to boost performance by storing frequently used instructions and data.
 - When the cache is full, the CPU decides which data to evict while still managing cache activities, which include fetching data from memory into the cache.



***Coordinating with Other System Components:***
 - It manages the transmission of information and commands between various parts, guaranteeing proper synchronisation and communication.



***Arithmetic and Logic Operations:*** 
 - The CPU performs basic arithmetic operations like addition, subtraction, multiplication, and division.


***Control Unit:***
 - The CPU includes a control unit that coordinates and manages the execution of instructions.
 - It controls the flow of data between the CPU, memory, and other peripherals.



***Virtual Memory Management:***
 - The CPU works in conjunction with the operating system to manage virtual memory, which allows processes to use more memory than physically available.
 - It handles memory addressing, page table lookups, and swapping data between RAM and disk storage.



***I/O Operations:*** 
 - The CPU communicates with input and output devices, such as keyboards, mice, displays, and storage devices.
 - It coordinates data transfers between these devices and the computer’s memory.


### What is a Core in a Processor?

 - A core in a processor is an independent processing unit within the CPU that can execute instructions.
 -  Modern processors have multiple cores, which allow them to perform multiple tasks simultaneously, improving performance and efficiency.

- ***TODO***

### What is a Process?

- A process is an instance of a program that is being executed by the CPU. It contains:
  - ***Program Code (Text Section)*** – Instructions of the program.
  - ***Data Section*** - Global variables.
  - ***Heap*** - Dynamically allocated memory.
  - ***Stack*** - Function calls and local variables.
  - ***Process Control Block (PCB)*** -  Information like process ID, registers, and scheduling details.
  
  ***What is Multiprocessing?***

  - Multiprocessing is the ability of a system to run multiple processes simultaneously using multiple CPUs (cores). 
  -  It improves efficiency by utilizing all available processing units.

  ***Types of Multiprocessing***
  
  1) Symmetric Multiprocessing (SMP)
     - All CPUs share memory and the OS treats them equally.
     - Example: Modern multi-core processors (Intel i7, Ryzen 9).

  2) Asymmetric Multiprocessing (AMP)
     - One CPU is the master, others execute assigned tasks.
     - Example: Embedded systems (e.g., microcontrollers).

 ***Pros**

 - ***Faster Execution*** Multiple processes run in parallel, reducing execution time.
 - ***Better Resource Utilization*** CPU cores are used efficiently.
 - ***Fault Tolerance*** If one CPU fails, others can continue execution.
 - ***Supports Multitasking*** Multiple tasks can be performed simultaneously.

 ***Cons***

 - ***Increased Complexity*** Managing multiple processes and synchronization is difficult.
 - ***Higher Power Consumption*** More CPUs consume more power.
 - ***More Expensive*** Requires additional hardware (multi-core CPUs).
 - ***Synchronization Issues*** Processes may need to share resources (e.g., memory), leading to race conditions.

 - ***TODO***


### Address Space and Memory Space of a Process

 - When a program is executed, it is loaded into memory (RAM) as a process.
 - The operating system assigns it a unique address space and manages its memory space.

1. Address Space of a Process

 - The address space is the range of memory addresses assigned to a process by the OS.
 -  It defines where the process can read, write, and execute data.

***Types of Address Spaces***

  1. Logical (Virtual) Address Space
     - Created by the OS and CPU for each process.
     - Does not refer to actual physical memory.
     - Uses paging or segmentation to map to physical memory.
     - enerated by the CPU and used by the program.
  2. Physical Address Space
     - The actual memory location in RAM where the process is stored.
     - Managed by the OS via MMU (Memory Management Unit).
     - The MMU translates logical addresses → physical addresses.


2. Memory Space of a Process
- The memory space of a process is divided into different sections:

***Memory Layout of a Process in RAM***

- Text Segment : Stores compiled program instructions (code).
- Data Segment : Stores global and static variables.
- Heap         : Stores dynamically allocated memory (malloc, new). Grows upwards.
- Stack        : Stores function calls, local variables, and return addresses. Grows downwards.


***Process Memory Space***

+------------------------+  High Memory (Largest Address)
|      Stack             |  ↓ Grows Down (Function Calls, Local Variables)
+------------------------+
|      Heap              |  ↑ Grows Up (Dynamic Memory Allocation)
+------------------------+
|      Data Segment      |  (Global & Static Variables)
+------------------------+
|      Text Segment      |  (Program Instructions - Code)


### Process Communication 

- When multiple processes run in an operating system,they often need to exchange data or coordinate execution.
- This is done through Inter-Process Communication (IPC).

***Why is IPC Needed?***
 1. ***Sharing Data*** - Two or more processes need to share information (e.g., browser and download manager).
 2. ***Synchronization*** -  Ensuring one process waits for another (e.g., producer-consumer problem).
 3. ***Event Notification*** - Notifying processes about system events (e.g., signals in Linux).
 4. ***Resource Sharing*** - Avoiding race conditions when multiple processes use shared resources.
 5. ***Process Coordination*** - Ensuring proper execution order between dependent processes.

 - ***TODO*** 

### Process Switching

- Process switching, also known as ```context switching```, occurs when the operating system (OS) switches from executing one process to another. 
- This happens when:
  - A process finishes execution.
  - A process gets blocked (waiting for I/O, resources, etc.).
  - The OS preempts a process due to time-sharing (CPU scheduling).

- During a process switch, the CPU saves the current process state and loads the state of the next process.

***Steps in Process Switching***
  1. Save the current process state (registers, program counter, stack pointer).
  2. Move the current process to a ready/waiting queue.
  3. Select the next process from the ready queue (CPU scheduling).
  4. Load the next process's state into the CPU.
  5. Resume execution from where the next process left off.

***Why is Process Switching Costly?***
- Process switching has a performance overhead because:
  1. Saving and restoring registers takes CPU cycles.
  2. Flushing and reloading memory caches slow down execution.
  3. Switching between different address spaces requires updating page tables and TLB (Translation Lookaside Buffer).
  4. Kernel mode to user mode transition adds latency.

***Example:*** 
- If a CPU switches processes frequently (high context switch rate), system performance drops due to excessive time spent saving/loading states.

- ***TODO*** 

### Why Use Threads in a Process?

***What is a Thread?***
 - A thread is the smallest unit of execution within a process. 
 - A process can have multiple threads, and these threads share the same memory space but execute independently.

***Why Use Threads Instead of Multiple Processes?***

 ***Threads**
    - ```Memory Usage``` :  Share the same memory space .
    - ```Context Switching``` : Faster (since memory is shared).
    - ```Intercommunication``` : Easier (threads can directly share variables).
    - ```Creation Overhead``` : Lightweight.
    - ```Use Case``` : Best for tasks that need shared data (e.g., web servers, gaming, simulations).
  
  ***Processes**
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
