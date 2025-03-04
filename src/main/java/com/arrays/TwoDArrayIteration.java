package com.arrays;

public class TwoDArrayIteration {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Using for loop
        int sumFor = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumFor += matrix[i][j];
            }
        }
        System.out.println("Sum using for loop: " + sumFor);

        // Using for-each loop
        int sumForEach = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sumForEach += element;
            }
        }
        System.out.println("Sum using for-each loop: " + sumForEach);

        // Using while loop
        int sumWhile = 0;
        int rowWhile = 0;
        while (rowWhile < matrix.length) {
            int colWhile = 0;
            while (colWhile < matrix[rowWhile].length) {
                sumWhile += matrix[rowWhile][colWhile];
                colWhile++;
            }
            rowWhile++;
        }
        System.out.println("Sum using while loop: " + sumWhile);

        // Using do-while loop
        int sumDoWhile = 0;
        int rowDoWhile = 0;
        do {
            int colDoWhile = 0;
            do {
                sumDoWhile += matrix[rowDoWhile][colDoWhile];
                colDoWhile++;
            } while (colDoWhile < matrix[rowDoWhile].length);
            rowDoWhile++;
        } while (rowDoWhile < matrix.length);
        System.out.println("Sum using do-while loop: " + sumDoWhile);
    }
}
