package com.example.singleton.serialization;

import com.example.singleton.enumbased.EnumSingleton;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        singleton1.showMessage();

        System.out.println("Are both instances same? " + (singleton1 == singleton2));
    }
}
