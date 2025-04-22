### Observer Design Pattern

The Observer Pattern defines a one-to-many dependency between objects so that when one object (subject) changes state, all its dependents (observers) are notified and updated automatically.

> Think of it like a subscription model — observers subscribe to receive updates from the subject.

---

### Real-World Analogy
Imagine a news agency (Subject) that publishes news. Subscribers (Observers) register with the agency to get notified whenever there's new news.

---

### Components
- **Subject**: Maintains a list of observers and notifies them of any state change.
- **Observer**: Defines an updating interface for objects that should be notified.
- **ConcreteSubject**: Stores state and notifies observers.
- **ConcreteObserver**: Implements the update method to keep its state consistent.

---

### Code Example (Java)
#### Subject and Observer Interfaces
```java
// Observer Interface
public interface Observer {
    void update(String news);
}

// Subject Interface
public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}
```

#### Concrete Implementations
```java
import java.util.ArrayList;
import java.util.List;

// Concrete Subject
public class NewsAgency implements Subject {
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
public class EmailSubscriber implements Observer {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received via Email: " + news);
    }
}

public class SmsSubscriber implements Observer {
    private String name;

    public SmsSubscriber(String name) {
        this.name = name;
    }

    public void update(String news) {
        System.out.println(name + " received via SMS: " + news);
    }
}
```

---

### Unit Test with JUnit
```java
import org.junit.jupiter.api.Test;

public class ObserverPatternTestJUnit {
    @Test
    void testObserverNotification() {
        NewsAgency agency = new NewsAgency();
        Observer observer = new EmailSubscriber("JUnitUser");

        agency.attach(observer);
        agency.setNews("JUnit Test News");
    }
}
```

**O/P**



---

### Explanation of Code
- `NewsAgency` is the subject that holds state (`latestNews`) and notifies registered observers.
- `EmailSubscriber` and `SmsSubscriber` are concrete observers that print the received news.
- Client code demonstrates subscribing, publishing, and unsubscribing events.

---

### Advantages
- Promotes loose coupling.
- Dynamic relationships between objects.
- Supports broadcast communication.

###  Disadvantages
- Memory leaks if observers are not unsubscribed.
- Unexpected updates if not handled carefully.

---

### Real-World Use Cases
- GUI frameworks (e.g., listeners in Swing or JavaFX).
- Event management systems.
- Publish-subscribe systems in messaging (e.g., Kafka, MQTT).
- Notification systems (Email, SMS, Push).

---

### Summary Table
| Role              | Example Class         |
|-------------------|------------------------|
| Subject           | `NewsAgency`           |
| Observer          | `Observer` interface   |
| Concrete Observer | `EmailSubscriber`, `SmsSubscriber` |
| Client            | `ObserverPatternTest`  |

---

Ready for the next one: **Adapter Design Pattern**?

