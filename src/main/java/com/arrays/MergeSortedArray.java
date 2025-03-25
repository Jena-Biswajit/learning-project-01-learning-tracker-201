package com.arrays;

import java.util.Arrays;

class SolutionMergeArray {
    int[] Merge(int[] nums1, int len1, int[] nums2, int len12) {

        int i = len1 - 1;
        int j = len12 - 1;
        int k = len1 + len12 - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;

            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];        
            j--;
            k--;
        }
        return nums1;
    }

}

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1 = { 4,5,6,0,0,0 };
        int m = 3;

        int[] nums2 = { 1,2,3 };
        int n = 3;

        SolutionMergeArray ob1 = new SolutionMergeArray();
        int [] result = ob1.Merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(result));
    }
}
