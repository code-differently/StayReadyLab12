package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {

    public Boolean checkParenthesis(String input){

        Stack<Character> stack = new Stack<>();

        Boolean answer = false;
        for(int index = 0; index < input.length(); index++){
            if(input.charAt(index) == '(' || input.charAt(index) == '[' || input.charAt(index) == '{' || input.charAt(index) == '<'|| input.charAt(index) == '"'){
                stack.push(input.charAt(index));
            } else if (!stack.empty() && ((input.charAt(index) == ')' && stack.peek() == '(') ||
                                        (input.charAt(index) == ']' && stack.peek() == '[') ||
                                       (input.charAt(index) == '}') && stack.peek() == '{') ||
                                        (input.charAt(index) == '>' && stack.peek() == '<') ||
                                        (input.charAt(index) == '"' && stack.pop() == '"')) {
                stack.pop();
            }
            else if (input.charAt(index) == ')' || input.charAt(index) == ']' || input.charAt(index) == '}' || input.charAt(index) == '>'|| input.charAt(index) == '"'){
                    return answer;
                }
        }

        if(stack.empty()){
            return answer = true;
        }
        else return answer;
    }
}
