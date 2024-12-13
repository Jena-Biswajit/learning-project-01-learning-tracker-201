package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

        private final Calculator calculator = new Calculator();

        @Test
        public void testAdd() {
            assertEquals(5, calculator.add(2, 3));
            assertEquals(0, calculator.add(-2, 2));
            assertEquals(-5, calculator.add(-2, -3));
        }

        @Test
        public void testSubtract() {
            assertEquals(1, calculator.subtract(3, 2));
            assertEquals(-4, calculator.subtract(-2, 2));
            assertEquals(1, calculator.subtract(-2, -3));
        }

        @Test
        public void testMultiply() {
            assertEquals(6, calculator.multiply(2, 3));
            assertEquals(-4, calculator.multiply(-2, 2));
            assertEquals(6, calculator.multiply(-2, -3));
        }

        @Test
        public void testDivide() {
            assertEquals(2.0, calculator.divide(6, 3));
            assertEquals(-2.5, calculator.divide(-5, 2));

            // Test division by zero
            Exception exception = assertThrows(ArithmeticException.class, () -> {
                calculator.divide(1, 0);
            });
            assertEquals("Cannot divide by zero", exception.getMessage());
        }

        @Test
        public void testFactorial() {
            assertEquals(120, calculator.factorial(5));
            assertEquals(1, calculator.factorial(0));
            assertEquals(1, calculator.factorial(1));

            // Test negative number input
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                calculator.factorial(-1);
            });
            assertEquals("Number must be non-negative", exception.getMessage());
        }
}
