import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a text file from your System");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        } else {
            System.out.println("File selection cancelled by user.");
        }
    }

    private static void processFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                String[] words = line.split("\\s+");
                wordCount += words.length;

                charCount += line.length();
            }


            System.out.println("Summary Report:");
            System.out.println("Name of File: " + file.getName());
            System.out.println("Number of Lines in the file: " + lineCount);
            System.out.println("Number of Words in the file: " + wordCount);
            System.out.println("Number of Characters in the file: " + charCount);

        } catch (IOException e) {
            System.err.println("Error occurs while reading the file: " + e.getMessage());
        }
    }
}
