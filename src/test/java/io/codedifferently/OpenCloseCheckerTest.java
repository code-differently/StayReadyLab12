package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void openNCloseCheckerTest1(){
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();

        boolean actual = openCloseChecker.openNCloseChecker("a(b)c(d)e(f)g");

        Assert.assertEquals(false,actual);
    }

    @Test
    public void openNCloseCheckerTest2(){
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();

        boolean actual = openCloseChecker.openNCloseChecker(")");

        Assert.assertEquals(false,actual);
    }

    @Test
    public void openNCloseCheckerTest3(){
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();

        boolean actual = openCloseChecker.openNCloseChecker("a(bcd(ef))");

        Assert.assertEquals(false,actual);
    }

    @Test
    public void openNCloseCheckerTest4(){
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();

        boolean actual = openCloseChecker.openNCloseChecker("a(bc(d)))");

        Assert.assertEquals(false,actual);
    }

    @Test
    public void openNCloseCheckerTest5(){
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();

        boolean actual = openCloseChecker.openNCloseChecker("h<e>l<l>0<>");

        Assert.assertEquals(false,actual);
    }

    @Test
    public void openNCloseCheckerTest6(){
        OpenCloseChecker openCloseChecker = new OpenCloseChecker();

        boolean actual = openCloseChecker.openNCloseChecker("{grebtrshythb}");

        Assert.assertEquals(false,actual);
    }

}