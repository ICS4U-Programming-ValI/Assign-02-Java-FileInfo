import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * This is the package for FileInfo.java
 *
 * The FileInfo program reads a file
 * and computes basic statistics,
 * such as the total number of lines, words,
 * and characters in the file.
 * Store these values in an array or list and output them.
 * <p>This class satisfies style checkers.</p>
 *
 * @author Val I
 * @version 1.0
 * @since 2025-04-05
 */
public final class FileInfo {

    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private FileInfo() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args .
     */
    public static void main(final String[] args) {
        // Prompt the user for input
        System.out.println("Do you want to get the info from");
        System.out.println("File1(A)");
        System.out.println("File2(B)");
        System.out.println("File3(C)");
        System.out.print("Please select A, B, or C: ");

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Gets user input and converts it to lowercase
        String input = scanner.nextLine().toLowerCase();

        // try catch to handle file reading
        try {

            // Declare the fileName variable
            String fileName;
            // Determine the file based on user input
            if (input.equals("a")) {
                fileName = "./input.txt";
            } else if (input.equals("b")) {
                fileName = "./input2.txt";
            } else if (input.equals("c")) {
                fileName = "./input3.txt";
            } else {
                System.out.println("Invalid option. Please select A, B, or C.");
                scanner.close();
                return;
            }
            // makes the path for the input file
            File inputFile = new File(fileName);
            // creates a scanner object to read the file
            Scanner fileScanner = new Scanner(inputFile);

            // Initialize counters and lists
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            List<String> lines = new ArrayList<>();
            List<String> words = new ArrayList<>();
            List<Character> characters = new ArrayList<>();

            // Makes a loop to read the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Count lines
                lineCount++;
                lines.add(line);
                // Count words
                wordCount += line.split(" ").length;
                for (String word : line.split(" ")) {
                    words.add(word);
                }
                // Count characters
                charCount += line.length();
                for (char c : line.toCharArray()) {
                    characters.add(c);
                }
            }
            // print lists and counts
            System.out.println("Lines: " + lines);
            System.out.println("Total lines: " + lineCount);
            System.out.println("Words: " + words);
            System.out.println("Total words: " + wordCount);
            System.out.println("Characters: " + characters);
            System.out.println("Total characters: " + charCount);

            // Close the file Scanner
            fileScanner.close();
        } catch (FileNotFoundException ex) {
            // Handle the case where the file is not found
            System.out.println("File not found");
        }
        // Close the user input Scanner
        scanner.close();
    }
}
