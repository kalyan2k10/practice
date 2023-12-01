package geek.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Interface to define the callback contract
interface FileReadCallback {
    void onFileRead(String content, int lines);
}

// Class responsible for reading a file asynchronously
class AsyncFileReader {

    // Method to read a file asynchronously and invoke the callback
    static void readFile(String filePath, FileReadCallback callback) {
        // Asynchronous file reading simulation using a thread
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;
                int lines = 0;
                // Read each line from the file
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                    lines++;
                }

                // Invoke the callback with the file content
                callback.onFileRead(content.toString(), lines);

            } catch (IOException e) {
                // Handle file reading errors
                e.printStackTrace();
            }
        }).start();
    }
}

// Example usage of AsyncFileReader with a callback
public class CallbackExample {

    public static void main(String[] args) {
        String filePath = "C:\\pwds.txt";

        // Using lambda expression as a callback
        AsyncFileReader.readFile(filePath, (content, lines) -> {
            System.out.println("File content:\n" + content);
            System.out.println("File lines:\n" + lines);
            // Additional processing or handling can be done here
        });

        // Continue with other tasks without waiting for the file reading to complete
        System.out.println("Continuing with other tasks...");
    }
}
