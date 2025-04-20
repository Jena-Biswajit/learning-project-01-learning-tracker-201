package com.example.singleton.util;

import com.example.singleton.eager.SingletonEager;
import com.example.singleton.lazy.SingletonLazy;

public class SingletonExample {
    public static void main(String[] args) {
        SingletonLazy singletonLazy1 = SingletonLazy.getSingletonLazy();
        System.out.println(singletonLazy1 . hashCode());

        SingletonLazy singletonLazy2 = SingletonLazy.getSingletonLazy();
        System.out.println(singletonLazy2 . hashCode());

        SingletonEager singletonEager1 = SingletonEager.getSingletonEager();
        System.out.println(singletonEager1 . hashCode());

        SingletonEager singletonEager2 = SingletonEager.getSingletonEager();
        System.out.println(singletonEager2 . hashCode());

    }
}
