package com.example;

public class Calculator
{
        // Add two numbers
        public int add(int a, int b) {
            return a + b;
        }

        // Subtract two numbers
        public int subtract(int a, int b) {
            return a - b;
        }

        // Multiply two numbers
        public int multiply(int a, int b) {
            return a * b;
        }

        // Divide two numbers with error handling
        public double divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return (double) a / b;
        }

        // Find the factorial of a number
        public long factorial(int a) {
            if (a < 0) {
                throw new IllegalArgumentException("Number must be non-negative");
            }
            long result = 1;
            for (int i = 1; i <= a; i++) {
                result *= i;
            }
            return result;
        }
}
