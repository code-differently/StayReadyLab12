package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {
    Stack<Character> stack;
    
    public boolean checkOpenClose(String input){
        stack = new Stack<Character>();

        for(int i = 0; i < input.length(); i++){
            char current = input.charAt(i);

            if(current == '(' || current == '{' ||current == '[' || 
            current == '<' || current == 34 || current == 39)
                stack.push(current);
            else if(current  == ')'){
                if(stack.isEmpty() || stack.pop() != '(')
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
        OpenCloseChecker oc = new OpenCloseChecker();

        System.out.println(oc.checkOpenClose("a(b)c{d}"));
    }
}
