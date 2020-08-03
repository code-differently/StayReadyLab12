package io.codedifferently;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenCloseCheckerTest {

    private String givenInput;
    OpenCloseChecker testChecker;
    @Before
    public void setUp() {
        testChecker = new OpenCloseChecker();
        givenInput = "";

    }

    @Test
    public void correctFormatingTest1() {

        givenInput = "a(b)c(d)e(f)g";

        Assert.assertTrue(testChecker.correctFormating(givenInput));


    }

    @Test
    public void correctFormatingTest2() {

        givenInput = "a(bcd(ef))";

        Assert.assertTrue(testChecker.correctFormating(givenInput));
    }

    @Test
    public void correctFormatingTest3() {

        givenInput = ")";

        Assert.assertFalse(testChecker.correctFormating(givenInput));
    }

    @Test
    public void correctFormatingTest4() {

        givenInput = "a(bc(d)))";

        Assert.assertFalse(testChecker.correctFormating(givenInput));
    }




}