package org.homework;

import org.homework.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleNumberToWords {

    public DoubleNumberToWords() {}

    public static String toString(double number) {
        if (Double.isNaN(number)) {
            throw new IllegalArgumentException("Invalid number: NaN");
        }

        if (Double.isInfinite(number)) {
            throw new IllegalArgumentException("Number is too large or too small: Infinity");
        }

        if (Math.abs(number) > 999_999_999.99) {
            throw new IllegalArgumentException("Number out of allowed range [-999999999.99 .. 999999999.99]");
        }

        boolean isNegative = number < 0;
        number = Math.abs(number);

        BigDecimal bd = new BigDecimal(String.valueOf(number)).setScale(2, RoundingMode.DOWN);

        int integerPart = bd.intValue();
        int fractionalPart = bd.remainder(BigDecimal.ONE).movePointRight(2).intValue();

        StringBuilder result = new StringBuilder();

        if (isNegative) {
            result.append("минус ");
        }

        result.append(IntNumberToWords.toString(integerPart, IntNumberToWords.Gender.MASCULINE).toLowerCase());
        result.append(" целых ");
        result.append(IntNumberToWords.toString(fractionalPart, IntNumberToWords.Gender.FEMININE).toLowerCase());
        result.append(" ").append(NumberUtil.getFractionalForm(fractionalPart));

        return NumberUtil.capitalizeFirst(result.toString().trim());
    }
}
