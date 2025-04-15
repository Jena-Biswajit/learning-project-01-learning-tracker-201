package com.collectionTest;

import java.util.*;

public class RemoveElementFromHashmap {

    public static void main(String[] args) {

        // sample hashmap
        HashMap<String,Integer> removeElement = new HashMap<>();

        removeElement.put("A",40);
        removeElement.put("B",50);
        removeElement.put("B",50);
        removeElement.put("C",60);

        System.out.println("element is map is :" + removeElement);

        //Step -1 get all values and sort them

        List<Integer> listElement = new ArrayList<>();
        Set<Integer> unqValue = new TreeSet<>(Collections.reverseOrder());
        unqValue.addAll(listElement);


        // find the 2nd highest value
        if(unqValue.size()<2){
            System.out.println("no unique value ");
            return;
        }


    }
}
