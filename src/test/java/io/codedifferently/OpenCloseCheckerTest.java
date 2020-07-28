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
    public void bracketsAreNotPairedTest() {
        boolean expectedAnswer = false;

        String input = "a{bc}d}";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void bracketsArePairedTest() {
        boolean expectedAnswer = true;

        String input = "a{}{}{{}}";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void squareBracketsAreNotPairedTest() {
        boolean expectedAnswer = false;

        String input = "a[b[c]d";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void squareBracketsArePairedTest() {
        boolean expectedAnswer = true;

        String input = "a[][]";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void LessThanGreaterThanAreNotPairedTest() {
        boolean expectedAnswer = false;

        String input = "a<<<>>d";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void LessThanGreaterThanArePairedTest() {
        boolean expectedAnswer = true;

        String input = "<>abcd<>";
        boolean actualAnswer = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void singleQuotationMarksFailTest() {
        boolean expected = false;
        String input = "''abcre[{'";

        boolean actual = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singleQuotationMarksSuccessTest() {
        boolean expected = true;
        String input = "[{']]'}]";

        boolean actual = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doubleQuotationMarksFailTest() {
        boolean expected = false;
        String input = "\"\"\"";

        boolean actual = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doubleQuotationMarksSuccessTest() {
        boolean expected = true;
        String input = "\"asgdare[][]\"";

        boolean actual = checker.checkIfCharactersArePaired(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCheckerTest() {
        int expectedSize = 0;

        int actualSize = checker.getChecker().size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getNumOfSingleQuotes() {
        int expected = 0;

        int actual = checker.getNumOfSingleQuotes();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNumOfSingleQuotes() {
        int expected = 3;

        checker.setNumOfSingleQuotes(3);
        int actual = checker.getNumOfSingleQuotes();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumOfDoubleQuotes() {
        int expected = 0;

        int actual = checker.getNumOfDoubleQuotes();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNumOfDoubleQuotes() {
        int expected = 4;

        checker.setNumOfDoubleQuotes(4);
        int actual = checker.getNumOfDoubleQuotes();

        Assert.assertEquals(expected, actual);
    }
}