package com.example.singleton.serialization;

import java.io.*;

public class SingletonSerializeTest {
    public static void main(String[] args) throws Exception {
        // 1) Get the Singleton instance
        SingletonSerialize s1 = SingletonSerialize.getInstance();

        // 2) Serialize it to a byte array
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bout)) {
            oos.writeObject(s1);
        }

        // 3) Deserialize it back
        SingletonSerialize s2;
        try (ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()))) {
            s2 = (SingletonSerialize) ois.readObject();
        }

        // 4) Compare references
        System.out.println("s1 hashCode = " + s1.hashCode());
        System.out.println("s2 hashCode = " + s2.hashCode());
        System.out.println("Same instance? " + (s1 == s2));
    }
}
