package io.codedifferently;

import java.util.HashMap;
import java.util.Stack;

public class OpenCloseChecker {

    public Boolean hasClose(String s){
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put('<', '>');
        map.put('"', '"');
        for (int i = 0; i < s.length(); i++){
            char currentCharacter = s.charAt(i);
            if (map.keySet().contains(currentCharacter)){
                stack.push(currentCharacter);
            } else if (map.values().contains(currentCharacter)){
                if (!stack.empty() && map.get(stack.peek()) == currentCharacter){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
