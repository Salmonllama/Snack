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
        return Constants.CHIP_PRICE * amt;
    }

    public static double subtotal(double drinksAmt, double chipsAmt) {
        return drinksTotal(drinksAmt) + chipsTotal(chipsAmt);
    }

    public static double calcTax(double drinksAmt, double chipsAmt) {
        return Constants.SALES_TAX * subtotal(drinksAmt, chipsAmt);
    }

    public static double grandTotal(double drinksAmt, double chipsAmt) {
        return subtotal(drinksAmt, chipsAmt) + calcTax(drinksAmt, chipsAmt);
    }
}
