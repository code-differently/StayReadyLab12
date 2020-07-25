package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {
    @Test
    public void parenthesisCheckerTest(){
        //Given
        boolean expected = false;

        //When
        OpenCloseChecker checker = new OpenCloseChecker();
        boolean actual = checker.expandedCheck("a(aknkn)m)mxk)k(jj(jj", '(', ')');
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void curlyBraceCheckerTest(){
        //Given
        boolean expected = false;

        //When
        OpenCloseChecker checker = new OpenCloseChecker();
        boolean actual = checker.expandedCheck("a{aknkn}m}mxk}k{jj{jj", '{', '}');
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void bracketCheckerTest(){
        //Given
        boolean expected = false;

        //When
        OpenCloseChecker checker = new OpenCloseChecker();
        boolean actual = checker.expandedCheck("a[aknkn]m]mxk]k[jj[jj", '[', ']');
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void triangleBracketCheckerTest(){
        //Given
        boolean expected = false;

        //When
        OpenCloseChecker checker = new OpenCloseChecker();
        boolean actual = checker.expandedCheck("a<aknkn>m>mxk>k<jj<jj", '<', '>');
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void expandedTest(){
        //Given
        String expected =
                "Parenthesis: true\n" +
                "Curly Brace: true\n" +
                "Bracket: false\n" +
                "Triangle bracket: false\n";
        //When
        OpenCloseChecker checker = new OpenCloseChecker();
        String actual = checker.expanded("a<(aknkn)m(mxk)k{jj}[[[]]jj");

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void expandedTest1(){
        //Given
        String expected =
                "Parenthesis: true\n" +
                        "Curly Brace: true\n" +
                        "Bracket: true\n" +
                        "Triangle bracket: true\n";
        //When
        OpenCloseChecker checker = new OpenCloseChecker();
        String actual = checker.expanded("<a>(aknkn)m{mxkkjj}[[[]]]jj");

        //Then
        Assert.assertEquals(expected, actual);
    }



}