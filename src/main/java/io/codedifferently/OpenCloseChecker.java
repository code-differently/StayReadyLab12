package io.codedifferently;

import java.util.Stack;

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
     * @return
     *
     */
    public static boolean isBalancedv1(String sntnc){
        boolean isBalanced = true;
        Stack<Character> symbols = new Stack<Character>();  // create new stack to store the opening symbols
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
        if (!symbols.isEmpty()){ isBalanced = false; }            // if symbols isnt empty, set isBalanced to false
        return isBalanced;
    }

    /**
     *
     * @param sntnc - string to check if balanced
     * @return
     *
     * version 2 of isBalanced expands on the functionality
     * to check that all opening characters have a closing one.
     *
     * Characters  include: () {} [] <> "" ''
     *
     *
     */
    public static boolean isBalancedv2(String sntnc){
        boolean isBalanced = true;
        Stack<Character> symbols = new Stack<Character>();  // create new stack to store the opening symbols
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
        if (!symbols.isEmpty()){ isBalanced = false; }
        return isBalanced;
    }

}
