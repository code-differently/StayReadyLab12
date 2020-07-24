package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;

public class OpenCloseCheckerTest {
    @Test
    public void ParanthCheck(){
        //Given
        String str = "sosa )()()";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = false;
        boolean actual = OC.parenthCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ParanthCheck2(){
        //Given
        String str = "sosa ()()";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = true;
        boolean actual = OC.parenthCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void anchorCheck(){
        //Given
        String str = "sosa <><>";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = true;
        boolean actual = OC.anchorCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void staightyCheck(){
        //Given
        String str = "sosa [][]";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = true;
        boolean actual = OC.straightyCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void curlyCheck(){
        //Given
        String str = "sosa {}{}";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = true;
        boolean actual = OC.curlyCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void quoteCheck(){
        //Given
        String str = "sosa \"\"\"";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = false;
        boolean actual = OC.quoteCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void singlyQuoteCheck(){
        //Given
        String str = "sosa ''";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = true;
        boolean actual = OC.singlyQuoteCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void AllOPCheck(){
        //Given
        String str = "sosa >()[]{}\'\'\"\"";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = false;
        boolean actual = OC.allOPCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void AllOPCheck2(){
        //Given
        String str = "sosa <>()[]{}\'\'\"\"";
        OpenCloseChecker OC = new OpenCloseChecker();
        //Then
        boolean expected = true;
        boolean actual = OC.allOPCheck(str);
        //When
        Assert.assertEquals(expected, actual);
    }
}