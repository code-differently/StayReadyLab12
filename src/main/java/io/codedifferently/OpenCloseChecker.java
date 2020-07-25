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

    static boolean parenthesisChecker(String str){
        Stack<Character> chars=stringToStack(str);
        boolean isCorrect=false;
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<Character>();
        while (!chars.isEmpty()){
            Character chr=chars.pop();
            if(chr.equals(')'))
                right.push(chr);
            if(chr.equals('('))
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

    static boolean curlyBracketChecker(String str){
        Stack<Character> chars=stringToStack(str);
        boolean isCorrect=false;
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<Character>();
        while (!chars.isEmpty()){
            Character chr=chars.pop();
            if(chr.equals('}'))
                right.push(chr);
            if(chr.equals('{'))
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

    static boolean singleQuoteChecker(String str){
        Stack<Character> chars=stringToStack(str);
        boolean isCorrect=false;
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<Character>();
        while (!chars.isEmpty()){
            Character chr=chars.pop();
            if(chr.equals('\'')) {
                right.push(chr);
                left.push(chr);
            }
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

    static boolean quotesChecker(String str){
        Stack<Character> chars=stringToStack(str);
        boolean isCorrect=false;
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<Character>();
        while (!chars.isEmpty()){
            Character chr=chars.pop();
            if(chr.equals('”')) {
                right.push(chr);
                left.push(chr);
            }
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

    static boolean squareBracketChecker(String str){
        Stack<Character> chars=stringToStack(str);
        boolean isCorrect=false;
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<Character>();
        while (!chars.isEmpty()){
            Character chr=chars.pop();
            if(chr.equals(']'))
                right.push(chr);
            if(chr.equals('['))
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

    static boolean triangleBracketChecker(String str){
        Stack<Character> chars=stringToStack(str);
        boolean isCorrect=false;
        Stack<Character> left=new Stack<Character>();
        Stack<Character> right=new Stack<Character>();
        while (!chars.isEmpty()){
            Character chr=chars.pop();
            if(chr.equals('>'))
                right.push(chr);
            if(chr.equals('<'))
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
        return parenthesisChecker(str) && curlyBracketChecker(str) && squareBracketChecker(str) && triangleBracketChecker(str);

    }

}
