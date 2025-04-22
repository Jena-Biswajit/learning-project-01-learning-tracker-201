package com.example.singleton.lazy;

public class SingletonLazy {

    private static SingletonLazy singletonLazy = null;

    private SingletonLazy() {
        System.out.println("Lazy Singleton Created");
    }

    public static SingletonLazy getSingletonLazy() {

        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
