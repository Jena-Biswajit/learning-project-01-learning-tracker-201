package com.example.blind75.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s.length()) .append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0 ;
        while(i < str.length()){
            int j = i ;
            while(str.charAt(j) != '#'){
                j++ ;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1 ;
            j = i+ length ;
            res.add(str.substring(i,j));
            i = j ;
        }
        return res;
    }
}

public class EncodeAndDecodeString {

    public static void main(String[] args) {

        Solution solution = new Solution();

        List<String> input = Arrays.asList("hello", "world");
        System.out.println("Original List: " + input);

        String encoded = solution.encode(input);
        System.out.println("Encoded String: " + encoded);

        List<String> decoded = solution.decode(encoded);
        System.out.println("Decoded List: " + decoded);
    }
}
