package org.homework.util;

public class NumberUtil {

    public static String capitalizeFirst(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String getForm(int number, int index) {
        int lastTwo = number % 100;
        int last = number % 10;

        if (lastTwo >= 11 && lastTwo <= 19) {
            return NumberConstants.FORMS[index][2];
        }

        return switch (last) {
            case 1 -> NumberConstants.FORMS[index][0];
            case 2, 3, 4 -> NumberConstants.FORMS[index][1];
            default -> NumberConstants.FORMS[index][2];
        };
    }

    public static String getFractionalForm(int number) {
        int lastTwo = number % 100;
        int last = number % 10;

        if (lastTwo >= 11 && lastTwo <= 19) {
            return "сотых";
        }

        return switch (last) {
            case 1 -> "сотая";
            case 2, 3, 4 -> "сотых";
            default -> "сотых";
        };
    }
}
