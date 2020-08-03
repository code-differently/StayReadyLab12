package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void parentheseCheckerTest01(){
        //Given
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "a(b)c(d)e(f)g";

        //When
        Boolean actual = openCloseChecker.parenthesisChecker(input);

        //Then
        Assert.assertTrue(input,actual);
    }

    @Test
    public void parentheseCheckerTest02(){
        //Given
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = ")";


        //When
        Boolean actual = openCloseChecker.parenthesisChecker(input);

        //Then
        Assert.assertFalse(input,actual);
    }

    @Test
    public void parentheseCheckerTest03(){
        //Given
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "a(bcd(ef))";


        //When
        Boolean actual = openCloseChecker.parenthesisChecker(input);

        //Then
        Assert.assertTrue(input,actual);
    }

    @Test
    public void parentheseCheckerTest04(){
        //Given
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "a(bc(d)))";


        //When
        Boolean actual = openCloseChecker.parenthesisChecker(input);

        //Then
        Assert.assertFalse(input,actual);
    }

}