package org.example.util;

public class Formatter {

    public static String formatShort(long hours, long minutes, long seconds, long millis) {
        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis);
    }

    public static String formatLong(long hours, long minutes, long seconds, long millis) {
        boolean allZero = (hours == 0 && minutes == 0 && seconds == 0 && millis == 0);
        if (allZero) {
            return "0 миллисекунд";
        }
        StringBuilder sb = new StringBuilder();
        if (hours > 0) {
            sb.append(hours).append(" ").append(Pluralizer.hourWord(hours)).append(" ");
        }
        if (minutes > 0 || (hours > 0)) {
            sb.append(minutes).append(" ").append(Pluralizer.minuteWord(minutes)).append(" ");
        }
        if (seconds > 0 || (hours > 0 || minutes > 0)) {
            sb.append(seconds).append(" ").append(Pluralizer.secondWord(seconds)).append(" ");
        }
        sb.append(millis).append(" ").append(Pluralizer.millisecondWord(millis));
        return sb.toString().trim();
    }
}
