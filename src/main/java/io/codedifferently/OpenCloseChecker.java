package io.codedifferently;

import java.util.Stack;
import java.util.logging.Logger;

public class OpenCloseChecker {
    private Stack<Character> checker;
    private static final Logger myLogger = Logger.getLogger("io.codedifferently");

    public OpenCloseChecker() {
        checker = new Stack<Character>();
    }

    public static void main(String[] args) {
        OpenCloseChecker openClosed = new OpenCloseChecker();
        myLogger.info("answer is: " + openClosed.checkIfCharactersArePaired("abc\'\'"));

    }

    public boolean checkIfCharactersArePaired(String value) {
        boolean isStringStillValid = true;
        boolean haveNotCheckedQuotation = true;
        for(Character character: value.toCharArray()) {
            if(isStringStillValid) {
                switch(character) {
                    case '(':
                    case '{':
                    case '[':
                    case '<':
                    case '\"':
                    case '\'':
                        checker.add(character);
                        haveNotCheckedQuotation = false;
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
                if(haveNotCheckedQuotation && character == '\"') {
                    isStringStillValid = lastCharacterWasOpeningOfSpecificType('\"');
                }
                else if(haveNotCheckedQuotation && character == '\'') {
                    isStringStillValid = lastCharacterWasOpeningOfSpecificType('\'');
                }
                haveNotCheckedQuotation = true;
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
}
