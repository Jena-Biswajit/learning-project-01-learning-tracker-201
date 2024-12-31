package com.arrays;
import java.util.Arrays;


public class ReverseAraayInGroups {

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 8, 1, 0, 3, 6};
        int groupSize = 3;

        for(int i =0;i< arr.length;i++){
            System.out.println("original array :"+arr[i]);
        }
        ReverseInGroups ob1 = new ReverseInGroups();
        ob1.reverseElement(arr, groupSize);
        for(int i =0;i< arr.length;i++){
            System.out.println("reversed array in groups :"+arr[i]);
        }
    }
}
