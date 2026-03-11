//Main.java
// Main class to read tokens from a file and recognize the expression
// Robby Bigwood
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <filename>");
            System.exit(1);
        }
        String filename = args[0];
        String fileContents;

        TokenReader reader = new TokenReader();
        try (Scanner s = new Scanner(new File(filename))) {
            ArrayList<Token> tokens = reader.readTokens(s);
            Recognizer recognizer = new Recognizer(tokens);
            boolean isValid = recognizer.recognize();
            if (isValid) {
                System.out.println("The expression is valid.");
            } else {
                System.out.println("The expression is invalid.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (Exception e) {
            System.out.println("Error recognizing expression: " + e.getMessage());
        }
    }
}