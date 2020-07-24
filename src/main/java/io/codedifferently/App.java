package io.codedifferently;

public class App
{
    public static void main(String [] args)
    {
       OpenCloseChecker checker = new OpenCloseChecker();
       checker.checkValid("a(b(c)d(ef))");
    }
}