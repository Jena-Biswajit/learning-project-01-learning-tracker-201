package com.example.observerdesignpattern;

// Observer Interface
public interface Observer {
    void update(String news);
}

// Subject Interface
interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}