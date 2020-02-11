package dev.salmonllama.snack;

public class Calculator {

    public static boolean isDouble(String input) {
        try {
            Double.valueOf(input);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public static double drinksTotal(double amt) {
        return Constants.DRINK_PRICE * amt;
    }

    public static double chipsTotal(double amt) {

    }

    public static double subtotal(double drinksAmt, double chipsAmt) {

    }

    public static double calcTax(double drinksAmt, double chipsAmt) {

    }

    public static double grandTotal(double drinksAmt, double chipsAmt) {

    }
}
