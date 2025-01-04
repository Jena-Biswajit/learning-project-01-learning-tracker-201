package com.arrays;

//import static jdk.javadoc.internal.doclets.toolkit.util.DocFinder.search;

import java.util.Arrays;

public class RemoveDuplicateElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 5, 5, 5, 6};
        boolean visited = false;
        int len = arr.length - 1;
        int index=0;
        for (int i = 0; i <= len; i++) {

            boolean isDuplicate = false;
            for(int j=0;j<index;j++){
                if(arr[i]==arr[j]){
                    isDuplicate=true;
                    break;
                }
            }
            if(!isDuplicate){
                arr[index++]=arr[i];
            }

        }
        while (index<arr.length){
            arr[index++]=0;
        }

        System.out.println("array after removing duplicate elements"+ Arrays.toString(arr));
    }
}
