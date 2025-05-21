package org.homework;

public class WeekConverter {

    public WeekConverter() {}

    public static String toWeek(int day) {
        if (day < 0) {
            return "Неверное количество дней";
        }

        int weeks = day / 7;

        String weekForm = getWeekForm(weeks);

        return weeks + " " + weekForm;
    }

    private static String getWeekForm(int weeks) {
        weeks = weeks % 100;

        if (weeks >= 11 && weeks <= 19) {
            return "недель";
        }

        int lastDigit = weeks % 10;

        if (lastDigit == 1) {
            return "неделя";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            return "недели";
        } else {
            return "недель";
        }
    }
}
