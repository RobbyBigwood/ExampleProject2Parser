// TokenTest.java
//Author: Robby Bigwood
// Auggie Eagle

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TokenTest {

    public TokenTest() {
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
    public void testGetLexeme() {
        System.out.println("Running getLexeme test");
        Token instance = new Token( "3.7", TokenType.NUMBER);
        
        String expected = "3.7";
        String actual = instance.getLexeme();
        assertEquals(expected, actual);    
    }

    @Test
    public void testGetType() {
        System.out.println("Running getType test");
        Token instance = new Token( "3.7", TokenType.NUMBER);
        TokenType expected = TokenType.NUMBER;
        TokenType actual = instance.getType();
        assertEquals(expected, actual);
    }
    
}
