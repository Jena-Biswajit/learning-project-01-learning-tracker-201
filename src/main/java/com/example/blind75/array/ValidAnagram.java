package com.example.blind75.array;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bac";

        // check each element of character in s1 is equals to each character in s2
        // if not return true else return false

        boolean result = findAnagram(s1 , s2);
        System.out.println(result);
    }
    public static boolean findAnagram(String s1 , String s2){

        if(s1.length() != s2.length()){
            return false ;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String newS1 = new String(arr1);
        String newS2 = new String(arr2);
        if (newS1.equals(newS2)){
            return true ;
        }else {
            return false ;
        }
    }
}
