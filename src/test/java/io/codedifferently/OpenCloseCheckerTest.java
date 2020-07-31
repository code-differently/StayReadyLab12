package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void paranthesisCheckerTest(){
        //Given 
        String str = "mariam ) () ()";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Not valid";
        String actual = openclose.paranBracSquarebracChecker(str);
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void paranthesisCheckerTest2(){
        //Given 
        String str = "mariam () ()";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Valid";
        String actual = openclose.paranBracSquarebracChecker(str);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bracketCheckerTest(){
        //Given
        String str = "mariam { { {";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Not valid";
        String actual = openclose.paranBracSquarebracChecker(str);
        //Then 
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bracketCheckerTest2(){
        //Given
        String str = "mariam {} {}";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Valid";
        String actual = openclose.paranBracSquarebracChecker(str);
        //Then 
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void squareBracketCheckerTest(){
        //Given 
        String str = "mariam ][";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Not valid";
        String actual = openclose.paranBracSquarebracChecker(str);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void squareBracketCheckerTest2(){
        //Given 
        String str = "mariam []";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Valid";
        String actual = openclose.paranBracSquarebracChecker(str);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void anchorCheckerTest(){
        //Given
        String str = "mariam ><";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Not valid";
        String actual = openclose.anchSingDoubQuoteChecker(str);
        //Then 
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void anchorCheckerTest2(){
        //Given
        String str = "mariam <>";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Valid";
        String actual = openclose.anchSingDoubQuoteChecker(str);
        //Then 
        Assert.assertEquals(expected, actual);
    }

    //Wasnt sure how to test for the invalidity of this
    @Test
    public void SingleQuoteCheckerTest(){
        //Given
        String str = "mariam \'";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Not valid";
        String actual = openclose.anchSingDoubQuoteChecker(str);
        //Then
        Assert.assertEquals(expected, actual);
    }

    //Wasn't sure how to test for the invalidity of this
    @Test
    public void DoubleQuoteCheckerTest(){
        //Given
        String str = "mariam \"";
        OpenCloseChecker openclose = new OpenCloseChecker();
        //When 
        String expected = "Valid";
        String actual = openclose.anchSingDoubQuoteChecker(str);
        //Then
        Assert.assertEquals(expected, actual);
    }

}