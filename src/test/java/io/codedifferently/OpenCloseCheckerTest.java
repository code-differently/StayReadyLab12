package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void checkOpenCloseTest(){
        OpenCloseChecker oc = new OpenCloseChecker();

        Assert.assertTrue(oc.checkOpenClose("a(b)c(d)e(f)g"));
    }

    @Test
    public void checkOpenCloseTest2(){
        OpenCloseChecker oc = new OpenCloseChecker();

        Assert.assertFalse(oc.checkOpenClose("a(bc(d)))"));
    }

    @Test
    public void checkOpenCloseTest3(){
        OpenCloseChecker oc = new OpenCloseChecker();

        Assert.assertFalse(oc.checkOpenClose("a(bcd{ef))"));
    }

    @Test
    public void checkOpenCloseTest4(){
        OpenCloseChecker oc = new OpenCloseChecker();

        Assert.assertFalse(oc.checkOpenClose("a(bc<d>))"));
    }

    @Test
    public void checkOpenCloseTest5(){
        OpenCloseChecker oc = new OpenCloseChecker();

        Assert.assertTrue(oc.checkOpenClose("a(b){d}"));
    }

    @Test
    public void checkOpenCloseTest6(){
        OpenCloseChecker oc = new OpenCloseChecker();

        Assert.assertTrue(oc.checkOpenClose("a(b)<c>{d}"));
    }
}