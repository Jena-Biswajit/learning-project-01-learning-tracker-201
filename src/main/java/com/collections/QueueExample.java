package com.collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        // Create a Queue
        Queue<String> queue = new LinkedList<>();
        queue.add("biswajit"); // Add elements
        queue.add("chandan");
        queue.add("saroj");
        System.out.println(queue); // Output: [biswajit, chandan, saroj]

        // Peek the head element
        System.out.println(queue.peek()); // Output: biswajit

        // Remove the head element
        System.out.println(queue.poll()); // Output: biswajit
        System.out.println(queue); // Output: [chandan, saroj]

        // Check if an element exists
        System.out.println(queue.contains("saroj")); // Output: true

        // Check the size
        System.out.println(queue.size()); // Output: 2

        // Add an element to the queue
        queue.offer("raj");
        System.out.println(queue); // Output: [chandan, saroj, raj]
    }
}
