package io.codedifferently;

import java.util.ArrayList;
import java.util.Stack;

public class OpenCloseChecker {

    public boolean parenthesisChecker(String input) {
        Stack<Character> parenthesesReverse = new Stack<Character>();
        ArrayList<Character> parentheses = new ArrayList<Character>();

        for(int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if(current == '(' || current == ')') {
                parenthesesReverse.add(current);
                parentheses.add(current);
            }
        }

        if(parentheses.size() == 0) {
            return true;
        }

        if(parentheses.get(0) == ')' || parentheses.get(parentheses.size()-1) == '(')
            return false;

        for (char currentAL : parentheses) {
            char currentST = parenthesesReverse.pop();
            if ((currentAL == '(' && currentST != ')') || (currentAL == ')' && currentST != '(')) {
                return false;
            }
        }

        return true;
    }

    public boolean expandedChecker(String input) {
        if(!characterChecker(input, '(', ')'))
            return false;
        if(!characterChecker(input, '{', '}'))
            return false;
        if(!characterChecker(input, '[', ']'))
            return false;
        if(!characterChecker(input, '<', '>'))
            return false;
        if(!characterChecker(input, '"', '"'))
            return false;
        return characterChecker(input, '\'', '\'');
    }

    public boolean characterChecker(String input, char open, char close) {
        Stack<Character> charactersReverse = new Stack<Character>();
        ArrayList<Character> characters = new ArrayList<Character>();

        for(int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if(current == open || current == close) {
                charactersReverse.add(current);
                characters.add(current);
            }
        }

        if(characters.size() == 0) {
            return true;
        }

        if((open == '"' || close == '\'') && characters.size() % 2 == 0)
            return true;

        if((characters.get(0) == close || characters.get(characters.size()-1) == open))
            return false;

        for (char currentAL : characters) {
            char currentST = charactersReverse.pop();
            if ((currentAL == open && currentST != close) || (currentAL == close && currentST != open)) {
                return false;
            }
        }

        return true;
    }

}
