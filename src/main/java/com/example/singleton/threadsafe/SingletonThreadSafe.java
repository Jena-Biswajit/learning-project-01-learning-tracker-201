package com.example.singleton.threadsafe;

public class SingletonThreadSafe {
    private static SingletonThreadSafe instance = null;

    private SingletonThreadSafe() {
        System.out.println("Thread-Safe Singleton instance created");
    }

    public static synchronized SingletonThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafe();
        }
        return instance;
    }

//    public static SingletonThreadSafe getInstance() {
//        if (instance == null) {
//            synchronized (SingletonThreadSafe.class){
//                if (instance == null)
//                    instance = new SingletonThreadSafe();
//            }
//
//        }
//        return instance;
//    }
}
