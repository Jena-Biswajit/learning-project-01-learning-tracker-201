package com.example.singleton.cloning;

public class SingletonClone implements Cloneable {
    private static final SingletonClone INSTANCE = new SingletonClone();

    private SingletonClone() {
        // private constructor
    }

    public static SingletonClone getInstance() {
        return INSTANCE;
    }

    // default clone method
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return INSTANCE;  // return the existing instance
    }
}