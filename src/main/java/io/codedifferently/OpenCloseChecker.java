package io.codedifferently;

import java.util.HashMap;
import java.util.Stack;

public class OpenCloseChecker
{
    public static void main(String[] args)
    {
        String s = "\'\'";

        System.out.println(simpleChecker(s));
    }

    public static boolean simpleChecker(String sentence)
    {
        //remove all of the bogus letters
        sentence = sentence.replaceAll("[a-zA-z]+","");
        sentence = sentence.replaceAll(" ", "");
        //all combinations of open and closing characters
        HashMap<Character, Character> openClose = new HashMap<Character, Character>();
        openClose.put('(', ')');
        openClose.put('[', ']');
        openClose.put('{','}');
        openClose.put('<','>');
        openClose.put('"','"');
        openClose.put('\'', '\'');

        //since we've regexed the string, if the length is odd
        //then there is an unmatched pair
        if(sentence.length() % 2 != 0)
        {
            return false;
        }

        //travel until openings are found, and compare with the remaining
        //closing matches
        Stack<Character> halfes = new Stack<Character>();

        boolean isOpen = false;
        boolean isClosed = false;
        for(char ch : sentence.toCharArray())
        {

            if(openClose.containsKey(ch))
            {
                halfes.push(openClose.get(ch));
                if(ch == '"' || ch == '\'' && isOpen == false)
                {
                    isOpen = true;
                    halfes.pop();
                }
                else if(ch == '"' || ch == '\'' && isOpen)
                {
                    isClosed = true;
                    halfes.pop();
                }
            }

            else if(isOpen == true && isClosed == true)
            {
                halfes.pop();
            }

            //braces are unbalanced if the char is not at the top of the stack
            //if it's empty, it's definitely not balanced.
            else if(halfes.isEmpty() || ch != halfes.pop())
            {
                return false;
            }
        }

        //this determines the final return value
        return halfes.isEmpty();
    }
}
