package com.arrays;


public class ReverseArrayInGroups {

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 8, 1, 0, 3, 6};
        int groupSize = 3;

        for(int i =0;i< arr.length;i++){
            System.out.println("original array :"+arr[i]);
        }
        OneDArrayIteration.ReverseInGroups ob1 = new OneDArrayIteration.ReverseInGroups();
        ob1.reverseElement(arr, groupSize);
        for(int i =0;i< arr.length;i++){
            System.out.println("reversed array in groups :"+arr[i]);
        }
    }
}
