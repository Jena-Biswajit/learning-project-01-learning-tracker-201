package com.file;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class ReaderExample{
    
    public static void main(String[] args) {
        
        // FileReaderExample

        try{
            FileReader fr = new FileReader("createFile.txt");

            int ch;
            while((ch = fr.read())!= -1){
                System.out.println((char)ch);
            }

            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // BufferedReaderExample
       try {

           BufferedReader br =  new BufferedReader(new FileReader("createFile.txt"));
           String line;
           
           while ((line = br.readLine()) != null) {
              System.out.println(line);
           }

           br.close();


        } catch (Exception e) {
            // TODO: handle exception
        }
        
        //InputStreamReaderExample
        try {
            FileInputStream fis = new FileInputStream("createFile.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            int ch;
            
            while ((ch = isr.read()) != -1) {  // Reads character by character
                System.out.print((char) ch);
            }
            
            isr.close();  // Always close the reader
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CharArrayReaderExample

        char[] charArray = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'B', 'i', 's', 'w','a','!'};
        
        try {
            CharArrayReader reader = new CharArrayReader(charArray);
            int ch;
            
            while ((ch = reader.read()) != -1) {  // Reads character by character
                System.out.print((char) ch);
            }
            
            reader.close();  // Always close the reader
        } catch (IOException e) {
            e.printStackTrace();
        }

        // StringReaderExample
        
        String data = "\nHello, Java!";
        
        try {
            StringReader reader = new StringReader(data);
            int ch;
            
            while ((ch = reader.read()) != -1) {  // Reads character by character
                System.out.print((char) ch);
            }
            
            reader.close();  // Always close the reader
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}