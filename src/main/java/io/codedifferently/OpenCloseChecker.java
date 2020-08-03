package io.codedifferently;

import java.util.HashMap;
import java.util.Stack;

public class OpenCloseChecker {


    private Stack<Character> symbolStack;

    public OpenCloseChecker(){

        symbolStack = new Stack<>();
    }

    public boolean correctFormating(String x) {

        String temp = "";
        String match = "";
        x = x.replaceAll("[a-z]", "");

        for(int i = 0; i < x.length(); i++) {

            symbolStack.push(x.charAt(i));
            if(symbolStack.peek() == ')' && symbolStack.size() > 1){
                temp += symbolStack.pop();
                temp += symbolStack.pop();
                if ( !(temp.equals(")(")) ) {

                    return false;
                } else {
                    temp = "";
                }

            } else if(symbolStack.peek() == ']' && symbolStack.size() > 1){

                temp += symbolStack.pop();
                temp += symbolStack.pop();
                if ( !(temp.equals("][")) ) {

                    return false;
                } else {
                    temp = "";
                }
            }else if(symbolStack.peek() == '}' && symbolStack.size() > 1){

                temp += symbolStack.pop();
                temp += symbolStack.pop();
                if ( !(temp.equals("}{")) ) {

                    return false;
                } else {
                    temp = "";
                }
            } else if(symbolStack.peek() == '\'' && symbolStack.size() > 1){

                temp += symbolStack.pop();
                temp += symbolStack.pop();
                if ( !(temp.equals("''")) ) {

                    return false;
                } else {
                    temp = "";
                }
            } else if(symbolStack.peek() == '\"' && symbolStack.size() > 1){

                temp += symbolStack.pop();
                temp += symbolStack.pop();
                if ( !(temp.equals("\"\"")) ) {

                    return false;
                } else {
                    temp = "";
                }
            }else if(symbolStack.peek() == '>' && symbolStack.size() > 1){

                temp += symbolStack.pop();
                temp += symbolStack.pop();
                if ( !(temp.equals("><")) ) {

                    return false;
                } else {
                    temp = "";
                }
            }

        }

        return symbolStack.isEmpty();
    }


}
