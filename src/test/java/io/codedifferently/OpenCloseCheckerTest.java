package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {

    @Test
    public void hasCloseTest(){
        // Given
        OpenCloseChecker o = new OpenCloseChecker();
        String s = "a(b)c(d)e(f)g";
        // When
        Boolean actual = o.hasClose(s);
        // Then
        Assert.assertEquals(false, actual);
    }


    @Test
    public void hasCloseTest02(){
        // Given
        OpenCloseChecker o = new OpenCloseChecker();
        String s = ")";
        // When
        Boolean actual = o.hasClose(s);
        // Then
        Assert.assertEquals(false, actual);
    }

    @Test
    public void hasCloseTest03(){
        // Givem
        OpenCloseChecker o = new OpenCloseChecker();
        String s = "a(bcd(ef))";
        // When
        Boolean actual = o.hasClose(s);
        // Then
        Assert.assertEquals(true, actual);
    }

    @Test
    public void hasCloseTest04(){
        // Givem
        OpenCloseChecker o = new OpenCloseChecker();
        String s = "a(bc(d)))";
        // When
        Boolean actual = o.hasClose(s);
        // Then
        Assert.assertEquals(false, actual);
    }

    @Test
    public void hasCloseTest05(){
        // Givem
        OpenCloseChecker o = new OpenCloseChecker();
        String s = "{(a(bc(d)))}";
        // When
        Boolean actual = o.hasClose(s);
        // Then
        Assert.assertEquals(true, actual);
    }

    @Test
    public void hasCloseTest06(){
        // Givem
        OpenCloseChecker o = new OpenCloseChecker();
        String s = "{}<>";
        // When
        Boolean actual = o.hasClose(s);
        // Then
        Assert.assertEquals(true, actual);
    }

}