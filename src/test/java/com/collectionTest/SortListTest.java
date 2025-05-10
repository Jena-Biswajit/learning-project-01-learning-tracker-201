package com.collectionTest;

import java.util.*;

// Define the Person class
class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString method for better output display
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SortListTest {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("rajesh", 30));
        people.add(new Person("biswa", 25));
        people.add(new Person("samir", 35));
        people.add(new Person("rasmi", 28));

        // Print the list before sorting
        System.out.println("Before Sorting:");
        for (Person person : people) {
            System.out.println(person);
        }

        // Sort the list in descending order of age using a Comparator
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p2.getAge(), p1.getAge()); // Descending order
            }
        });

        // Print the list after sorting
        System.out.println("\nAfter Sorting (Descending by Age):");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}