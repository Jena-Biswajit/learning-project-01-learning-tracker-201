package com.example.singleton.serialization;

import java.io.Serializable;

public class SingletonSerialize implements Serializable {
    private static final long serialVersionUID = 1L;

    // Eagerly initialized Singleton instance
    private static final SingletonSerialize INSTANCE = new SingletonSerialize();

    // Private constructor prevents external instantiation
    private SingletonSerialize() {
        System.out.println("SingletonSerialize constructor called");
    }

    public static SingletonSerialize getInstance() {
        return INSTANCE;
    }

    /**
     * Ensures that the existing INSTANCE is returned during deserialization.
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}
