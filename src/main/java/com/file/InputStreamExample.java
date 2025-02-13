package com.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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
    }
    
}
