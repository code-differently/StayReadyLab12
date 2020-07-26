package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {
    private Stack<Character> openCloseStack = new Stack<>();
    private char[] opens = {'(', '{', '[', '<', '"', '\''};
    private char[] closes = {')', '}', ']', '>', '"', '\''};

    public boolean parenthesisChecker(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openCloseStack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (!openCloseStack.isEmpty() && openCloseStack.peek() == '(' ) {
                    openCloseStack.pop();
                } else {
                    return false;
                }
            }
        }
        if (openCloseStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean expandedChecker(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (expandedContains(str.charAt(i), opens)) {
                openCloseStack.push(str.charAt(i));
            } else if (expandedContains(str.charAt(i), closes)) {
                if (!openCloseStack.isEmpty() && openCloseStack.peek() == exactCloser(str.charAt(i))) {
                    openCloseStack.pop();
                } else {
                    return false;
                }
            }
        }
        if (openCloseStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean expandedContains(char c, char[] arr) {
        for (Character letter : arr) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    public char exactCloser(char c) {
        if (c == '(') {
            return ')';
        } else if (c == '{') {
            return '}';
        } else if (c == '<') {
            return '>';
        } else if (c == '[') {
            return ']';
        } else if (c == '\'') {
            return '\'';
        } else if (c == '\"') {
            return '\"';
        } else {
            return 'N';
        }
    }
}
