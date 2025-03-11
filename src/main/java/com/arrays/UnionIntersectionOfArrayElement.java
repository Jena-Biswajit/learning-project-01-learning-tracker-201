package com.arrays;

import java.util.Arrays;

public class UnionIntersectionOfArrayElement {

    // Function to find the union of two sorted arrays
    public static int[] findUnion(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int m = arr1.length, n = arr2.length;
        int[] unionArr = new int[m + n];

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                if (k == 0 || unionArr[k - 1] != arr1[i]) {
                    unionArr[k++] = arr1[i];
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (k == 0 || unionArr[k - 1] != arr2[j]) {
                    unionArr[k++] = arr2[j];
                }
                j++;
            } else { // Equal elements
                if (k == 0 || unionArr[k - 1] != arr1[i]) {
                    unionArr[k++] = arr1[i];
                }
                i++;
                j++;
            }
        }

        while (i < m) {
            if (k == 0 || unionArr[k - 1] != arr1[i]) {
                unionArr[k++] = arr1[i];
            }
            i++;
        }

        while (j < n) {
            if (k == 0 || unionArr[k - 1] != arr2[j]) {
                unionArr[k++] = arr2[j];
            }
            j++;
        }

        return Arrays.copyOf(unionArr, k);
    }

    // Function to find the intersection of two sorted arrays
    public static int[] findIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int m = arr1.length, n = arr2.length;
        int[] intersectionArr = new int[Math.min(m, n)];

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else { // Equal elements
                if (k == 0 || intersectionArr[k - 1] != arr1[i]) {
                    intersectionArr[k++] = arr1[i];
                }
                i++;
                j++;
            }
        }

        return Arrays.copyOf(intersectionArr, k);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        System.out.println("Union: " + Arrays.toString(findUnion(arr1, arr2)));
        System.out.println("Intersection: " + Arrays.toString(findIntersection(arr1, arr2)));
    }
}
