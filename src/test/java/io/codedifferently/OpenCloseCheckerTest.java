package io.codedifferently;

import org.junit.Test;
import org.junit.Assert;

public class OpenCloseCheckerTest {

    @Test
    public void parenthesisChecker1(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(b)c(d)e(f)g";
        Boolean expected = true;

        //When
        Boolean actual = ocp.parenthesisChecker(input);
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parenthesisChecker2(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = ")";
        Boolean expected = false;

        //When
        Boolean actual = ocp.parenthesisChecker(input);
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parenthesisChecker3(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(bcd(ef))";
        Boolean expected = true;

        //When
        Boolean actual = ocp.parenthesisChecker(input);
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parenthesisChecker4(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(bc(d)))";
        Boolean expected = false;

        //When
        Boolean actual = ocp.parenthesisChecker(input);
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void specialCharacterChecker1(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a{b}c{d}e{f}g";
        Character openChar = '{';
        Character closedChar = '}';
        Boolean expected = true;

        //When
        Boolean actual = ocp.expandedChecker(input, '{', '}');
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void specialCharacterChecker2(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a[b]c[d]e[f]g";
        Character openChar = '[';
        Character closedChar = ']';
        Boolean expected = true;

        //When
        Boolean actual = ocp.expandedChecker(input, '[', ']');
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void specialCharacterChecker3(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a<b>c<d>e<f>g";
        Character openChar = '<';
        Character closedChar = '>';
        Boolean expected = true;

        //When
        Boolean actual = ocp.expandedChecker(input, '<', '>');
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void specialCharacterChecker4(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(bc(d)))";
        Character openChar = '"';
        Character closedChar = '"';
        Boolean expected = false;

        //When
        Boolean actual = ocp.expandedChecker(input, '"', '"');
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }
}