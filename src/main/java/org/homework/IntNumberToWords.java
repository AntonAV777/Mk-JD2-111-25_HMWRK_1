package org.homework;

import org.homework.util.NumberConstants;
import org.homework.util.NumberUtil;

public class IntNumberToWords {

    public IntNumberToWords() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String toString(int number) {
        return toString(number, Gender.MASCULINE);
    }

    public static String toString(int number, Gender gender) {
        if (number < -999_999_999 || number > 999_999_999) {
            throw new IllegalArgumentException("Number out of range: " + number);
        }

        if (number == 0) return gender == Gender.FEMININE ? "Ноль" : "Ноль";

        StringBuilder result = new StringBuilder();
        if (number < 0) {
            result.append("минус ");
            number = Math.abs(number);
        }

        int millions = number / 1_000_000;
        int thousands = (number % 1_000_000) / 1_000;
        int units = number % 1_000;

        if (millions > 0) {
            result.append(tripleToWords(millions, 0, Gender.MASCULINE)).append(" ");
        }
        if (thousands > 0) {
            result.append(tripleToWords(thousands, 1, Gender.FEMININE)).append(" ");
        }
        if (units > 0) {
            result.append(tripleToWords(units, 2, gender));
        }

        return NumberUtil.capitalizeFirst(result.toString().trim());
    }

    private static String tripleToWords(int number, int formIndex, Gender gender) {
        int h = number / 100;
        int t = (number % 100) / 10;
        int u = number % 10;
        int lastTwo = number % 100;

        StringBuilder sb = new StringBuilder();
        sb.append(NumberConstants.HUNDREDS[h]).append(" ");

        if (lastTwo < 20) {
            sb.append(getUnitWord(lastTwo, gender));
        } else {
            sb.append(NumberConstants.TENS[t]).append(" ");
            sb.append(getUnitWord(u, gender));
        }

        sb.append(NumberUtil.getForm(number, formIndex));
        return sb.toString().trim();
    }

    private static String getUnitWord(int value, Gender gender) {
        return switch (value) {
            case 1 -> gender == Gender.FEMININE ? "одна " : "один ";
            case 2 -> gender == Gender.FEMININE ? "две " : "два ";
            default -> NumberConstants.UNITS[value] + " ";
        };
    }

    public enum Gender {
        MASCULINE,
        FEMININE
    }
}
