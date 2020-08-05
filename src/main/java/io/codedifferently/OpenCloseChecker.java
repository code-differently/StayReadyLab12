package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {

    public static boolean openCloseChecker(String input){
        Stack<Character> check = new Stack<Character>();

        for(int i=0; i<input.length(); i++){
            char temp = input.charAt(i);

            if(temp == '(' || temp == '{' || temp == '[' || temp == '<' || temp == '"' ){
                check.push(temp);
            }
            if(temp == ')' || temp == '}' || temp == ']' || temp == '>' || temp == '"' ){
                if(check.isEmpty()) {
                    return false;
                }else if(check.peek() == '(' && temp == ')'){
                    check.pop();
                }else if(check.peek() == '{' && temp == '}'){
                    check.pop();
                }else if(check.peek() == '[' && temp == ']'){
                    check.pop();
                }else if(check.peek() == '<' && temp == '>'){
                    check.pop();
                }else if(check.peek() == '"' && temp == '"'){
                    check.pop();
                }else
                    return false;
            }
        }
        return check.isEmpty();
    }
}
