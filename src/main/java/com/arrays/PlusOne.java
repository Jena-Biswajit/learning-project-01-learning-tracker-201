package com.arrays;

import java.util.Arrays;

class SolutionPlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {

            // check if array element is less than 9
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0; // put 0 to last element and take the carry for addition
            }
        }
        // check array contain only 9
        int[] newDigit = new int[len + 1];
        newDigit[0] = 1;
        return newDigit;
    }
}

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = { 1, 3,2 };
        SolutionPlusOne ob1 = new SolutionPlusOne();
        int[] result = ob1.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
