package io.codedifferently;

import java.util.Stack;
import java.util.logging.Logger;

public class OpenCloseChecker {

    private static final Logger log = Logger.getGlobal();

    public boolean closedCheck(String str){
        int count = 0;
        int index = 0;
        char [] l = str.toCharArray();
        char [] o = new char[]{'}', ')', '"', '>','\'', ']'};
        char [] i = new char[]{'{', '(', '"', '>','\'', '['};
        Stack<Character> stack = new Stack<>();

        for(char c : l){
            while(index < o.length) {

                if (c == i[index]) {
                    stack.push(c);
                    count++;
                }
                if (c == o[index] && count > 0 && stack.peek() == i[index]) {
                    stack.pop();
                    count--;
                } else if (c == o[index]) {
                    return false;
                }
                index++;
            }
            index = 0;
        }

        return stack.isEmpty();

    }


    public boolean parenthesisCheck(String str){
        int count = 0;
        char [] l = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : l){
            if(c == '('){
                stack.push(c);
                count++;
            }
            if(c == ')' && count > 0){
                stack.pop();
                count--;
            }
            else if(c == ')'){
                return false;
            }
        }

        return stack.isEmpty();

    }


}
