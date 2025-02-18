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






