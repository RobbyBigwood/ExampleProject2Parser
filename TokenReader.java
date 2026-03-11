// TokenReader.java
// Author: Robby Bigwood
// Auggie Eagle
// Reads text files that contain token


import java.util.ArrayList;
import java.util.Scanner;

public class TokenReader {

    /**
     * Creates a list of tokens from the given input.
     * @param input A Scanner object pointed at text content.
     * @return An ArrayList of Token objects
     */
    public ArrayList<Token> readTokens(Scanner input) {
        ArrayList<Token> tokens = new ArrayList<>();

        while (input.hasNext()) {
            String lexeme = input.next();          // e.g. "37.5"
            String typeString = input.next();      // e.g. "NUMBER"
            
            TokenType type = TokenType.valueOf(typeString);
            tokens.add(new Token(lexeme, type));
        }

        return tokens;
}
}