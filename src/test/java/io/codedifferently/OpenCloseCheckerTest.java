package io.codedifferently;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
public class OpenCloseCheckerTest 
{
    OpenCloseChecker ocCheck;
    @Before
    public void initialize()
    {
        ocCheck = new OpenCloseChecker();
    }

    @Test
    public void checkTest1()
    {
        assertTrue(ocCheck.checkValid("(is) (this){legit}"));
    }

    @Test
    public void checkTest2()
    {
        assertFalse(ocCheck.checkValid(")"));
    }

    @Test
    public void checkTest3()
    {
        assertTrue(ocCheck.checkValid("a(bcd(ef))"));
    }

    @Test
    public void checkTest4()
    {
        assertFalse(ocCheck.checkValid("a(bc(d)))"));
    }

}