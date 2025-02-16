package com.file;

import java.io.*;
import java.util.Random;

public class FileChanukingAndMerging {

    private static final int FILE_SIZE = 100 * 1024; // 100 KB
    private static final int CHUNK_SIZE = 8 * 1024; // 8 KB

    public static void main(String[] args) throws IOException {

        String fileName = "data.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[CHUNK_SIZE];
            Random random = new Random();

            // Write 12 full chunks (12 * 8 KB = 96 KB)
            for (int i = 0; i < 12; i++) {
                random.nextBytes(buffer);  // Fill buffer with random data
                fos.write(buffer);
            }

            // Write the last 4 KB chunk
            buffer = new byte[4 * 1024];  // 4 KB buffer
            random.nextBytes(buffer);
            fos.write(buffer);

            System.out.println("File 'data.txt' (100 KB) created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputFile = "data.txt";
        String mergedFile = "data1.txt";

        // Step 1: Split the file
        splitFile(inputFile);

        // Step 2: Merge the file
        mergeFiles(mergedFile);

        // Step 3: Verify file content
        if (compareFiles(inputFile, mergedFile)) {
            System.out.println("Success: The merged file matches the original file.");
        } else {
            System.out.println("Error: The merged file does not match the original file.");
        }
    }

    // Method to split file into chunks
    public static void splitFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[CHUNK_SIZE];

        int bytesRead, chunkCount = 1;
        while ((bytesRead = fis.read(buffer)) > 0) {
            String chunkName = "chunk_" + chunkCount + ".bin";
            FileOutputStream fos = new FileOutputStream(chunkName);
            fos.write(buffer, 0, bytesRead);
            fos.close();
            System.out.println("Created chunk: " + chunkName);
            chunkCount++;
        }
        fis.close();
    }

    // Method to merge chunks back into one file
    public static void mergeFiles(String outputFile) throws IOException {
        FileOutputStream fos = new FileOutputStream(outputFile);

        int chunkCount = 1;
        while (true) {
            File chunkFile = new File("chunk_" + chunkCount + ".bin");
            if (!chunkFile.exists()) break; // No more chunks

            FileInputStream fis = new FileInputStream(chunkFile);
            byte[] buffer = new byte[CHUNK_SIZE];
            int bytesRead = fis.read(buffer);
            fos.write(buffer, 0, bytesRead);
            fis.close();
            System.out.println("Merged chunk: " + chunkFile.getName());

            chunkCount++;
        }
        fos.close();
    }

    // Method to compare two files byte by byte
    public static boolean compareFiles(String file1, String file2) throws IOException {
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        int byte1, byte2;
        while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
            if (byte1 != byte2) {
                fis1.close();
                fis2.close();
                return false;
            }
        }

        boolean areFilesEqual = fis1.read() == -1 && fis2.read() == -1;
        fis1.close();
        fis2.close();
        return areFilesEqual;
    }
}