package org.homework.util;

public class Pluralizer {

    public static String hourWord(long h) {
        return getWordForm(h, "час", "часа", "часов");
    }

    public static String minuteWord(long m) {
        return getWordForm(m, "минута", "минуты", "минут");
    }

    public static String secondWord(long s) {
        return getWordForm(s, "секунда", "секунды", "секунд");
    }

    public static String millisecondWord(long ms) {
        return getWordForm(ms, "миллисекунда", "миллисекунды", "миллисекунд");
    }

    private static String getWordForm(long number, String form1, String form2, String form5) {
        number = number % 100;
        if (number >= 11 && number <= 19) {
            return form5;
        }
        long lastDigit = number % 10;
        if (lastDigit == 1) return form1;
        if (lastDigit >= 2 && lastDigit <= 4) return form2;
        return form5;
    }
}
