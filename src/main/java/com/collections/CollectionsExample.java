package com.collections;

import java.util.Vector;

import java.util.*;

public class CollectionsExample {
    // add element in array vector and hashTables

    public static void main(String[] args) {

        // array element
        int [] array = {1,2,3,4,5};

        // add element in vector

        Vector<Integer> integerVector = new Vector();
        integerVector.add(1);
        integerVector.add(2);

        // add element in hashTables it basically stored key value pair
        Hashtable<Integer,String> h = new Hashtable<>();
        h.put(1,"biswajit");
        h.put(2,"jena");

        // display element

        System.out.println(Arrays.toString(array));
        System.out.println(integerVector);
        System.out.println(h);

        // practice all available methods for list interface and their classes

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        list.add(0,6);
//
//        list.remove(1);

        System.out.println(list.get(0));

        list.set(0,8);

        System.out.println(list.get(0));

        list.remove(0);

        System.out.println(list.get(0));

        System.out.println(list.indexOf(2));


        // if a element is not present in the list and you asked for the index it will show you
        // -1 of the index
        System.out.println(list.indexOf(8));

        System.out.println(list.indexOf(5));

        System.out.println(list.indexOf(100));


        // this will return the within given index
        System.out.println(list.subList(2,3));

        //Returns true if this list contains the specified element.
        System.out.println(list.contains(8));

        // find the size of the list
        System.out.println(list.size());

        //checks if the list is empty or not
        System.out.println(list.isEmpty());

        //linkedlist methods example

        LinkedList<Integer> linkedlist = new LinkedList<>();

        // add element in head node of the linkedlist
        linkedlist.addFirst(41);
        System.out.println(linkedlist);
    }

}
