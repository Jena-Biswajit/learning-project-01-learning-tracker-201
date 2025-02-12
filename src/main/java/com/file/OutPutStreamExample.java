package com.file;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
// import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
    String name ;
    int age;
    Person(String name , int age){
        this.name = name ;
        this.age = age;
    }
}


public class OutPutStreamExample {
    public static void main(String[] args) {

        // using FileOutputStream
        String data = "covert string to byte and write in file using FileOutputStream ";
        try (FileOutputStream fos = new FileOutputStream("createFile.txt")) {

            fos.write(data.getBytes()); // method to convert string to bytes and write
            System.out.println("data written successfully");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // using BufferedOutputStream 

        String bufferedData = "Buffered OutputStream example. ";

        try (FileOutputStream bfos = new FileOutputStream("createFile.txt");
            BufferedOutputStream bos = new BufferedOutputStream(bfos)){
            bos.write(bufferedData.getBytes());
            System.out.println("buffered data written successfully");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // using ByteArrayOutputStream 

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write("ByteArrayOutputStream Example".getBytes());
            String output = baos.toString();
            System.out.println("data stored in byte array"+ output);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // using ObjectOutputStream 
         
        try (FileOutputStream ofos = new FileOutputStream("createFile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(ofos)) {

            Person p = new Person("biswa",25);
            oos.writeObject(p); 
            System.out.println("object serialized successfully ");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
