package io.codedifferently;

import java.util.Stack;
import java.util.logging.Logger;

public class OpenCloseChecker {
    private Stack<Character> checker;
    private static final Logger myLogger = Logger.getLogger("io.codedifferently");
    private int numOfSingleQuotes = 0;
    private int numOfDoubleQuotes = 0;

    public OpenCloseChecker() {
        checker = new Stack<Character>();
        numOfSingleQuotes = 0;
        numOfDoubleQuotes = 0;
    }

    public static void main(String[] args) {
        OpenCloseChecker openClosed = new OpenCloseChecker();
        myLogger.info("answer is: " + openClosed.checkIfCharactersArePaired("abc\'\'"));
    }

    public boolean checkIfCharactersArePaired(String value) {
        boolean isStringStillValid = true;
        for(Character character: value.toCharArray()) {
            if(isStringStillValid) {
                if(getNumOfSingleQuotes() == 0 && getNumOfDoubleQuotes() == 0) {
                    switch(character) {
                        case '(':
                        case '{':
                        case '[':
                        case '<':
                            checker.add(character);
                            break;
                        case ')':
                            isStringStillValid = lastCharacterWasOpeningOfSpecificType('(');
                            break;
                        case '}':
                            isStringStillValid = lastCharacterWasOpeningOfSpecificType('{');
                            break;
                        case ']':
                            isStringStillValid = lastCharacterWasOpeningOfSpecificType('[');
                            break;
                        case '>':
                            isStringStillValid = lastCharacterWasOpeningOfSpecificType('<');
                            break;
                    }
                }

                if(character == '\'') {
                    if(getNumOfSingleQuotes() == 1) {
                        isStringStillValid = lastCharacterWasOpeningOfSpecificType('\'');
                        setNumOfSingleQuotes(getNumOfSingleQuotes() - 1);
                    }
                    else {
                        checker.add('\'');
                        setNumOfSingleQuotes(getNumOfSingleQuotes() + 1);
                    }
                }
                if(character == '\"') {
                    if(getNumOfDoubleQuotes() == 1) {
                        isStringStillValid = lastCharacterWasOpeningOfSpecificType('\"');
                        setNumOfDoubleQuotes(getNumOfDoubleQuotes() - 1);
                    }
                    else {
                        checker.add('\"');
                        setNumOfDoubleQuotes(getNumOfDoubleQuotes() + 1);
                    }
                }
            }
            else {
                return false;
            }
        }
        return checker.size() == 0 && isStringStillValid;
    }

    public boolean lastCharacterWasOpeningOfSpecificType(Character character) {
        if(checker.size() != 0 && checker.peek() == character) {
            checker.pop();
        }
        else {
            return false;
        }
        return true;
    }

    public Stack<Character> getChecker() {
        return checker;
    }

    public int getNumOfSingleQuotes() {
        return numOfSingleQuotes;
    }

    public void setNumOfSingleQuotes(int numOfSingleQuotes) {
        this.numOfSingleQuotes = numOfSingleQuotes;
    }

    public int getNumOfDoubleQuotes() {
        return numOfDoubleQuotes;
    }

    public void setNumOfDoubleQuotes(int numOfDoubleQuotes) {
        this.numOfDoubleQuotes = numOfDoubleQuotes;
    }
}
