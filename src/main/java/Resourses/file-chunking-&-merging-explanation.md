### explanation of FileChunkingAndMergingExample code explanation 

***Code***

```
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
```

- ```FILE_SIZE = 100 * 1024``` → Defines the total file size 100 KB (102,400 bytes).
- ```CHUNK_SIZE = 8 * 1024``` → Defines the chunk size 8 KB (8192 byt

- Declares fileName as "data.txt" (this is the file we will create).
```String fileName = "data.txt"; ```

- Creates a FileOutputStream (fos) to write to "data.txt".
- The try (...) { } block ensures that the file closes automatically after execution.
- ``` try (FileOutputStream fos = new FileOutputStream(fileName)) { ```

- Creates a byte array (buffer) of 8 KB → This holds data before writing to the file.
- Creates a Random object to generate random bytes.
```
byte[] buffer = new byte[CHUNK_SIZE];
            Random random = new Random();
```

- Loop runs 12 times (i = 0 to 11).
- Generates 8 KB of random data (random.nextBytes(buffer);).
- Writes 8 KB to the file (fos.write(buffer);).
- After 12 iterations, 96 KB is written (12 * 8 KB = 96 KB).
```
for (int i = 0; i < 12; i++) {
    random.nextBytes(buffer);  // Fill buffer with random data
    fos.write(buffer);
}
```

- inputFile = "data.txt"; → The original 100 KB file.
- mergedFile = "data1.txt"; → The output file after merging all chunks.
```
String inputFile = "data.txt";
String mergedFile = "data1.txt";
```

-  Step 1: Split the file
```splitFile(inputFile);```

- Step 2: Merge the file
```mergeFiles(mergedFile);```

- Step 3: Verify file content

- Calls splitFile() to split data.txt into 8 KB chunks.
- Calls mergeFiles() to merge all chunks into data1.txt.
- Calls compareFiles() to check if data1.txt matches data.txt.

- Step 4: Check if Files Match

```
if (compareFiles(inputFile, mergedFile)) {
System.out.println("Success: The merged file matches the original file.");
} else {
System.out.println("Error: The merged file does not match the original file.");
}
```

- compareFiles() method checks if data1.txt is identical to data.txt.
- If true: Print "Success: The merged file matches the original file."
- If false: Print "Error: The merged file does not match the original file."


***Method 1: Splitting the File***

```
public static void splitFile(String filePath) throws IOException {
Method to split data.txt into 8 KB chunks.
Throws IOException in case of errors.
Step 1: Open File for Reading
```

- File file = new File(filePath);
- FileInputStream fis = new FileInputStream(file);
- File file = new File(filePath); → Creates a File object for data.txt.
- FileInputStream fis = new FileInputStream(file); → Opens the file for reading.


***Step 2: Create Buffer for Reading Chunks***

```
byte[] buffer = new byte[CHUNK_SIZE];
Creates a buffer of 8 KB to temporarily hold data while reading from data.txt.
```

***Step 3: Read the File in Chunks***

```
int bytesRead, chunkCount = 1;
while ((bytesRead = fis.read(buffer)) > 0) {
```
- Reads CHUNK_SIZE (8 KB) from the file into the buffer.
- Loop continues until the end of the file.
- bytesRead stores the number of bytes read in each iteration.


***Step 4: Write Each Chunk to a Separate File***

```
String chunkName = "chunk_" + chunkCount + ".bin";
FileOutputStream fos = new FileOutputStream(chunkName);
fos.write(buffer, 0, bytesRead);
fos.close();
System.out.println("Created chunk: " + chunkName);
chunkCount++;
```
- Creates chunk files (chunk_1.bin, chunk_2.bin, ...).
- Writes bytesRead bytes into each chunk file.
- Closes the chunk file after writing.
- Prints a message to confirm chunk creation.


***Step 5: Close the Original File***

```fis.close();}```

- Closes FileInputStream, freeing resources.


***2: Merging Chunks Back***

```
public static void mergeFiles(String outputFile) throws IOException {
```
- Method to merge all chunk files (chunk_1.bin, chunk_2.bin, etc.) into data1.txt.

***Step 1: Open Output File***

```FileOutputStream fos = new FileOutputStream(outputFile);```
- Creates FileOutputStream for data1.txt → This will store merged data.

***Step 2: Read and Merge Chunks***

```
int chunkCount = 1;
while (true) {
File chunkFile = new File("chunk_" + chunkCount + ".bin");
if (!chunkFile.exists()) break; // No more chunks
```
- Checks if the next chunk file (chunk_1.bin, chunk_2.bin, etc.) exists.
- If no more chunks exist, exit the loop.

***Step 3: Read Each Chunk and Append to Output File***

```
FileInputStream fis = new FileInputStream(chunkFile);
byte[] buffer = new byte[CHUNK_SIZE];
int bytesRead = fis.read(buffer);
fos.write(buffer, 0, bytesRead);
fis.close();
```

- System.out.println("Merged chunk: " + chunkFile.getName());
- Reads data from each chunk file (chunk_1.bin, etc.).
- Writes the chunk data into data1.txt.
- Closes the chunk file after merging.
- Prints a message confirming that the chunk was merged.

***Step 4: Close Merged File***

```fos.close(); }```

- Closes data1.txt, completing the merging process.

***Method 3: Comparing Original and Merged File***

```public static boolean compareFiles(String file1, String file2) throws IOException {```

- Method to compare data.txt and data1.txt byte by byte.

***Step 1: Open Both Files***

```
FileInputStream fis1 = new FileInputStream(file1);
FileInputStream fis2 = new FileInputStream(file2);
```

- Opens data.txt and data1.txt for reading.

***Step 2: Compare Bytes One by One***

```
int byte1, byte2;
while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
if (byte1 != byte2) {
fis1.close();
fis2.close();
return false;
}
}
```
- Reads bytes from both files one by one.
- If any bytes are different, return false (files are not the same).

***Step 3: Check If Both Files Ended Together***

```
boolean areFilesEqual = fis1.read() == -1 && fis2.read() == -1;
fis1.close();
fis2.close();
return areFilesEqual;
}
```

- If both files end at the same time, return true (files are identical).
- Otherwise, return false.
