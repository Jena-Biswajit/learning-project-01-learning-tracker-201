package com.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        names.add(1, "saroj"); // Insert "Charlie" at index 1
        System.out.println(names); // Output: [Alice, Charlie, Bob]

        List<String> name1 = new ArrayList<>();
        name1.add("biswajit");
        name1.add("chandan");
        System.out.println(name1.get(1));

        List<String> name2 = new ArrayList<>();
        name2.add("biswajit");
        name2.add("chandan");
        name2.remove(0); // Removes element at index 0
        System.out.println(name2); // Output: [chandan]

        name2.remove("chandan"); // Removes the element "chandan"
        System.out.println(name2);

        List<String> name3 = new ArrayList<>();
        name3.add("biswajit");
        name3.add("chandan");
        name3.set(1, "saroj"); // Replace "chandan" with "saroj"
        System.out.println(name3); // Output: [biswajit, saroj]

        List<String> name4 = new ArrayList<>();
        name4.add("biswajit");
        name4.add("chandan");
        System.out.println(name4.indexOf("chandan")); // Output: 1
        System.out.println(name4.indexOf("biswajit")); // Output: -1

        List<String> name5 = new ArrayList<>();
        name5.add("biswajit");
        name5.add("chandan");
        name5.add("saroj");
        System.out.println(name5.subList(1, 3)); // Output: [chandan, saroj]

        List<String> name6 = new ArrayList<>();
        name6.add("biswajit");
        System.out.println(name6.contains("biswajit")); // Output: true
        System.out.println(name6.contains("chandan")); // Output: false

        List<String> name7 = new ArrayList<>();
        name7.add("biswajit");
        name7.add("chandan");
        System.out.println(name7.size()); // Output: 2

        List<String> name8 = new ArrayList<>();
        System.out.println(name8.isEmpty()); // Output: true
        name8.add("biswajit");
        System.out.println(name8.isEmpty()); // Output: false

        List<String> name9 = new ArrayList<>();
        name9.add("biswajit");
        name9.add("chandan");
        name9.clear();
        System.out.println(name9); // Output: []
    }
}
