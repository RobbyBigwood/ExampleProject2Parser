# Robby Bigwood
# Auggie Eagle
# CSC 391

# Math EXPRESSION PARSER

In this project i have a project that will:

1. Read a text file containing lexemes and their corresponding token types (one pair per line).
2. Converts that input into an arrayList of `Token` objects.
3. Uses unit testing to validate the correctness of your implementation.
```
proj2/
 ├── Token.java
 ├── TokenType.java
 ├── TokenReader.java
 ├── TokenReaderTest.java
 ├── TokenTest.java
 └── README.md
```
 ## Input Format

The application reads from a text file formatted as:

Each line contains:
- A lexeme 
- A token type 

# Token.java

will define what a token is (lexeme and type)

# TokenType.java

is an enum class that defines what types of lexemes are acceptable

# TokenReader.java

will contain the methods to read in the file and convert it to a token arrayList

# TokenReaderTest.java

will test if the tokenreader method/class will work will all sorts of inputs (in the future it will handle errors)

# TokenTest.java

will test if the tokens are formatted correctly and if the individual setters and getters are working

## Run the program

to run the program please do these two commands

javac -cp ".\junit.jar;." *.java

java -jar .\junit.jar execute -cp . --scan-classpath .

# alternatively

java Main (filename)