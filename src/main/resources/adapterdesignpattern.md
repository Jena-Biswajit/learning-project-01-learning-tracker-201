
### Adapter Design Pattern

The Adapter Pattern works as a bridge between two incompatible interfaces. It allows classes to work together that couldn't otherwise due to incompatible interfaces.

> Think of it like a travel adapter for a power socket — it converts one interface into another.

---

### Real-World Analogy
You're in Europe with a device that has a US plug. Instead of changing your device, you use a power adapter to plug into the European socket. That adapter converts your plug to work with the socket.

---

### Components
- **Target**: The interface your client expects.
- **Adaptee**: An existing class with a different interface.
- **Adapter**: Converts the interface of the adaptee to the target interface.

---

### Code Example (Java)
#### Target Interface
```java
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
```

#### Adaptee Class
```java
public class AdvancedMediaPlayer {
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }
}
```

#### Adapter Class
```java
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        advancedMediaPlayer = new AdvancedMediaPlayer();
    }

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else {
            System.out.println("Invalid format");
        }
    }
}
```

#### Client Code
```java
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        }
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

#### Test Class
```java
public class AdapterPatternTest {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("avi", "clip.avi");
    }
}
```

---

### Unit Test with JUnit
```java
import org.junit.jupiter.api.Test;

public class AdapterPatternTestJUnit {
    @Test
    void testAdapterPattern() {
        AudioPlayer player = new AudioPlayer();
        player.play("vlc", "demo.vlc");
        player.play("mp4", "demo.mp4");
    }
}
```

---

### Explanation of Code
- `MediaPlayer` is the interface expected by the client.
- `AdvancedMediaPlayer` is the existing class that has incompatible method names.
- `MediaAdapter` converts calls from `MediaPlayer` to `AdvancedMediaPlayer`.
- `AudioPlayer` is the client using both directly supported and adapted formats.

---

### Advantages
- Allows integration of legacy/incompatible classes.
- Promotes code reusability.
- Decouples client code from third-party libraries.

### Disadvantages
- Adds extra classes and complexity.
- Not suitable when interfaces are drastically different.

---

### Real-World Use Cases
- Wrapping legacy APIs for new applications.
- Connecting new system interfaces with old ones.
- Adapter classes in Java (`InputStreamReader`, `OutputStreamWriter`).
- Converting XML to JSON or vice versa.

---

### Summary Table
| Role      | Example Class         |
|-----------|------------------------|
| Target    | `MediaPlayer`          |
| Adaptee   | `AdvancedMediaPlayer`  |
| Adapter   | `MediaAdapter`         |
| Client    | `AudioPlayer`          |

---

