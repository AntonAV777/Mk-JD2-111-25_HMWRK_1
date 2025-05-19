package org.example;

import org.example.util.Formatter;

public class TimeConverter {

    public static String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat) {
        if (millisecond < 0) {
            throw new IllegalArgumentException("Нельзя передать отрицательное количество миллисекунд");
        }

        long hours = millisecond / (3600 * 1000);
        long remainder = millisecond % (3600 * 1000);

        long minutes = remainder / (60 * 1000);
        remainder = remainder % (60 * 1000);

        long seconds = remainder / 1000;
        long millis = remainder % 1000;

        if (shortFormat) {
            return Formatter.formatShort(hours, minutes, seconds, millis);
        } else {
            return Formatter.formatLong(hours, minutes, seconds, millis);
        }
    }
}
