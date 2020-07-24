package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {

    //iterate through elements 
    //push an opening parenthiesis onto stack 
    //pop when there is a closing parentheisis 
    //if the stack is empty return true 
    //else false 
    public Boolean parentheisisChecker(String input)
    {
        char[] arry = input.toCharArray();
        
        Stack<Character> stack = new Stack<Character>();
         Boolean isClosed= false;
        for (int i = 0; i < arry.length; i++) 
        {
           if(arry[i]== ')' && stack.isEmpty() == true)
            {
                isClosed = false;
                return isClosed;
            }

            if(arry[i]== '(')
            {
                stack.push(arry[i]);
            }
             
            if(arry[i] == ')'&& stack.isEmpty()== false)
            {
                stack.pop();
            }
            
            
        }
        if (stack.isEmpty()== true) 
        {
            isClosed = true;
        }
        return isClosed;
    }

    //same concept for the other characters 
    public Boolean characterChecker(String input, Character opening, Character closing)
    {
        Stack<Character> stack = new Stack<Character>();
        Boolean isClosed = false;
        for (int i = 0; i < input.length(); i++) 
        {
            if (input.charAt(i) == closing && stack.empty() == true) 
            {
                isClosed = false;
                return isClosed;    
            }
            if(input.charAt(i)== opening)
            {
                stack.push(input.charAt(i));
            }
            if(input.charAt(i) == closing && stack.empty() == false)
            {
                stack.pop();
            }
        }
        if(stack.isEmpty() == true)
        {
            isClosed = true;
        }
        return isClosed;
    }
}
