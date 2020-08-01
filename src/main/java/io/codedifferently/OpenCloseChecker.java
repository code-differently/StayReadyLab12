package io.codedifferently;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class OpenCloseChecker {

    public boolean openNCloseChecker(String input) {
        HashMap<Character, Character> closeBracketMap = new HashMap<Character, Character>();
        closeBracketMap.put(')', '(');
        closeBracketMap.put(']', '[');
        closeBracketMap.put('}', '{');
        closeBracketMap.put('<', '>');
        closeBracketMap.put('"', '"');
        HashSet<Character> openBracketSet = new HashSet<Character>(
                closeBracketMap.values());
        Stack<Character> stack = new Stack<Character>();

        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (openBracketSet.contains(cur)) {
                stack.push(cur);
            } else { // close brackets
                if (stack.isEmpty()) {
                    return false;
                }
                if (closeBracketMap.get(cur) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();

    }
}