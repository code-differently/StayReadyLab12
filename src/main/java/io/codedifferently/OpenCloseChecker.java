package io.codedifferently;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * LOGIC: 1. All opening symbols are pushed to the stack.
 *        2. If come across closing symbol, check top of stack
 *        for the most recent opening symbol.
 *        3. If symbols don't coorespond to each other (match),
 *        then RETURN FALSE.
 *        4. If you get to the end of sntnc and the stack isn't empty,
 *        then that means there's an opening symbol that wasn't matched,
 *        so RETURN FALSE.
 */
public class OpenCloseChecker {


    /**
     *
     * @param sntnc - string to check if balanced
     * @return - TRUE if sntnc is a balanced string, otherwise FALSE
     *
     * version 1 of isBalanced() simply checks if the string,
     * sntnc, is a balanced string, that is,
     * for every opening character (in this case parentheses),
     * there is a cooresponding closing character.
     *
     */
    public static boolean isBalancedv1(String sntnc){
        boolean isBalanced = true;
        Stack<Character> symbols = new Stack<Character>();              // create new stack to store the opening symbols
        try {
            for (Character currChar : sntnc.toCharArray()){     // iter-ing thru every char in sntnc
                if (currChar.equals('(')){                      // if currChar is opening symbol, push to symbols
                    symbols.push(currChar);
                }
                else if (currChar.equals(')')){                 // if currChar is closing symbol,
                    if (!symbols.pop().equals('(')){            // yet the most recent opening symbol doesnt match, set isBalanced to false
                        isBalanced = false;
                    }
                }
            }
        } catch (EmptyStackException e){
            System.out.println("Ooooopp Thats a No No!\nTrying to pop from an empty stack... no no boo boo!");
            isBalanced = false;
        }
        if (!symbols.isEmpty()){ isBalanced = false; }            // if symbols isnt empty, set isBalanced to false
        return isBalanced;
    }

    /**
     *
     * @param sntnc - string to check if balanced
     * @return - TRUE if sntnc is a balanced string, otherwise FALSE
     *
     * version 2 of isBalanced() expands on the functionality of version 1
     * to check that all opening characters have a closing one.
     *
     * Characters  include: () {} [] <> "" ''
     */
    public static boolean isBalancedv2(String sntnc){
        boolean isBalanced = true;
        Stack<Character> symbols = new Stack<Character>();  // create new stack to store the opening symbols
        try{

            for (Character currChar : sntnc.toCharArray()){     // iter-ing thru every char in sntnc
                if (currChar.equals('(')){                      // if currChar is opening symbol, push to symbols
                    symbols.push(currChar);
                } else if (currChar.equals(')')){                 // if currChar is closing symbol,
                    if (!symbols.pop().equals('(')){            // yet the most recent opening symbol doesnt match, set isBalanced to false
                        isBalanced = false;
                    }
                } else if (currChar.equals('{')){
                    symbols.push(currChar);
                } else if (currChar.equals('}')){
                    if (!symbols.pop().equals('{')){
                        isBalanced = false;
                    }
                } else if (currChar.equals('[')){
                    symbols.push(currChar);
                } else if (currChar.equals(']')){
                    if (!symbols.pop().equals('[')){
                        isBalanced = false;
                    }
                } else if (currChar.equals('"') && !symbols.contains('"')){     // if currChar is quotation and symbol DOESN'T have a quotation already
                    symbols.push(currChar);
                } else if (currChar.equals('"') && symbols.contains('"')){      // if currChar is quotation and symbol DOES have a quotation already
                    if (!symbols.pop().equals('"'))
                        isBalanced = false;
                } else if (currChar.equals('\'') && !symbols.contains('\'')){     // if currChar is quotation and symbol DOESN'T have a quotation already
                    symbols.push(currChar);
                } else if (currChar.equals('\'') && symbols.contains('\'')){      // if currChar is quotation and symbol DOES have a quotation already
                    if (!symbols.pop().equals('\'')){
                        isBalanced = false;
                    }
                }
            }

        } catch (EmptyStackException e){

            System.out.println("Ooooopp Thats a No No!\nTrying to pop from an empty stack... no no boo boo!");
            isBalanced = false;

        }

        if (!symbols.isEmpty()){ isBalanced = false; }
        return isBalanced;
    }

