package com.example.singleton.eager;

public class SingletonEager {

    public static SingletonEager singletonEager = new SingletonEager();

    private SingletonEager(){
        System.out.println("Eager Singleton Created");
    }
    public static SingletonEager getSingletonEager(){
        return singletonEager;
    }
}
