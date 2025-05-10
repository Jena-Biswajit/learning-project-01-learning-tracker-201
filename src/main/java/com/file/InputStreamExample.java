package com.file;

import java.io.*;


class Person1 implements Serializable {
    private static final long serialVersionUID = 1L;  // Recommended for serialization
    String name;
    int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class InputStreamExample {

    public static void main(String[] args) {
        
        // FileInputStreamExample 

       try{
            FileInputStream fis = new FileInputStream("createFile.txt");

            // BufferedInputStreamExample
            BufferedInputStream bis = new BufferedInputStream(fis);
            int i;
            while  ((i = bis.read()) != -1)  {
                System.out.println((char) i);
            }

            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // ByteArrayInputStreamExample

        byte[] data = {65, 66, 67, 68, 69}; // A, B, C, D, E in ASCII
        ByteArrayInputStream bais = new ByteArrayInputStream(data);

        int i;
        while ((i = bais.read()) != -1) {
            System.out.print((char) i + " ");  // Convert byte to char
        }

        // ObjectInputStreamExample

        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            Person1 person = (Person1) objIn.readObject();  // Reading object
            person.display();  // Display person data

            objIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

