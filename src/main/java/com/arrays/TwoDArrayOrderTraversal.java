package com.arrays;
public class TwoDArrayOrderTraversal {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Row-Major Order:");
        for (int row = 0; row < array.length; row++) { // Iterate over rows
            for (int col = 0; col < array[row].length; col++) { // Iterate over columns of the current row
                System.out.print(array[row][col] + " ");
            }
            System.out.println(); // New line after each row
        }

        System.out.println("Column-Major Order:");
        for (int col = 0; col < array[0].length; col++) { // Iterate over columns
            for (int row = 0; row < array.length; row++) { // Iterate over rows of the current column
                System.out.print(array[row][col] + " ");
            }
            System.out.println(); // New line after each column
        }
    }
}
