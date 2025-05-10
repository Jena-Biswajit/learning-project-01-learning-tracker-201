package com.collections;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        // Create a Stack
        Stack<String> stack = new Stack<>();
        stack.push("biswajit"); // Push element
        stack.push("chandan");
        stack.push("saroj");
        System.out.println(stack); // Output: [biswajit, chandan, saroj]

        // Peek the top element
        System.out.println(stack.peek()); // Output: saroj

        // Pop an element
        System.out.println(stack.pop()); // Output: saroj
        System.out.println(stack); // Output: [biswajit, chandan]

        // Check if the stack is empty
        System.out.println(stack.isEmpty()); // Output: false

        // Search for an element (1-based index)
        System.out.println(stack.search("biswajit")); // Output: 2
    }
}

