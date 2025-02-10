package com.collectionTest;

//The keys represent product names.
//The values represent quantities. If a product exists in both maps, their quantities should be summed.
//Hint: Use merge() from the Map interface.

import java.util.HashMap;

public class MergeTwoMap {
    public static void main(String[] args) {
        HashMap<String,String> mergeMap = new HashMap<>();
        HashMap<String,String> mergeMap1 = new HashMap<>();

        mergeMap.put("name", "biswa");
        mergeMap1.put("surname","jena");

        mergeMap1.forEach((key, value) -> mergeMap.merge(key, value,String::concat));

        System.out.println(mergeMap);


    }
}
