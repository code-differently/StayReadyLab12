package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker 
{
    Stack <Character> check = new Stack<Character>();

    public boolean checkValid(String input)
    {
        for (char holder : input.toCharArray())
        {
            if (isOpen(holder))
            {
                check.push(holder);
            }
            else
            {
                if(check.isEmpty() && isClose(holder)) 
                {
                    System.out.println("input is invalid.");
                    return false;
                }
                else if (!check.isEmpty())
                {
                    char top = (Character)check.peek();
                    if(isOpenandClose(top, holder))
                    {
                        check.pop();
                    }
                }
               
            }
        }

        return isValid();
    }

    private boolean isOpen(Character input)
    {
        if (input == '(' || input == '{' || input == '[' || input == '<' || input == '"' || input == '\'')
        {
            return true;
        }
        return false;
    }

    private boolean isClose(Character input)
    {
        if (input == ')' || input == '}' || input == ']' || input == '>' || input == '"' || input == '\'')
        {
            return true;
        }
        return false;
    }

    private boolean isOpenandClose(Character checkOpen,Character checkClose)
    {
        
        if(checkClose == ')' && checkOpen == '(' || checkClose == '}' && checkOpen == '{' || checkClose == ']' && checkOpen == '[' || checkClose == '>' && checkOpen == '<' || checkClose == '"' && checkOpen == '"' || checkClose == '\'' && checkOpen == '\'')
        {
            return true;
        }
        return false;
    }

    private boolean isValid()
    {
        if (check.isEmpty())
        {
            System.out.println("input is valid ");
            return true;
        }
        else
        {
            System.out.println(" input is invalid "); 
            return false;
        }
    }
}
