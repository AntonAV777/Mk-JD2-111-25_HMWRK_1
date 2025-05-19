package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeekConverterTest {

    @Test
    void testZeroDays() {
        assertEquals("0 недель", WeekConverter.toWeek(0));
    }

    @Test
    void testLessThanAWeek() {
        assertEquals("0 недель", WeekConverter.toWeek(1));
        assertEquals("0 недель", WeekConverter.toWeek(6));
    }

    @Test
    void testExactWeeks() {
        assertEquals("1 неделя", WeekConverter.toWeek(7));
        assertEquals("2 недели", WeekConverter.toWeek(14));
        assertEquals("3 недели", WeekConverter.toWeek(21));
        assertEquals("25 недель", WeekConverter.toWeek(175));
    }

    @Test
    void testWeeksWithVariousEndings() {
        assertEquals("11 недель", WeekConverter.toWeek(77));
        assertEquals("12 недель", WeekConverter.toWeek(84));
        assertEquals("21 неделя", WeekConverter.toWeek(147));
        assertEquals("22 недели", WeekConverter.toWeek(154));
        assertEquals("25 недель", WeekConverter.toWeek(175));
        assertEquals("31 неделя", WeekConverter.toWeek(217));
        assertEquals("32 недели", WeekConverter.toWeek(224));
        assertEquals("35 недель", WeekConverter.toWeek(245));
    }

    @Test
    void testNegativeDays() {
        assertEquals("Неверное количество дней", WeekConverter.toWeek(-1));
        assertEquals("Неверное количество дней", WeekConverter.toWeek(-100));
    }

    @Test
    void testLargeNumber() {
        assertEquals("142857 недель", WeekConverter.toWeek(999999));
    }
}

