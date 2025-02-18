### CPU Scheduling

- CPU scheduling is the process of selecting which process or thread will execute next on the CPU.
- It is essential for efficient multitasking and resource utilization in operating systems.

***Key Concepts in CPU Scheduling***

```Process States```
  - ***New:*** Process is being created.
  - ***Ready:*** Process is waiting in the queue for execution.
  - ***Running:*** Process is currently executing on the CPU.
  - ***Waiting*** Process is waiting for I/O operation.
  - ***Terminated:*** Process has finished execution.

```Scheduling Criteria```
  - ***CPU Utilization:*** Keep the CPU as busy as possible.
  - ***Throughput :***  Number of processes completed per unit time.
  - ***Turnaround Time :*** Total time taken by a process to complete.
  - ***Waiting Time :*** Time a process spends waiting in the ready queue.
  - ***Response Time :*** Time taken to start executing after submission.

```Types of CPU Scheduling```
  - ***Preemptive:*** CPU can be taken from a process and assigned to another (e.g., Round Robin).
  - ***Non-Preemptive:*** Once a process starts execution, it runs until completion (e.g., FCFS).