    /**
     *
     * @param someFile - file to check if balanced
     * @return - TRUE if someFile is balanced, otherwise FALSE
     *
     * version 3 of isBalanced() expands on the
     * functionality of version 2 to take in a file
     * as an argument and check if the file is balanced.
     *
     * Characters  include: () {} [] <> "" ''
     *
     * TODO: implement reading text file version 
     *
     */
    public static boolean isBalancedv3(File someFile) {
          boolean isBalanced = true;
//        Stack<Character> symbols = new Stack<Character>();  // create new stack to store the opening symbols
//        Scanner scnr = null;
//        try {
//            scnr = new Scanner(someFile);
//        } catch (FileNotFoundException fnfe) {
//            System.out.println("Couldn't find file:" + someFile.toString());
//        }
//
//        while (scnr.hasNext()) {
//            String word = scnr.next();
//            try {
//                for (Character currChar : word.toCharArray()) {     // iter-ing thru every char in sntnc
//                    if (currChar.equals('(')) {                      // if currChar is opening symbol, push to symbols
//                        symbols.push(currChar);
//                    } else if (currChar.equals(')')) {                 // if currChar is closing symbol,
//                        if (!symbols.pop().equals('(')) {            // yet the most recent opening symbol doesnt match, set isBalanced to false
//                            isBalanced = false;
//                        }
//                    } else if (currChar.equals('{')) {
//                        symbols.push(currChar);
//                    } else if (currChar.equals('}')) {
//                        if (!symbols.pop().equals('{')) {
//                            isBalanced = false;
//                        }
//                    } else if (currChar.equals('[')) {
//                        symbols.push(currChar);
//                    } else if (currChar.equals(']')) {
//                        if (!symbols.pop().equals('[')) {
//                            isBalanced = false;
//                        }
//                    } else if (currChar.equals('"') && !symbols.contains('"')) {     // if currChar is quotation and symbol DOESN'T have a quotation already
//                        symbols.push(currChar);
//                    } else if (currChar.equals('"') && symbols.contains('"')) {      // if currChar is quotation and symbol DOES have a quotation already
//                        if (!symbols.pop().equals('"'))
//                            isBalanced = false;
//                    } else if (currChar.equals('\'') && !symbols.contains('\'')) {     // if currChar is quotation and symbol DOESN'T have a quotation already
//                        symbols.push(currChar);
//                    } else if (currChar.equals('\'') && symbols.contains('\'')) {      // if currChar is quotation and symbol DOES have a quotation already
//                        if (!symbols.pop().equals('\'')) {
//                            isBalanced = false;
//                        }
//                    }
//                }
//
//            } catch (EmptyStackException e) {
//
//                System.out.println("Ooooopp Thats a No No!\nTrying to pop from an empty stack... no no boo boo!");
//                isBalanced = false;
//
//            }
//        }
//
//        if (!symbols.isEmpty()) {
//            isBalanced = false;
//        }
        return isBalanced;
    }

    public static void main(String[] args) throws IOException {
//        String s = "(EYD))";
//        System.out.println(isBalancedv1(s));
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;                                                // Our string variable
        while ((line = in.readLine()) != null) {                    // as long as the line of the text isn't null...
            boolean isBalanced = true;
            Stack<Character> symbols = new Stack<Character>();              // create new stack to store the opening symbols
            try{

                for (Character currChar : line.toCharArray()){      // iterating thru every char in sntnc
                    if (currChar.equals('(')){                      // if currChar is opening symbol, push to symbols
                        symbols.push(currChar);
                    } else if (currChar.equals(')')){               // if currChar is closing symbol...
                        if (!symbols.pop().equals('(')){            // ...yet the most recent opening symbol doesnt match, set isBalanced to false
                            isBalanced = false;
                        }
                    } else if (currChar.equals('{')){               // if currChar is opening symbol, push to symbols
                        symbols.push(currChar);
                    } else if (currChar.equals('}')){               // if currChar is closing symbol...
                        if (!symbols.pop().equals('{')){            // ...yet the most recent opening symbol doesnt match, set isBalanced to false
                            isBalanced = false;
                        }
                    } else if (currChar.equals('[')){               // if currChar is opening symbol, push to symbols
                        symbols.push(currChar);
                    } else if (currChar.equals(']')){               // if currChar is closing symbol...
                        if (!symbols.pop().equals('[')){            // ...yet the most recent opening symbol doesnt match, set isBalanced to false
                            isBalanced = false;
                        }
                    } else if (currChar.equals('"') && !symbols.contains('"')){     // if currChar is quotation and symbol DOESN'T have a quotation already
                        symbols.push(currChar);
                    } else if (currChar.equals('"') && symbols.contains('"')){      // if currChar is quotation and symbol DOES have a quotation already
                        if (!symbols.pop().equals('"'))
                            isBalanced = false;
                    } else if (currChar.equals('\'') && !symbols.contains('\'')){     // if currChar is quotation and symbol DOESN'T have a quotation already
                        symbols.push(currChar);
                    } else if (currChar.equals('\'') && symbols.contains('\'')){      // if currChar is quotation and symbol DOES have a quotation already
                        if (!symbols.pop().equals('\'')){
                            isBalanced = false;
                        }
                    }
                }

            } catch (EmptyStackException e){                       // try - catch statement because of possible EmptyStackException

                System.out.println("Ooooopp Thats a No No!\nTrying to pop from an empty stack... no no boo boo!");
                isBalanced = false;

            }

            if (!symbols.isEmpty()){ isBalanced = false; }
            System.out.println(isBalanced);
        }
    }

    /**
     * Iterate through each line of input.
     *
     * LOGIC:
     * Step #1. Read the input and save the current line to a string variable, 'line'
     * Step #2. Create a stack variable (symbols) to hold the order of characters
     *          and set a boolean variable (isBalanced) to true. 'isBalanced' determines if each line is "well-formed" or not
     * Step #3. Iterate through line getting each character
     * Step #4. If the current character in line is an opening character, then push the character into the stack variable.
     *          The stack variable will keep track of the order of the characters.
     *          (For example, from the string "([])", the stack will first store '(' then the '[',
     *          with the '[' being the character at the top of the stack).
     * Step #5. Else if the character is a closing character,
     *          then compare the character at the top of the stack to the current character.
     *          If the characters do not coorespond to each other
     *          (e.g. a '(' cooresponds to a ')', a '(' does notcooresponds to a ']' ),
     *          then isBalanced gets set to false, otherwise it stays true
     * Step #6. Also, if there are more opening characters than closing ones or vice versa, then
     *          set 'isBalanced' to false
     */
}
