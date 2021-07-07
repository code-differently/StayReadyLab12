package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

public class OpenCloseCheckerTest {

    @Test
    public void isBalancedv1_Test1(){
        // Given
        String eyd1 = "(e)(y)(d)";
        String eyd2 = "(EMBRACE)(YO)(DOPENESS)(!)"; // you already know ¯\_(ツ)_/¯
        String noParentheses = "Let's have a jam session!"; //srsly tho, i'm ALWAYS in the mood to vibe out with people
        String randStr = "(()())";
        String nothing = "";

        // When
        boolean actual1 = OpenCloseChecker.isBalancedv1(noParentheses);
        boolean actual2 = OpenCloseChecker.isBalancedv1(nothing);
        boolean actual3 = OpenCloseChecker.isBalancedv1(eyd1);
        boolean actual4 = OpenCloseChecker.isBalancedv1(eyd2);
        boolean actual5 = OpenCloseChecker.isBalancedv1(randStr);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertTrue(actual3);
        Assert.assertTrue(actual4);
        Assert.assertTrue(actual5);
    }

    @Test/*(expected = EmptyStackException.class) --- Don't need because of the try/catch statement in the function*/
    public void isBalancedv1_Test2(){
        // Given
        String randStr1 = "(shama())lama)";     // not balanced
        String randStr2 = "(()()))";            // not balanced
        String randStr3 = "((()())";            // not balanced
        String test1 = ")";
        String test2 = "(";

        // When
        boolean actual1 = OpenCloseChecker.isBalancedv1(randStr1);
        boolean actual2 = OpenCloseChecker.isBalancedv1(randStr2);
        boolean actual3 = OpenCloseChecker.isBalancedv1(randStr3);
        boolean actual4 = OpenCloseChecker.isBalancedv1(test1);
        boolean actual5 = OpenCloseChecker.isBalancedv1(test2);

        // Then
        Assert.assertFalse(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
        Assert.assertFalse(actual4);
        Assert.assertFalse(actual5);
    }

    @Test
    public void isBalancedv2_Test1(){
        // Given
        String eyd1 = "[(e)(y)\"d\"]";
        String eyd2 = "'[EMBRACE]{YO}\"DOPENESS\"(!)'"; // you already know ¯\_(ツ)_/¯
        String randStr1 = "('jam session!')";
        String randStr2 = "()";
        String randStr3 = "[({[]''})]";
        String randStr4 = "''";
        String randStr5 = "[]{}";

        // When
        boolean actual1 = OpenCloseChecker.isBalancedv2(randStr1);
        boolean actual2 = OpenCloseChecker.isBalancedv2(randStr4);
        boolean actual3 = OpenCloseChecker.isBalancedv2(eyd1);
        boolean actual4 = OpenCloseChecker.isBalancedv2(eyd2);
        boolean actual5 = OpenCloseChecker.isBalancedv2(randStr2);
        boolean actual6 = OpenCloseChecker.isBalancedv2(randStr5);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertTrue(actual3);
        Assert.assertTrue(actual4);
        Assert.assertTrue(actual5);
        Assert.assertTrue(actual6);
    }

    @Test/*(expected = EmptyStackException.class) --- Don't need because of the try/catch statement in the function*/
    public void isBalancedv2_Test2(){
        // Given
        String randStr1 = "(sh[])ma}";     // not balanced
        String randStr2 = "({}[])'";            // not balanced
        String randStr3 = "(\")";            // not balanced
        String test1 = ")";
        String test2 = "{";

        // When
        boolean actual1 = OpenCloseChecker.isBalancedv2(randStr1);
        boolean actual2 = OpenCloseChecker.isBalancedv2(randStr2);
        boolean actual3 = OpenCloseChecker.isBalancedv2(randStr3);
        boolean actual4 = OpenCloseChecker.isBalancedv2(test1);
        boolean actual5 = OpenCloseChecker.isBalancedv2(test2);

        // Then
        Assert.assertFalse(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
        Assert.assertFalse(actual4);
        Assert.assertFalse(actual5);
    }
}