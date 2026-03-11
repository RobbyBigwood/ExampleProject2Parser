// Recognizer.java
// Author: Robby Bigwood
// Auggie Eagle
// Recognizer class for a simple lexer and grammatical recognizer for a simple expression language

/**
 *   exp        → term simplePart
 *   simplePart → addop term simplePart | nothin
 *   addop      → + | -
 *   term       → factor simpleTerm
 *   simpleTerm → mulop factor simpleTerm | nothin
 *   mulop      → * | /
 *   factor     → NUMBER | ( exp )
 */


import java.util.ArrayList;

public class Recognizer {

    private ArrayList<Token> tokens;
    private Token lookahead;

    public Recognizer(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.lookahead = null;
    }
    
    /**
     * Recognizes whether the given list of tokens is a valid expression.
     * @return true if the list of tokens is a valid expression, false otherwise
     */
    public boolean recognize() {
        if (tokens.isEmpty()) {
            return false;
        }
        lookahead = tokens.remove(0);
        try {
            exp();
        } catch (Exception e) {
            return false;
        }
        return this.tokens.isEmpty();
    }

    /**
     * an expression turns into a term and a simple part.
     * the simple part is either empty or an addop followed by a term and another simple part.
     */
    public void exp() throws Exception {
	//get this term
	    term();
	    simplePart();
    }

    /**
     * an addop is either a + or a -.
     * else throw an exception
     */
    public void addop() throws Exception {
        //figure out if the addop is actually a +, if it isn't, error
        if (lookahead.getType() == TokenType.ADD) {
            eat();
        }
        else if (lookahead.getType() == TokenType.SUBTRACT) {
            eat();
        }
        else {
            throw new Exception("Expected addop");
        }
    }
	
    /**
     * a term is a factor followed by a simple term.
      * a simple term is either empty or a mulop followed by a factor and another simple term.
      * a mulop is either a * or a /.
      * else throw an exception
     */
    public void term()  throws Exception {
        //f in the table is actually factor
        factor();
        simpleTerm();
    }

    /**
     * a mulop is either a * or a /.
     * else throw an exception
     */
    public void mulop () throws Exception {

        if (lookahead.getType() == TokenType.MULTIPLY ) {
            eat();
        }
        else if (lookahead.getType() == TokenType.DIVIDE) {
            eat();
        }
        else {
            throw new Exception("Expected mulop");
        }
    }

    /**
     * a factor is either a number or an expression in parentheses. If the parenthese are used, the expression must be followed by a right parenthesis.
     * else throw an exception
     */
    public void factor () throws Exception {
        if(lookahead.getType() == TokenType.NUMBER ) {
            eat();
        }
        else if (lookahead.getType() == TokenType.LEFT_PARENTHESIS) {
            eat();
            exp();
            if (lookahead.getType() == TokenType.RIGHT_PARENTHESIS ) {
                eat();
            }
            else {
                throw new Exception("Expected right parenthesis");
            }
        }
        else {
            throw new Exception("Expected number or left parenthesis");
        }
    }


    public void simplePart()  throws Exception {
        if (lookahead != null && (lookahead.getType() == TokenType.ADD || lookahead.getType() == TokenType.SUBTRACT)) {
            addop();
            term();
            simplePart();
        }
    }

    public void simpleTerm() throws Exception {
        if (lookahead != null && (lookahead.getType() == TokenType.MULTIPLY || lookahead.getType() == TokenType.DIVIDE)) {
            mulop();
            factor();
            simpleTerm();
        }
    }

    private void eat() {
    if (tokens.isEmpty()) {
        lookahead = null;
    } else {
        lookahead = tokens.remove(0);
    }
}
}