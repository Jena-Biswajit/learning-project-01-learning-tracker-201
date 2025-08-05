package com.example.blind75.array;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {

        String [] str = {"mns" , "qrt" , "trq" , "snm" , "rg"};
        List<List<String>> groupedAnagram = groupAnagram(str);
        System.out.println(groupedAnagram);
    }
    public static List<List<String>> groupAnagram(String [] str){
        Map<String , List<String>> res = new HashMap<>();
        for (String s : str){
            int[]count = new int[26];
            for (char c : s.toCharArray()){
                count[c - 'a']++ ;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key , new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }

}
