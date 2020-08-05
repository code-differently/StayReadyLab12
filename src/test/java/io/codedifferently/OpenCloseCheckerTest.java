package io.codedifferently;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class OpenCloseCheckerTest {

    @Test
    public void openCloseCheckerTest1(){
        //Given
        String input = "a(b)c(d)e(f)g";

        //Assert
        Assert.assertTrue(OpenCloseChecker.openCloseChecker(input));
    }

    @Test
    public void openCloseCheckerTest2(){
        //Given
        String input = ")";

        //Assert
        Assert.assertFalse(OpenCloseChecker.openCloseChecker(input));
    }

    @Test
    public void openCloseCheckerTest3(){
        //Given
        String input = "a(bc(d)))";

        //Assert
        Assert.assertFalse(OpenCloseChecker.openCloseChecker(input));
    }

    @Test
    public void openCloseCheckerTest4(){
        //Given
        String input = "a(bc(d)})";

        //Assert
        Assert.assertFalse(OpenCloseChecker.openCloseChecker(input));
    }

    @Test
    public void openCloseCheckerTest5(){
        //Given
        String input = "a(bc{d})";

        //Assert
        Assert.assertTrue(OpenCloseChecker.openCloseChecker(input));
    }

    @Test
    public void openCloseCheckerTest6(){
        //Given
        String input = "<a(bc(d))>";

        //Assert
        Assert.assertTrue(OpenCloseChecker.openCloseChecker(input));
    }

    @Test
    public void openCloseCheckerTest7(){
        //Given
        String input = ">";

        //Assert
        Assert.assertFalse(OpenCloseChecker.openCloseChecker(input));
    }

    @Test
    public void openCloseCheckerTest8(){
        //Given
        String input = "[GOAT]";

        //Assert
        Assert.assertTrue(OpenCloseChecker.openCloseChecker(input));
    }

}