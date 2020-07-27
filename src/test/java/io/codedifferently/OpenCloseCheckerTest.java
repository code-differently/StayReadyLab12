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
    public void symbolCheckerTest1 () {

        givenInput = "((xX))";
        testChecker.setOpenChar('(');
        testChecker.setClosingChar(')');
        Assert.assertTrue("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "[[xX]]";
        testChecker.setOpenChar('[');
        testChecker.setClosingChar(']');
        Assert.assertTrue("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "<<xX>>";
        testChecker.setOpenChar('<');
        testChecker.setClosingChar('>');
        Assert.assertTrue("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "{{xX}}";
        testChecker.setOpenChar('{');
        testChecker.setClosingChar('}');
        Assert.assertTrue("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "\"\"xX\"\"";
        testChecker.setOpenChar('"');
        testChecker.setClosingChar('"');
        Assert.assertTrue("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "\'\'xX\'\'";
        testChecker.setOpenChar('\'');
        testChecker.setClosingChar('\'');
        Assert.assertTrue("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));
    }

    @Test
    public void parenthesisCheckerTest2 () {

        givenInput = "((xX)";
        testChecker.setOpenChar('(');
        testChecker.setClosingChar(')');
        Assert.assertFalse("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "[[xX]";
        testChecker.setOpenChar('[');
        testChecker.setClosingChar(']');
        Assert.assertFalse("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "<<xX>";
        testChecker.setOpenChar('<');
        testChecker.setClosingChar('>');
        Assert.assertFalse("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "{{xX}";
        testChecker.setOpenChar('{');
        testChecker.setClosingChar('}');
        Assert.assertFalse("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "\"\"xX\"";
        testChecker.setOpenChar('"');
        testChecker.setClosingChar('"');
        Assert.assertFalse("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));

        givenInput = "\'\'xX\'";
        testChecker.setOpenChar('\'');
        testChecker.setClosingChar('\'');
        Assert.assertFalse("parenthesisChecker returns true test given input is: " + givenInput, testChecker.symbolChecker(givenInput));
    }


}