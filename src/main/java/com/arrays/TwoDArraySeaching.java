package com.arrays;

class SearchMatrix {
    void searchMatrixTarget() {

        int[][] matrix = {
                {2, 3},
                {4, 5}
        };

        int n = matrix.length;
        int left = 0, right = n * n - 1;
        int target = 4;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int midElement = matrix[row][col];

            if (midElement == target) {
                System.out.println("Found at: (" + row + ", " + col + ")");
                break;
            }
            else if (midElement < target) {
                left = mid + 1;
            }
            else if ((midElement > target)){
                right = mid - 1;
            }
            else {
                System.out.println("Element not found");
            }
        }
    }
}


public class TwoDArraySeaching {
    public static void main(String[] args) {
        SearchMatrix ob1 = new SearchMatrix();
        ob1.searchMatrixTarget();
    }
}
