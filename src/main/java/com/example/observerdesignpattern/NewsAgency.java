package com.example.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject
 public  class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;

    public void setNews(String news) {
        this.latestNews = news;
        notifyObservers();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(latestNews);
        }
    }
}

// Concrete Observers
class EmailSubscriber implements Observer {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received via Email: " + news);
    }
}

class SmsSubscriber implements Observer {
    private String name;

    public SmsSubscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received via SMS: " + news);
    }
}