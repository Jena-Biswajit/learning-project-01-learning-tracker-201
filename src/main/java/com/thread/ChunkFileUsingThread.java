package com.thread;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChunkFileUsingThread {

    private static final int FILE_SIZE = 10 * 1024 * 1024; // 10 MB
    private static final int THREAD_COUNT = 2; // Number of parallel threads

    public static void main(String[] args) throws IOException {
        String fileName = "source.txt";
        createDummyFile(fileName, FILE_SIZE); // Create 10 MB file

        // Define offset ranges for chunking
        int[][] offsets = {
            {0, 19},   // First 20 bytes
            {20, 29}   // Next 10 bytes
        };

        splitFileWithThreads(fileName, offsets);
    }

    // Method to create a 10 MB file with random data
    private static void createDummyFile(String fileName, int fileSize) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] buffer = new byte[1024]; // 1 KB buffer
            for (int i = 0; i < fileSize / 1024; i++) {
                new java.util.Random().nextBytes(buffer);
                fos.write(buffer);
            }
            System.out.println("File '" + fileName + "' (10 MB) created successfully!");
        }
    }

    // Multi-threaded file chunking
    public static void splitFileWithThreads(String filePath, int[][] offsets) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < offsets.length; i++) {
            int chunkNumber = i;
            executor.execute(() -> processChunk(filePath, offsets[chunkNumber][0], offsets[chunkNumber][1], chunkNumber + 1));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }
        System.out.println("File splitting completed.");
    }

    // Method to process each chunk based on offset
    private static void processChunk(String filePath, int startOffset, int endOffset, int chunkNumber) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            int chunkSize = endOffset - startOffset + 1;
            byte[] buffer = new byte[chunkSize];

            raf.seek(startOffset); // Move to the correct position
            int bytesRead = raf.read(buffer);

            if (bytesRead > 0) {
                String chunkName = "chunk_" + chunkNumber + ".bin";
                try (FileOutputStream fos = new FileOutputStream(chunkName)) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Created chunk: " + chunkName + " (Offset: " + startOffset + "-" + endOffset + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
