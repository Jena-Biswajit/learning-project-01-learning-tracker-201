package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SearchMatrixTest {

    static int[] searchMatrixTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midElement = matrix[row][col];

            if (midElement == target) {
                return new int[]{row, col}; // Return the position of the target
            } else if (midElement < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1}; // Return -1, -1 if the target is not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 3},
                {4, 5}
        };
        int target = 4;
        int[] result = SearchMatrixTest.searchMatrixTarget(matrix, target);
        if (result[0] != -1) {
            System.out.println("Found at: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("Element not found");
        }
    }

    @Test
    void testSearchMatrixTargetExists() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };
        int target = 9;
        int[] expected = {1, 1}; // Target is at row 1, column 1
        assertArrayEquals(expected, SearchMatrixTest.searchMatrixTarget(matrix, target));
    }

    @Test
    void testSearchMatrixTargetNotExists() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };
        int target = 8;
        int[] expected = {-1, -1}; // Target does not exist
        assertArrayEquals(expected, SearchMatrixTest.searchMatrixTarget(matrix, target));
    }

    @Test
    void testSearchMatrixTargetFirstElement() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };
        int target = 1;
        int[] expected = {0, 0}; // Target is at row 0, column 0
        assertArrayEquals(expected, SearchMatrixTest.searchMatrixTarget(matrix, target));
    }

    @Test
    void testSearchMatrixTargetLastElement() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };
        int target = 17;
        int[] expected = {2, 2}; // Target is at row 2, column 2
        assertArrayEquals(expected, SearchMatrixTest.searchMatrixTarget(matrix, target));
    }

    @Test
    void testSearchMatrixEmptyMatrix() {
        int[][] matrix = {};
        int target = 5;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            SearchMatrixTest.searchMatrixTarget(matrix, target);
        });
    }

    @Test
    void testSearchMatrixSingleElementFound() {
        int[][] matrix = {
                {10}
        };
        int target = 10;
        int[] expected = {0, 0}; // Single element, found
        assertArrayEquals(expected, SearchMatrixTest.searchMatrixTarget(matrix, target));
    }

    @Test
    void testSearchMatrixSingleElementNotFound() {
        int[][] matrix = {
                {10}
        };
        int target = 5;
        int[] expected = {-1, -1}; // Single element, not found
        assertArrayEquals(expected, SearchMatrixTest.searchMatrixTarget(matrix, target));
    }
}
