package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void checkParenthesisTest(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis("a(b)c(d)e(f)g");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void checkParenthesisTest1(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis("a(bcd(ef))");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void checkParenthesisTest2(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis("a(bc(d)))");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkParenthesisTest3(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis(")");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkParenthesisTest4(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis("()");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void checkParenthesisTest5(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis("()(");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkParenthesisTest6(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis("())");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void checkParenthesisTest7(){
        // Given
        OpenCloseChecker cParenthesis = new OpenCloseChecker();

        // When
        Boolean actual = cParenthesis.checkParenthesis("([)])");

        // Then
        Assert.assertFalse(actual);
    }


}