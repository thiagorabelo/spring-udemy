package exp_01.converters;

import exp_01.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convertToDouble(String number) throws UnsupportedMathOperationException {
        if (number == null || number.isEmpty()) {
            throw new UnsupportedMathOperationException("Set a numeric value");
        }
        number = number.replace(",", ".");
        return Double.parseDouble(number);
    }
    
    public static boolean isNumeric(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        String num = number.replace(",", ".");
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
