package io.codedifferently;

import static org.junit.Assert.*;
import org.junit.Test;

public class OpenCloseCheckerTest {
    OpenCloseChecker obj = new OpenCloseChecker();

    @Test
    public void parenthesisCheckerTest() {
        String stringToCheck = "a(b)c(d)e(f)g";

        assertTrue(obj.parenthesisChecker(stringToCheck));
    }

    @Test
    public void parenthesisCheckerTest2() {
        String stringToCheck = ")";

        assertFalse(obj.parenthesisChecker(stringToCheck));
    }

    @Test
    public void parenthesisCheckerTest3() {
        String stringToCheck = "a(bcd(ef))";

        assertTrue(obj.parenthesisChecker(stringToCheck));
    }

    @Test
    public void parenthesisCheckerTest4() {
        String stringToCheck = "a(bc(d)))";

        assertFalse(obj.parenthesisChecker(stringToCheck));
    }

    @Test
    public void expandedCheckerTest() {
        String stringToCheck = "a{b}c[d]e<f>g";

        assertTrue(obj.expandedChecker(stringToCheck));
    }

    @Test
    public void expandedCheckerTest2() {
        String stringToCheck = "}";

        assertFalse(obj.expandedChecker(stringToCheck));
    }

    @Test
    public void expandedCheckerTest3() {
        String stringToCheck = "a(bcd{ef})";

        assertTrue(obj.expandedChecker(stringToCheck));
    }

    @Test
    public void expandedCheckerTest4() {
        String stringToCheck = "a{bc[d}]";

        assertFalse(obj.expandedChecker(stringToCheck));
    }

}