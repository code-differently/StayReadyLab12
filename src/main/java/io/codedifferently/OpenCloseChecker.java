package io.codedifferently;

import java.util.HashMap;

public class OpenCloseChecker {

    private Character openChar;

    private Character closingChar;

    private HashMap<Character, Integer> wrapers;

    private boolean rightNumOfClosings(Integer x, Integer y) {

        if (x == y){

             return true;
        }
        return false;
    }

    public boolean symbolChecker (String x){


        wrapers = new HashMap<Character, Integer>();

        wrapers.put(getOpenChar(), 0);
        wrapers.put(getClosingChar(), 0);


        for(int i = 0; i < x.length(); i++) {

            if (wrapers.containsKey(x.charAt(i))){

                wrapers.put(x.charAt(i), wrapers.get(x.charAt(i)) + 1);

            }
        }

        if (getOpenChar() != getClosingChar()) {
            return rightNumOfClosings(wrapers.get(getOpenChar()), wrapers.get(getClosingChar()));
        } else {

           return (wrapers.get(getOpenChar()) % 2 == 0);

        }
    }

    public Character getOpenChar() {
        return openChar;
    }

    public void setOpenChar(Character openChar) {
        this.openChar = openChar;
    }

    public Character getClosingChar() {
        return closingChar;
    }

    public void setClosingChar(Character closingChar) {
        this.closingChar = closingChar;
    }
}
