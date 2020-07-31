package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {

    public String paranBracSquarebracChecker(String str){
        if(str.isEmpty())
        return "Valid";

        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < str.length(); i++)
        {
            char current = str.charAt(i);
            if(current == '{' || current == '(' || current == '[')
            {
                stack.push(current);
            }
            if(current == '}' || current == ')' || current == ']')
            {
                if(stack.isEmpty())
                return "Not valid";
                char last = stack.peek();
                if(current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                stack.pop();
                else 
                return "Not valid";
            }
            
        }
        return stack.isEmpty()?"Valid":"Not valid";
    }
    
    public String anchSingDoubQuoteChecker(String str){
        if(str.isEmpty())
        return "Valid";

        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < str.length(); i++)
        {
            char current = str.charAt(i);
            if(current == '<' || current == '\"'  || current == '\'')
            {
                stack.push(current);
            }
            if(current == '>' || current == '\"' || current == '\'')
            {
                if(stack.isEmpty())
                return "Not valid";
                char last = stack.peek();
                if(current == '>' && last == '<' || current == '\'' && last == '\'' || current == '\"' && last == '\"')
                stack.pop();
                else 
                return "Not valid";
            }
            
        }
        return stack.isEmpty()?"Valid":"Not valid";
    }

}
