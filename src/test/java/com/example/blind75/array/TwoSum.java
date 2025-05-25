package com.example.blind75.array;

import org.testng.annotations.Test;

import java.util.AbstractQueue;

import static org.junit.jupiter.api.Assertions.*;
public class TwoSum {

    @Test
    public int[] twoSum(int[]arr , int target){

        int len = arr.length;

        for (int i =0 ; i< len ; i++){
            for (int j = i+1 ; j < len ; j++ ){
                if (arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {} ;
    }

//    @Test
//    public void testAdd() {
//
//        assertEquals(0, calculator.add(-2, 2));
//        assertEquals(-5, calculator.add(-2, -3));
//    }

    @Test
    public void twoSumTest1 (){

        int [] array = {1,2,3,5,6};
        int target = 5 ;
        TwoSum ts = new TwoSum();
        int []resultArray = ts.twoSum(array,5);
//        assertEquals(5, twoSum.add(2));
        System.out.println(resultArray);
    }


}
