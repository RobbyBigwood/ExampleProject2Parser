// TokenReaderTest.java
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


public class TokenReaderTest {

    public TokenReaderTest() {
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
     * Test of getLexeme method, of class Token.
     */
    @Test
    public void testReadTokens() {
        System.out.println("Running readTokens() test");
        TokenReader instance = new TokenReader( );
        Scanner s = new Scanner( "37.5 NUMBER\n* MULTIPLY");
        
        ArrayList<Token> expected = new ArrayList<>();
        expected.add( new Token( "37.5", TokenType.NUMBER));
        expected.add( new Token( "*", TokenType.MULTIPLY));
        ArrayList<Token> actual = instance.readTokens(s);
        assertEquals(expected, actual);    
    }

    @Test
    public void testReadTokensEmpty() {
        System.out.println("Running readTokensEmpty() test");
        TokenReader instance = new TokenReader( );
        Scanner s = new Scanner( "" );
        
        ArrayList<Token> expected = new ArrayList<>();
        ArrayList<Token> actual = instance.readTokens(s);
        assertEquals(expected, actual);    
    }

    @Test
    public void testReadTokensLongList() {
        System.out.println("Running readTokensLongList() test");
        TokenReader instance = new TokenReader( );
        Scanner s = new Scanner( "37.5 NUMBER\n* MULTIPLY\n12.0 NUMBER\n+ ADD\n12 NUMBER\n) RIGHT_PARENTHESIS\n5.0 NUMBER\n+ ADD" );
        
        ArrayList<Token> expected = new ArrayList<>();
        expected.add( new Token( "37.5", TokenType.NUMBER));
        expected.add( new Token( "*", TokenType.MULTIPLY));
        expected.add( new Token( "12.0", TokenType.NUMBER));
        expected.add( new Token( "+", TokenType.ADD));
        expected.add( new Token( "12", TokenType.NUMBER));
        expected.add( new Token( ")", TokenType.RIGHT_PARENTHESIS));
        expected.add( new Token( "5.0", TokenType.NUMBER));
        expected.add( new Token( "+", TokenType.ADD));
        ArrayList<Token> actual = instance.readTokens(s);
        assertEquals(expected, actual);    
    }

}