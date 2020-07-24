package io.codedifferently;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenCloseCheckerTest {

    OpenCloseChecker occ;
    @Before
    public void initialize() {
        occ = new OpenCloseChecker();
    }

    @Test
    public void parenthesisCheckerTest1() {
        // Given
        String input = "a(b)c(d)e(f)g";

        // When
        boolean actual = occ.parenthesisChecker(input);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void parenthesisCheckerTest2() {
        // Given
        String input = ")";

        // When
        boolean actual = occ.parenthesisChecker(input);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void parenthesisCheckerTest3() {
        // Given
        String input = "a(bcd(ef))";

        // When
        boolean actual = occ.parenthesisChecker(input);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void parenthesisCheckerTest4() {
        // Given
        String input = "a(bc(d)))";

        // When
        boolean actual = occ.parenthesisChecker(input);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void parenthesisCheckerTest5() {
        // Given
        String input = "a)bcd(ef)(";

        // When
        boolean actual = occ.parenthesisChecker(input);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void characterCheckerTest1() {
        // Given
        String input = "a{b}c{d}e{f}g";

        // When
        boolean actual = occ.characterChecker(input, '{', '}');

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void characterCheckerTest2() {
        // Given
        String input = "[";

        // When
        boolean actual = occ.characterChecker(input, '[', ']');

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void characterCheckerTest3() {
        // Given
        String input = "a<bcd<ef>>";

        // When
        boolean actual = occ.characterChecker(input, '<', '>');

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void characterCheckerTest4() {
        // Given
        String input = "a\"bc\"d\"\"\"";

        // When
        boolean actual = occ.characterChecker(input, '"', '"');

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void characterCheckerTest5() {
        // Given
        String input = "a'bcd'ef''";

        // When
        boolean actual = occ.characterChecker(input, '\'', '\'');

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void expandedCheckerTest1() {
        // Given
        String input = "a(b)c{d}e[f]g";

        // When
        boolean actual = occ.expandedChecker(input);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void expandedCheckerTest2() {
        // Given
        String input = ">";

        // When
        boolean actual = occ.expandedChecker(input);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void expandedCheckerTest3() {
        // Given
        String input = "a{bcd(ef)}";

        // When
        boolean actual = occ.expandedChecker(input);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void expandedCheckerTest4() {
        // Given
        String input = "a{bc\"d')}";

        // When
        boolean actual = occ.expandedChecker(input);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void expandedCheckerTest5() {
        // Given
        String input = "a>bcd'ef<'";

        // When
        boolean actual = occ.expandedChecker(input);

        // Then
        Assert.assertFalse(actual);
    }

}