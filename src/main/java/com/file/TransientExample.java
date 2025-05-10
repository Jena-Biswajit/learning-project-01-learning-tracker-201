package com.file;
import java.io.*;

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    String username;
    transient String password;  // This will NOT be serialized

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class TransientExample {
    public static void main(String[] args) {
        User user = new User("JohnDoe", "mySecret123");

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.dat"))) {
            User deserializedUser = (User) in.readObject();
            System.out.println("Username: " + deserializedUser.username);
            System.out.println("Password: " + deserializedUser.password);  // Will print 'null'
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
