package com.example.singleton.ObserverPattern;

import com.example.observerdesignpattern.EmailSubscriber;
import com.example.observerdesignpattern.NewsAgency;
import com.example.observerdesignpattern.Observer;
import org.junit.jupiter.api.Test;

public class ObserverPatternTest {
    @Test
    void testObserverNotification() {
        NewsAgency agency = new NewsAgency();
        Observer observer = new EmailSubscriber("JUnitUser");

        agency.attach(observer);
        agency.setNews("JUnit Test News");
    }
}