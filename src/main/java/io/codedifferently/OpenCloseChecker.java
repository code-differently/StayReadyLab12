package io.codedifferently;

import java.util.Iterator;
import java.util.Stack;

public class OpenCloseChecker {
    public Stack<Character> addingIntoStack(String sequence){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < sequence.length(); i++){
            stack.add(sequence.charAt(i));
        }
        return stack;
    }

    public boolean expandedCheck(String sequence, Character left, Character right){
        Stack<Character> leftStack = new Stack<Character>();
        Stack<Character> rightStack = new Stack<Character>();
        boolean bool = false;
        Stack<Character> stack = addingIntoStack(sequence);
        while(!stack.isEmpty()){
            Character ch = stack.pop();
            if(ch.equals(left)){
                leftStack.push(ch);
            }
            else if(ch.equals(right)){
                rightStack.push(ch);
            }
            if(leftStack.size() > rightStack.size()) {
                break;
            }
        }
        if(rightStack.size() <= leftStack.size()) {
            while(!rightStack.isEmpty()) {
                rightStack.pop();
                leftStack.pop();
            }
            if (leftStack.isEmpty()) {
                bool = true;
            }
        }
        return bool;
    }

    public String expanded(String sequence){
        String str = "";
        str += "Parenthesis: " + expandedCheck(sequence, '(', ')') + "\n";
        str += "Curly Brace: " + expandedCheck(sequence, '{', '}') + "\n";
        str += "Bracket: " + expandedCheck(sequence, '[', ']') + "\n";
        str += "Triangle bracket: " + expandedCheck(sequence, '<', '>') + "\n";

        return str;
    }


}
