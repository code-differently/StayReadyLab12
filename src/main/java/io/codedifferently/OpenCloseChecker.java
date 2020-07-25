package io.codedifferently;

import java.util.Stack;

public class OpenCloseChecker {

    static Stack<Character> stringToStack(String str){
        Stack<Character> words=new Stack<Character>();
        for (Character chr :
            str.toCharArray()) {
            words.push(chr);
        }
        return words;
    }

    static boolean check(String str,Character open,Character close){
        Stack<Character> chars=stringToStack(str);
        boolean isCorrect=false;
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<Character>();
        while (!chars.isEmpty()){
            Character chr=chars.pop();
            if(chr.equals(close))
                right.push(chr);
            if(chr.equals(open))
                left.push(chr);
            if(left.size()>right.size())
                return false;
        }
        if(right.size()<=left.size()){
            while(!right.isEmpty()){
                right.pop();
                left.pop();
            }
            if(left.isEmpty())
                isCorrect=true;
        }

        return isCorrect;
    }

    static boolean expandedChecker(String str){
        boolean parenthesisCheck=check(str,'(',')');
        boolean bracketCheck=check(str,'[',']');
        boolean curlyCheck=check(str,'{','}');
        boolean triangleCheck=check(str,'<','>');
        return parenthesisCheck && bracketCheck && curlyCheck && triangleCheck;
    }

}
