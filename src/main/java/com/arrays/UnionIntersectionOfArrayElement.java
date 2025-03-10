package com.arrays;

public class UnionIntersectionOfArrayElement {

    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5};
        int[] arrayTwo = {4, 5, 6, 7, 8};
        int intersection = 0;
        int count = 0 ;
        boolean duplicate = false;

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (arrayOne[i] == arrayTwo[j]) {
                    duplicate = true;
                    count++;
                    intersection = arrayOne[i];
                }
            }
            if (count == 2) {
                count=0;
                System.out.println("intersection of two array is :" + intersection);
            }
        }


    }
}
