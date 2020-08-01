package io.codedifferently;
import org.junit.Test;
import org.junit.Assert;

public class OpenCloseCheckerTest {

    @Test
    public void parCheck1(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(b)c(d)e(f)g";
        Boolean expected = true;
        //When
        Boolean actual = ocp.parCheck(input);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void parCheck2(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = ")";
        Boolean expected = false;
        //When
        Boolean actual = ocp.parCheck(input);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void parCheck3(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(bcd(ef))";
        Boolean expected = true;
        //When
        Boolean actual = ocp.parCheck(input);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void parCheck4(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(bc(d)))";
        Boolean expected = false;
        //When
        Boolean actual = ocp.parCheck(input);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void specialCheck1(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a{b}c{d}e{f}g";
        Character openChar = '{';
        Character closedChar = '}';
        Boolean expected = true;
        //When
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void specialCheck2(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a[b]c[d]e[f]g";
        Character openChar = '[';
        Character closedChar = ']';
        Boolean expected = true;
        //When
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void specialCheck3(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a<b>c<d>e<f>g";
        Character openChar = '<';
        Character closedChar = '>';
        Boolean expected = true;
        //When
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void specialCheck4(){
        //Given
        OpenCloseChecker ocp = new OpenCloseChecker();
        String input = "a(bc(d)))";
        Character openChar = '(';
        Character closedChar = ')';
        Boolean expected = false;
        //When
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected, actual);
    }
}