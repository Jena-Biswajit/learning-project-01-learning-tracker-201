package com.file;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
public class WriterExample {
    public static void main(String[] args) {
        
        // FileWriterExample 

        try {
            FileWriter writer = new FileWriter("createFile.txt"); // Overwrites existing file
            writer.write("Hello, FileWriter!\n"); // Writing a string
            writer.write(65);  // Writing a single character ('A' ASCII = 65)
            writer.close(); // Always close the writer
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // BufferedWriterExample 

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("createFile.txt"));
            
            writer.write("Hello, BufferedWriter!"); // Writing a string
            writer.newLine(); // Writing a new line
            writer.write("Writing efficiently with buffer.");
            
            writer.close(); // Closing the writer
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // PrintWriterExample 
        
        try {
            PrintWriter writer = new PrintWriter("createFile.txt");
            
            writer.println("Hello, PrintWriter!"); // Writes with a new line
            writer.print("This is a single line without a newline. ");
            writer.println("Now, this will be on the same line.");
            writer.printf("Formatted number: %.2f", 123.456); // Writes formatted output
            
            writer.close(); // Close the writer
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // OutputStreamWriterExample 

         try {
            FileOutputStream fos = new FileOutputStream("createFile.txt");
            OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");

            writer.write("Hello, OutputStreamWriter!\n");
            writer.write("This demonstrates character encoding.\n");
            
            writer.close();
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // StringWriterExample
        StringWriter writer = new StringWriter();
        
        writer.write("Hello, StringWriter!\n");
        writer.write("This data is stored in memory.\n");
        
        System.out.println("Written Content:\n" + writer.toString());

        // writer.close(); // Not necessary 

        // CharArrayWriterExample

        CharArrayWriter cwriter = new CharArrayWriter();
        
        try {
            cwriter.write("Hello, CharArrayWriter!\n");
            cwriter.write("This data is stored in memory.\n");
            System.out.println("Written Content:\n" + cwriter.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
