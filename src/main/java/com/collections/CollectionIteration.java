package com.collections;

import java.util.*;

public class CollectionIteration {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("For-Each Loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 1. For loop with index (for list type)
        System.out.println("\nUsing For loop with index:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 2. Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 3. Using ListIterator
        System.out.println("\nUsing ListIterator:");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // 4. Using Enumeration
        System.out.println("\nUsing Enumeration:");
        Enumeration<String> enumeration = Collections.enumeration(list);
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        //5. iterater list
        List<Integer> iterateList = Arrays.asList(3,0,8);
        Iterator<Integer>listIterator1 = iterateList.iterator();

        System.out.println("\niterate over list");

        while (listIterator1.hasNext()){
            System.out.println(listIterator1.next());
        }


        //hasPrevious() example
        List<String> list1 = Arrays.asList("One", "Two", "Three", "Four");

        // Creating ListIterator starting at the end of the list
        ListIterator<String> listIterator2 = list1.listIterator(list1.size());

        System.out.println("\nIterating Backward using hasPrevious():");
        while (listIterator2.hasPrevious()) {
            System.out.println(listIterator2.previous());
        }


       //6. iterate set
       Set<Integer> iterateSet = new HashSet<>(Arrays.asList(10,20,30));
        Iterator<Integer> iterate = iterateSet.iterator();

        System.out.println("\niterate over set");

        while(iterate.hasNext()){
            System.out.println(iterate.next());
        }

        //iterate over entrySet of Map
        Map<Integer,String> iterateMap = new HashMap<>();
        iterateMap.put(1,"biswa");
        iterateMap.put(2,"abd");
        iterateMap.put(3,"bcd");
        iterateMap.put(4,"efg");
        iterateMap.put(5,"ijk");
        iterateMap.put(5,"ijk");

        Iterator<Map.Entry<Integer,String>> mapIterator = iterateMap.entrySet().iterator();

        System.out.println("\niterate over entrySet");

            while (mapIterator.hasNext()) {
                Map.Entry<Integer, String> entry = mapIterator.next();
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
    }
}
