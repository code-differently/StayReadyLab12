package io.codedifferently;

import java.beans.SimpleBeanInfo;
import java.util.Stack;

public class OpenCloseChecker {
    Stack<Character> stack;

    public boolean checkOpenClose(String input){
        stack = new Stack<Character>();

        for(int index = 0; index < input.length(); index++){
            char current = input.charAt(index);

            if (current == '(' || current == '{' || current == '[' || current == '<' || current == 2 || current == 24)
                stack.push(current);
            else if(current == ')' ){
               // if(stack.isEmpty() || stack.pop != '(')
                    return false;
            }
            else if(current  == '}'){
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
            else if(current  == ']'){
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
            else if(current  == '>'){
                if(stack.isEmpty() || stack.pop() != '<')
                    return false;
            }
            else if(current  == 34){
                if(stack.isEmpty() || stack.pop() != 34)
                    return false;
            }
            else if(current  == 39){
                if(stack.isEmpty() || stack.pop() != 39)
                    return false;
            }
        }
        return stack.isEmpty();
        }
    public static void main(String[] args){
        OpenCloseChecker openClose = new OpenCloseChecker();

    }

}

