package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void parenthesisCheckTest(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = true;
        Assert.assertEquals(expected, occ.parenthesisCheck("a(b)c(d)e(f)g"));
    }

    @Test
    public void parenthesisCheck2Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.parenthesisCheck(")"));
    }

    @Test
    public void parenthesisCheck3Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = true;
        Assert.assertEquals(expected, occ.parenthesisCheck("a(bcd(ef))"));
    }

    @Test
    public void parenthesisCheck4Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.parenthesisCheck("a(bc(d)))"));
    }

    @Test
    public void parenthesisCheck5Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.parenthesisCheck("))"));
    }

    @Test
    public void parenthesisCheck6Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = true;
        Assert.assertEquals(expected, occ.parenthesisCheck(" "));
    }

    @Test
    public void closedCheckTest(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = true;
        Assert.assertEquals(expected, occ.closedCheck("a(b)c(d)e(f)g"));
    }

    @Test
    public void closedCheck2Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.closedCheck(")"));
    }

    @Test
    public void closedCheck3Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = true;
        Assert.assertEquals(expected, occ.closedCheck("a(bcd(ef))"));
    }
    @Test
    public void closedCheck4Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.closedCheck("a(bc(d)))"));
    }

    @Test
    public void closedCheck5Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.closedCheck("))"));
    }

    @Test
    public void closedCheck6Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.closedCheck("(((())"));
    }

    @Test
    public void closedCheck7Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = true;
        Assert.assertEquals(expected, occ.closedCheck("({<\"'[]'\">})"));
    }

    @Test
    public void closedCheck8Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.closedCheck("<[{(\"'\"'>}])"));
    }

    @Test
    public void closedCheck9Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.closedCheck("()}"));
    }

    @Test
    public void closedCheck10Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = false;
        Assert.assertEquals(expected, occ.closedCheck("(}"));
    }
    @Test
    public void closedCheck11Test(){
        OpenCloseChecker occ = new OpenCloseChecker();
        boolean expected = true;
        Assert.assertEquals(expected, occ.parenthesisCheck(" "));
    }
}