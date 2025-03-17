package com.arrays;

public class OneDArrayIteration {
    public static void main(String[] args) {
        int[] numbers = {34, 67, 23, 89, 12, 95, 42};

        // Using for loop
        int maxFor = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxFor) {
                maxFor = numbers[i];
            }
        }
        System.out.println("Greatest using for loop: " + maxFor);

        // Using for-each loop
        int maxForEach = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > maxForEach) {
                maxForEach = num;
            }
        }
        System.out.println("Greatest using for-each loop: " + maxForEach);

        // Using while loop
        int maxWhile = Integer.MIN_VALUE;
        int indexWhile = 0;
        while (indexWhile < numbers.length) {
            if (numbers[indexWhile] > maxWhile) {
                maxWhile = numbers[indexWhile];
            }
            indexWhile++;
        }
        System.out.println("Greatest using while loop: " + maxWhile);

        // Using do-while loop
        int maxDoWhile = Integer.MIN_VALUE;
        int indexDoWhile = 0;
        do {
            if (numbers[indexDoWhile] > maxDoWhile) {
                maxDoWhile = numbers[indexDoWhile];
            }
            indexDoWhile++;
        } while (indexDoWhile < numbers.length);
        System.out.println("Greatest using do-while loop: " + maxDoWhile);
    }

    public static class ReverseInGroups {
        public static int[] reverseElement(int[] array, int groupSize) {

            int len = array.length;
            for (int i = 0; i < len; i += groupSize) {
                int left = i;
                int right;

                if (i + groupSize - 1 < len) {
                    right = i + groupSize - 1;
                } else {
                    right = len - 1;
                }

                // iterate till left is greater than or equal
                while (left < right) {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                    left++;
                    right--;
                }

            }

            return array;
        }
    }
}
