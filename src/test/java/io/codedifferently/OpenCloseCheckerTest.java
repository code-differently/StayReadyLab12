package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    public static void main(String[] args) {

    }

    @Test
    public void checkOpenCloseTest(){
        OpenCloseChecker openClose = new OpenCloseChecker();

        Assert.assertTrue(openClose.checkOpenClose("a(b)c(d)e(f)g"));
    }

    @Test
    public void checkOpenCloseTest2(){
        OpenCloseChecker openClose = new OpenCloseChecker();

        Assert.assertFalse(openClose.checkOpenClose("a(bc(d)))"));
    }

    @Test
    public void checkOpenCloseTest3(){
        OpenCloseChecker openClose = new OpenCloseChecker();

        Assert.assertFalse(openClose.checkOpenClose("a(bcd{ef))"));
    }

    @Test
    public void checkOpenCloseTest4(){
        OpenCloseChecker openClose = new OpenCloseChecker();

        Assert.assertFalse(openClose.checkOpenClose(")"));
    }



}