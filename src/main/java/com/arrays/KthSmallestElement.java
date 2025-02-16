package com.arrays;

import java.util.*;

class FindKthElement{
    public void findKthSmallestElement (int []array, int position ){

        // sort the array
        Arrays.sort(array);
        System.out.println("sorted arr"+Arrays.toString(array));
        System.out.println("kth lowest element is = "+array[position-1]);
    }
}
public class KthSmallestElement {
    public static void main(String[] args) {
        int [] arr = {3,2,6,8,9};
        int kth = 1;

        FindKthElement ob1 = new FindKthElement();

        ob1.findKthSmallestElement(arr,kth);
    }
}
