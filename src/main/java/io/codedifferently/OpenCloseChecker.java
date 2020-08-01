package io.codedifferently;
import java.util.Stack;

public class OpenCloseChecker {
    public Boolean parCheck(String input){ // return true/false at the end of program & takes in string input
        char[] str = input.toCharArray(); ///makes string input into char array
        Stack <Character> stack= new Stack <Character>(); // create stack. Stack means last input shows first, other words inputs in reversed order
        Boolean parClosed = false; // assigned a variable to be false
        for (int i = 0; i < str.length; i++){ // loops through length of char array and each character in it
            if (str[i] == ')' && stack.isEmpty() == true){ // checks if closing parenthesis is first which will automatically be false
                parClosed = false; // reassign to false
                return parClosed;
            }
            if (str[i] == '('){
                stack.push(str[i]); // puts it on top of stack
            }
            if (str[i] == ')' && stack.isEmpty() == false){
                stack.pop(); // removes it from stack
            }
            if (stack.isEmpty() == true){ //checks if empty, if so returns true, else returns false
                parClosed = true;
            }
        }
        return parClosed;
    }
    public boolean specialChecker(String input, Character openChar, Character closedChar){
        char[] str = input.toCharArray(); ///makes string input into char array
        Stack <Character> stack= new Stack <Character>(); // create stack. Stack means last input shows first, other words inputs in reversed order
        Boolean parClosed = false; // assigned a variable to be false
        for (int i = 0; i < str.length; i++){ // loops through length of char array and each character in it
            if (input.charAt(i) == closedChar && stack.isEmpty() == true){ // checks if closing parenthesis is first which will automatically be false
                parClosed = false; // reassign to false
                return parClosed;
            }
            if (input.charAt(i) == openChar){
                stack.push(str[i]); // puts it on top of stack
            }
            if (input.charAt(i) == closedChar && stack.isEmpty() == false){
                stack.pop(); // removes it from stack
            }
            if (stack.isEmpty() == true){ //checks if empty, if so returns true, else returns false
                parClosed = true;
            }
        }
        return parClosed;
    }
}