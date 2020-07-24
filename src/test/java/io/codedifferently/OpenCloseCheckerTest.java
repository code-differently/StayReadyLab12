package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest
{

    @Test
    public void testQuotes()
    {
        String s = "bobby\"tarantino\"hehehehe";

        boolean expected = true;
        System.out.println(s);

        Assert.assertEquals(expected, new OpenCloseChecker().simpleChecker(s));
    }

    @Test
    public void testSingleQuotes()
    {
        String s = "bobby\'tarantino\'hehehehe";

        boolean expected = true;
        System.out.println(s);

        Assert.assertEquals(expected, new OpenCloseChecker().simpleChecker(s));
    }

    @Test
    public void testParenth()
    {
        String s = "(bobby(tarantino)hehehehe)";

        boolean expected = true;
        System.out.println(s);

        Assert.assertEquals(expected, new OpenCloseChecker().simpleChecker(s));
    }

    @Test
    public void testTriangle()
    {
        String s = "<ehhehehehe>";
        boolean expected = true;
        System.out.println(s);

        Assert.assertEquals(expected, new OpenCloseChecker().simpleChecker(s));
    }

    @Test
    public void testCurly()
    {
        String s = "{}{}";
        boolean expected = true;
        System.out.println(s);

        Assert.assertEquals(expected, new OpenCloseChecker().simpleChecker(s));
    }
}