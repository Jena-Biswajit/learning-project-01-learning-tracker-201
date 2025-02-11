package com.example.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHadelingExample {
    public static void main(String[] args) {

        // code to create a new file
        File myFile = new File("createFile.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            System.out.println("unable to create this file");
            throw new RuntimeException(e);
        }

        // code to write to a file
        try {
            FileWriter fw = new FileWriter("createFile.txt");
            fw.write("this is my first file write");
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read form file

        File myReadFile = new File("createFile.txt");
        try {
            Scanner sc  = new Scanner(myFile);

            while (sc.hasNext()){

               String line =  sc.next();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Deleting a file
//        File myFile = new File("createFile.txt");
//        if(myFile.delete()){
//            System.out.println("the file is deleted"+myFile.getName());
//        }
//        else{
//            System.out.println("some problem occur while deleting the file");
//        }
    }
}
