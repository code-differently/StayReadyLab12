package io.codedifferently;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
public class OpenCloseCheckerTest {
    
   
   OpenCloseChecker ocp;
   @Before 
   public void setUp(){
   this.ocp =  new OpenCloseChecker();
    }
    
    @Test
    public void parCheck1(){
        
        String input = "a(b)c(d)e(f)g";
        
        Boolean actual = ocp.parCheck(input);
        
        Assert.assertTrue(actual);
    }
    @Test
    public void parCheck2(){
       
        String input = ")";
        
        Boolean actual = ocp.parCheck(input);
        
        Assert.assertFalse(actual);
    }
    @Test
    public void parCheck3(){
  
        String input = "a(bcd(ef))";
       
        Boolean actual = ocp.parCheck(input);
       
        Assert.assertTrue(actual);
    }
    @Test
    public void parCheck4(){
       
        String input = "a(bc(d)))";
      
        Boolean actual = ocp.parCheck(input);
        
        Assert.assertFalse(actual);
    }
    @Test
    public void specialCheck1(){
        
        String input = "a{b}c{d}e{f}g";
        Character openChar = '{';
        Character closedChar = '}';
        
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
      
        Assert.assertTrue(actual);
    }
    @Test
    public void specialCheck2(){
     
        String input = "a[b]c[d]e[f]g";
        Character openChar = '[';
        Character closedChar = ']';
        
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
        
        Assert.assertTrue(actual);
    }
    @Test
    public void specialCheck3(){
 
        String input = "a<b>c<d>e<f>g";
        Character openChar = '<';
        Character closedChar = '>';
      
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
       
        Assert.assertTrue(actual);
    }
    @Test
    public void specialCheck4(){
        
        String input = "a(bc(d)))";
        Character openChar = '(';
        Character closedChar = ')';
       
        Boolean actual = ocp.specialChecker(input, openChar, closedChar);
       
        Assert.assertFalse(actual);
    }
}
