package com.example.singleton.serialization;

import com.example.singleton.cloning.SingletonClone;

public class SingletonCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonClone s1 = SingletonClone.getInstance();
        SingletonClone s2 = (SingletonClone) s1.clone();

        System.out.println("s1 hashCode = " + s1.hashCode());
        System.out.println("s2 hashCode = " + s2.hashCode());
        System.out.println("Same instance? " + (s1 == s2));
    }
}