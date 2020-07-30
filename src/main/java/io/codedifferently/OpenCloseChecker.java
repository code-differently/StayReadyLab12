package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {

    public Boolean parenthesisChecker(String input) {

        char[] string = input.toCharArray();
        Stack <Character> stack= new Stack <Character>();
        Boolean parenthesisClosed = false;

        for (int i = 0; i < string.length; i++){
            if (string[i] == ')' && stack.isEmpty() == true){
                parenthesisClosed = false;
                return parenthesisClosed;
            }
            if (string[i] == '('){
                stack.push(string[i]);
            }
            if (string[i] == ')' && stack.isEmpty() == false){
                stack.pop();
            }
            if (stack.isEmpty() == true){
                parenthesisClosed = true;
            }
        }
        return parenthesisClosed;
    }

    public boolean expandedChecker(String input, Character openChar, Character closedChar) {

        Stack<Character> stack = new Stack<Character>();
        Boolean parenthesisClosed = false;

        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i)== openChar && stack.contains(openChar) == true)
            {
                stack.pop();
            }
            if (input.charAt(i) == openChar && stack.contains(openChar) == false)
            {
                stack.push(openChar);
            }
        }
        if (stack.empty() == false)
        {
            parenthesisClosed = true;
        }
        return parenthesisClosed;
    }

}