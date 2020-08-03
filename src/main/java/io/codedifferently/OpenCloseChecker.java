package io.codedifferently;

import java.util.HashMap;
import java.util.Stack;

public class OpenCloseChecker {

    public boolean parenthesisChecker(String input){
        HashMap<Character, Character> matchingPairs = new HashMap<Character, Character>();
        Stack<Character> pairs = new Stack<Character>();
        matchingPairs.put('(', ')');
        matchingPairs.put('{', '}');
        matchingPairs.put('[', ']');
        matchingPairs.put('<', '>');
        matchingPairs.put('"', '"');
        matchingPairs.put('\'', '\'');
        char [] charactersOfInput = input.toCharArray();
        for(Character elements : charactersOfInput){
            if(matchingPairs.containsKey(elements)){
                pairs.push(elements);
            }else if (matchingPairs.containsValue(elements)){
                if(!pairs.empty() && matchingPairs.get(pairs.peek()) == elements){
                    pairs.pop();
                }else{
                    return false;
                }
            }
        }
        return pairs.empty();

    }
}
