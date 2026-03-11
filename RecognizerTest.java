// RecognizerTest.java
// Auggie Eagle
//Author: Robby Bigwood

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RecognizerTest {

    public RecognizerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Running BeforeAll");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Running AfterAll");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Running BeforeEach");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Running AfterEach");
    }
    
    /**
     * Test of recognize method: an empty token list is not a valid expression.
     */
    @Test
    public void testRecognizeEmpty() {
        System.out.println("Running testRecognizeEmpty()");
        ArrayList<Token> tokens = new ArrayList<>();
        Recognizer instance = new Recognizer(tokens);
        assertFalse(instance.recognize());
    }

    /**
     * Test of recognize method: a single integer number is a valid expression.
     */
    @Test
    public void testRecognizeSingleNumber() {
        System.out.println("Running testRecognizeSingleNumber()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("5", TokenType.NUMBER));
        Recognizer instance = new Recognizer(tokens);
        assertTrue(instance.recognize());
    }

    /**
     * Test of recognize method: a simple addition of two numbers is valid.
     */
    @Test
    public void testRecognizeSimpleAddition() {
        System.out.println("Running testRecognizeSimpleAddition()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("3", TokenType.NUMBER));
        tokens.add(new Token("+", TokenType.ADD));
        tokens.add(new Token("4", TokenType.NUMBER));
        Recognizer instance = new Recognizer(tokens);
        assertTrue(instance.recognize());
    }

    /**
     * Test of recognize method: an expression starting with an operator is invalid.
     * Grammar requires exp to start with a term, not an operator.
     */
    @Test
    public void testRecognizeOperatorWrong() {
        System.out.println("Running testRecognizeOperatorWrong()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("+", TokenType.ADD));
        tokens.add(new Token("3", TokenType.NUMBER));
        Recognizer instance = new Recognizer(tokens);
        assertFalse(instance.recognize());
    }

    /**
     * Test of recognize method: a simple subtraction is valid.
     */
    @Test
    public void testRecognizeSimpleSubtraction() {
        System.out.println("Running testRecognizeSimpleSubtraction()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("10", TokenType.NUMBER));
        tokens.add(new Token("-", TokenType.SUBTRACT));
        tokens.add(new Token("2", TokenType.NUMBER));
        Recognizer instance = new Recognizer(tokens);
        assertTrue(instance.recognize());
    }

    /**
     * Test of recognize method: a simple multiplication is valid.
     */
    @Test
    public void testRecognizeSimpleMultiplication() {
        System.out.println("Running testRecognizeSimpleMultiplication()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("6", TokenType.NUMBER));
        tokens.add(new Token("*", TokenType.MULTIPLY));
        tokens.add(new Token("7", TokenType.NUMBER));
        Recognizer instance = new Recognizer(tokens);
        assertTrue(instance.recognize());
    }

    /**
     * Test of recognize method: a parenthesized expression is valid.
     */
    @Test
    public void testRecognizeParenthesizedExpression() {
        System.out.println("Running testRecognizeParenthesizedExpression()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("(", TokenType.LEFT_PARENTHESIS));
        tokens.add(new Token("3", TokenType.NUMBER));
        tokens.add(new Token("+", TokenType.ADD));
        tokens.add(new Token("4", TokenType.NUMBER));
        tokens.add(new Token(")", TokenType.RIGHT_PARENTHESIS));
        Recognizer instance = new Recognizer(tokens);
        assertTrue(instance.recognize());
    }

    /**
     * Test of recognize method: a missing closing parenthesis is invalid.
     * Grammar requires ( exp ) — the right paren is not optional.
     */
    @Test
    public void testRecognizeMissingCloseParen() {
        System.out.println("Running testRecognizeMissingCloseParen()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("(", TokenType.LEFT_PARENTHESIS));
        tokens.add(new Token("3", TokenType.NUMBER));
        tokens.add(new Token("+", TokenType.ADD));
        tokens.add(new Token("4", TokenType.NUMBER));
        Recognizer instance = new Recognizer(tokens);
        assertFalse(instance.recognize());
    }

    /**
     * Test of recognize method: empty parentheses contain no expression and are invalid.
     * Grammar requires ( exp ), and exp cannot be empty.
     */
    @Test
    public void testRecognizeEmptyParentheses() {
        System.out.println("Running testRecognizeEmptyParentheses()");
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("(", TokenType.LEFT_PARENTHESIS));
        tokens.add(new Token(")", TokenType.RIGHT_PARENTHESIS));
        Recognizer instance = new Recognizer(tokens);
        assertFalse(instance.recognize());
    }

}