package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Find2ndLargestElementTest {

    static int findSecondLargestElement(int []array){

        int largest =-1;
        int secondLargest=-1;
        for(int i=0;i<array.length;i++){
            if(array[i]>largest){
                largest=array[i];
            }
        }

        // find the 2nd largest element
        for(int i=0;i<array.length;i++){
            if(array[i]>secondLargest && array[i]!=largest ){
                secondLargest=array[i];
            }
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        int []arr={1,2,3,5,4,8,0,2};
       int secondLargestElement =findSecondLargestElement(arr);
        System.out.println("second largest element :"+secondLargestElement);
    }
    @Test
    void testFindSecondLargestNormalCase() {
        int[] arr = {5, 2, 7, 8, 1, 0, 3, 6};
        int expectedSecondLargest = 7;
        assertEquals(expectedSecondLargest, findSecondLargestElement(arr));
    }
    @Test
    void testFindSecondLargestSmallArray() {
        int[] arr = {1, 2};
        int expectedSecondLargest = 1;
        assertEquals(expectedSecondLargest, findSecondLargestElement(arr));
    }
}
