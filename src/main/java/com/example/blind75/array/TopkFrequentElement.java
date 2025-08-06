package com.example.blind75.array;

import java.util.*;

public class TopkFrequentElement {

    public static void main(String[] args) {
        int [] arrayElement = {1,1,2,2,2,3,3,4};
        int k = 3;

        int [] res = findMostFrequentKElement(arrayElement , k);
        System.out.println(Arrays.toString(res));
    }

    public static int [] findMostFrequentKElement(int []nums , int k ){

        // create bucket
        List<Integer>[] bucket = new List[nums.length +1 ];

        // create frequency map
        Map<Integer , Integer> freqMap = new HashMap<>();

        // iterate over the array and add the frequency
        for(int n : nums){
            freqMap.put(n , freqMap.getOrDefault(n,0)+1);
        }

        // add frequency to the bucket
        for (int key : freqMap.keySet()){
            int frequency = freqMap.get(key);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0 ;

        // iterate over bucket and return result array

        for (int pos = bucket.length-1 ; pos>= 0 && counter<k ; pos--){
            if (bucket[pos] != null){
                for (Integer integer : bucket[pos]){
                    res[counter++] = integer;
                    if (counter == k){
                        return res ;
                    }
                }
            }
        }

        return res ;
    }
}
