package com.example.proxydesignpattern;

public class RealFolder implements Folder {
    @Override
    public void access() {
        System.out.println("Accessing the real folder...");
    }
}
