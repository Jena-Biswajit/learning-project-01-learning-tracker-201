package com.file;

import java.io.*;

// Step 1: Implement Serializable interface
class NewPerson implements Serializable {
    private static final long serialVersionUID = 1L;  // Step 2: Add serialVersionUID
    String name;
    int age;

    public NewPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializedAndDeserialized {
    public static void main(String[] args) {
        NewPerson p = new NewPerson("Alice", 30);

        // Step 3: Serialize the object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            out.writeObject(p);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 4: Deserialize the object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) {
            NewPerson deserializedPerson = (NewPerson) in.readObject();
            System.out.println("Name: " + deserializedPerson.name + ", Age: " + deserializedPerson.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
