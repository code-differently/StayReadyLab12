package io.codedifferently;


import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void parenthesisTest(){
        // Given
        String test="a(aknkn)m)mxk)k(jj(jj";
        // When
        boolean actual=OpenCloseChecker.check(test,'(',')');

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void parenthesisTest2(){
        // Given
        String test="a(b)c(d)e(f)g";
        // When
        boolean actual=OpenCloseChecker.check(test,'(',')');

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void curlyBracketTest(){
        // Given
        String test="a{aknkn}m}mxk}k{jj{jj";

        // When
        boolean actual=OpenCloseChecker.check(test,'{','}');

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void curlyBracketTest2(){
        // Given
        String test="a{b}c{d}e{f}g";

        // When
        boolean actual=OpenCloseChecker.check(test,'{','}');

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void curlyBracketTest3(){
        // Given
        String test="{a}{{}}";

        // When
        boolean actual=OpenCloseChecker.check(test,'{','}');

        // Then
        Assert.assertTrue(actual);
    }


    @Test
    public void squareTest(){
        // Given
        String test="[][]]]";

        // When
        boolean actual=OpenCloseChecker.check(test,'[',']');

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void squareTest2(){
        // Given
        String test="[[][][]]";

        // When
        boolean actual=actual=OpenCloseChecker.check(test,'[',']');

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void triangleTest(){
        // Given
        String test="<>>>>>>>>";

        // When
        boolean actual=OpenCloseChecker.check(test,'<','>');

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void triangleTest2(){
        // Given
        String test="<<<<>";

        // When
        boolean actual=OpenCloseChecker.check(test,'<','>');

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void expandedTest(){
        // Given
        String test="[(<<<<{}>>>>)]";

        // When
        boolean actual=OpenCloseChecker.expandedChecker(test);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void expandedTest2(){
        // Given
        String test="[(<<[<<{}>>>>)]";

        // When
        boolean actual=OpenCloseChecker.expandedChecker(test);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void expandedTest3(){
        // Given
        String test="[(<[<<<{}>>}>>)]";

        // When
        boolean actual=OpenCloseChecker.expandedChecker(test);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void expandedTest4(){
        // Given
        String test="([{()}<>{()}])";

        // When
        boolean actual=OpenCloseChecker.expandedChecker(test);

        // Then
        Assert.assertTrue(actual);
    }



}
