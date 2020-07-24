package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {
    public boolean parenthCheck(String str){
        boolean noProblem = true;
        int count = 0;
        char[] chrArray = str.toCharArray();
        Stack<Character> chrStack = new Stack<Character>();

        for(Character c : chrArray){
            if(c == '('){
                chrStack.add(c);
            }
            if(c == ')'){
                chrStack.add(c);
            }
        }
        int lcount = 0;
        for(Character d : chrArray){
            if(d==')' && lcount < 1){
                noProblem = false;
                chrStack.pop();
            }
            else if(d=='('){
                lcount += 1;
                chrStack.pop();
            }
            else if(d==')' && lcount >= 1){
                lcount -= 1;
                chrStack.pop();
            }
        }
        return noProblem;
    }

    public boolean curlyCheck(String str){
        boolean noProblem = true;
        int count = 0;
        char[] chrArray = str.toCharArray();
        Stack<Character> chrStack = new Stack<Character>();

        for(Character c : chrArray){
            if(c == '{'){
                chrStack.add(c);
            }
            if(c == '}'){
                chrStack.add(c);
            }
        }
        int lcount = 0;
        for(Character d : chrArray){
            if(d=='}' && lcount < 1){
                noProblem = false;
                chrStack.pop();
            }
            else if(d=='{'){
                lcount += 1;
                chrStack.pop();
            }
            else if(d=='}' && lcount >= 1){
                lcount -= 1;
                chrStack.pop();
            }
        }
        return noProblem;
    }

    public boolean straightyCheck(String str){
        boolean noProblem = true;
        int count = 0;
        char[] chrArray = str.toCharArray();
        Stack<Character> chrStack = new Stack<Character>();

        for(Character c : chrArray){
            if(c == '['){
                chrStack.add(c);
            }
            if(c == ']'){
                chrStack.add(c);
            }
        }
        int lcount = 0;
        for(Character d : chrArray){
            if(d==']' && lcount < 1){
                noProblem = false;
                chrStack.pop();
            }
            else if(d=='['){
                lcount += 1;
                chrStack.pop();
            }
            else if(d==']' && lcount >= 1){
                lcount -= 1;
                chrStack.pop();
            }
        }
        return noProblem;
    }

    public boolean anchorCheck(String str){
        boolean noProblem = true;
        int count = 0;
        char[] chrArray = str.toCharArray();
        Stack<Character> chrStack = new Stack<Character>();

        for(Character c : chrArray){
            if(c == '<'){
                chrStack.add(c);
            }
            if(c == '>'){
                chrStack.add(c);
            }
        }
        int lcount = 0;
        for(Character d : chrArray){
            if(d=='>' && lcount < 1){
                noProblem = false;
                chrStack.pop();
            }
            else if(d=='<'){
                lcount += 1;
                chrStack.pop();
            }
            else if(d=='>' && lcount >= 1){
                lcount -= 1;
                chrStack.pop();
            }
        }
        return noProblem;
    }

    public boolean quoteCheck(String str){
        boolean noProblem = true;
        int count = 0;
        char[] chrArray = str.toCharArray();
        Stack<Character> chrStack = new Stack<Character>();

        for(Character c : chrArray){
            if(c == '\"'){
                chrStack.add(c);
            }
            
        }
        int lcount = 0;
        for(Character d : chrArray){
            if(d=='\"'){
                lcount++;
                chrStack.pop();
            }
        }
        if(lcount % 2 ==0){
            return true;
        }
        return false;
    }

    public boolean singlyQuoteCheck(String str){
        boolean noProblem = true;
        int count = 0;
        char[] chrArray = str.toCharArray();
        Stack<Character> chrStack = new Stack<Character>();

        for(Character c : chrArray){
            if(c == '\''){
                chrStack.add(c);
            }
            
        }
        int lcount = 0;
        for(Character d : chrArray){
            if(d=='\''){
                lcount++;
                chrStack.pop();
            }
        }
        if(lcount % 2 ==0){
            return true;
        }
        return false;
    }

    public boolean allOPCheck(String str){
        if(parenthCheck(str) == false){
            return false;
        }
        else if(curlyCheck(str) == false){
            return false;
        }
        else if(anchorCheck(str) == false){
            return false;
        }
        else if(straightyCheck(str) == false){
            return false;
        }
        else if(quoteCheck(str) == false){
            return false;
        }
        else if(singlyQuoteCheck(str) == false){
            return false;
        }
        else{
            return true;
        }
    }

}
