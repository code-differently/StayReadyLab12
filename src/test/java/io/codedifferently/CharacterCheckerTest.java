package io.codedifferently;
import org.junit.Assert;
import org.junit.Test;

public class CharacterCheckerTest 
{
     @Test    
    public void characterCheckerTest1()
    {
        //Given 
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "a[bc[d]]]";
        //When 
        Boolean actual = openCloseChecker.characterChecker(input, '[', ']');
        Boolean expected = false;
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void characterCheckerTest2()
    {
        //Given 
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "a{bc{d}}}";
        Character opening = '{';
        Character closing = '}';
        //When 
        Boolean actual = openCloseChecker.characterChecker(input, opening, closing);
        Boolean expected = false;
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void characterCheckerTest3 ()
    {
        //Given 
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "a<bcd<ef>>";
        Character opening = '<';
        Character closing = '>';
        //Then 
        Boolean actual = openCloseChecker.characterChecker(input, opening, closing);
        Boolean expected = true;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void specialCaseCheckerTest()
    {
        //Given 
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "\'";
        Character opening = '\'';
        Character closing = '\'';
        //Then 
        Boolean actual = openCloseChecker.specialCaseChecker(input, opening, closing);
        Boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void specialCaseCheckerTest2()
    {
        //Given 
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();
        String input = "\" \" ";
        Character opening = '\"';
        Character closing = '\"';
        Boolean actual = openCloseChecker.specialCaseChecker(input, opening, closing);
        Boolean expected = true;
        Assert.assertEquals(expected, actual);
    }
}