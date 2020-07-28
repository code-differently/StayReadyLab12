package io.codedifferently;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenCloseCheckerTest {
    OpenCloseChecker checker;

    @Before
    public void setup() {
        checker = new OpenCloseChecker();
    }

    @Test
    public void parenthesisAreNotPairedTest() {
        boolean expectedAnswer = false;

        String input = "a(bc(d)))";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void parenthesisArePairedTest() {
        boolean expectedAnswer = true;

        String input = "a(b)c(d)e(f)g";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getCheckerTest() {
        int expectedSize = 0;

        int actualSize = checker.getChecker().size();

        Assert.assertEquals(expectedSize, actualSize);
    }
}