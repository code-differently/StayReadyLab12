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

}