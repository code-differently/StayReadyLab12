package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void paretheisisCheckerTest()
    {
        //Given 
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "a(bc(d)))";
        //When 
        Boolean actual = openCloseChecker.parentheisisChecker(input);
        Boolean expected = false;
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void parentheisisCheckerTest2()
    {
         //Given 
         OpenCloseChecker openCloseChecker = new OpenCloseChecker();
         String input = ")";
         //When 
         Boolean actual = openCloseChecker.parentheisisChecker(input);
         Boolean expected = false;
         //Then
         Assert.assertEquals(expected, actual);
    }
    @Test
    public void parentheisisCheckerTest3()
    {
         //Given 
         OpenCloseChecker openCloseChecker = new OpenCloseChecker();
         String input = "a(b)c(d)e(f)g";
         //When 
         Boolean actual = openCloseChecker.parentheisisChecker(input);
         Boolean expected = true;
         //Then
         Assert.assertEquals(expected, actual);
    }
    @Test
    public void parentheisisCheckerTest4()
    {
         //Given 
         OpenCloseChecker openCloseChecker = new OpenCloseChecker();
         String input = "a(bcd(ef))";
         //When 
         Boolean actual = openCloseChecker.parentheisisChecker(input);
         Boolean expected = true;
         //Then
         Assert.assertEquals(expected, actual);
    }

}