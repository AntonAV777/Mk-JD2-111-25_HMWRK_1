package org.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeConverterTest {

    @Test
    void testConstructorCoverage() {
        new TimeConverter();
    }

    @Test
    void testShortFormatBasic() {
        assertEquals("00:00:00.000", TimeConverter.toHoursMinuteSecondMillisecond(0, true));
        assertEquals("00:00:00.001", TimeConverter.toHoursMinuteSecondMillisecond(1, true));
        assertEquals("00:00:01.000", TimeConverter.toHoursMinuteSecondMillisecond(1000, true));
        assertEquals("00:01:00.000", TimeConverter.toHoursMinuteSecondMillisecond(60000, true));
        assertEquals("01:00:00.000", TimeConverter.toHoursMinuteSecondMillisecond(3600000, true));
        assertEquals("02:09:49.001", TimeConverter.toHoursMinuteSecondMillisecond(7789001, true));
        assertEquals("27:46:40.123", TimeConverter.toHoursMinuteSecondMillisecond(100000123, true));
    }

    @Test
    void testLongFormatBasic() {
        assertEquals("0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(0, false));
        assertEquals("1 миллисекунда", TimeConverter.toHoursMinuteSecondMillisecond(1, false));
        assertEquals("1 секунда 0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(1000, false));
        assertEquals("1 минута 0 секунд 0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(60000, false));
        assertEquals("1 час 0 минут 0 секунд 0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(3600000, false));
        assertEquals("2 часа 9 минут 49 секунд 1 миллисекунда", TimeConverter.toHoursMinuteSecondMillisecond(7789001, false));
        assertEquals("27 часов 46 минут 40 секунд 123 миллисекунды", TimeConverter.toHoursMinuteSecondMillisecond(100000123, false));
    }

    @Test
    void testLongFormatSingularAndPlural() {
        assertEquals("1 час 1 минута 1 секунда 1 миллисекунда", TimeConverter.toHoursMinuteSecondMillisecond(3661001, false));
        assertEquals("21 час 21 минута 21 секунда 21 миллисекунда", TimeConverter.toHoursMinuteSecondMillisecond(
                (21L * 3600000) + (21 * 60000) + (21 * 1000) + 21, false));
        assertEquals("22 часа 22 минуты 22 секунды 22 миллисекунды", TimeConverter.toHoursMinuteSecondMillisecond(
                (22L * 3600000) + (22 * 60000) + (22 * 1000) + 22, false));
        assertEquals("25 часов 25 минут 25 секунд 25 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(
                (25L * 3600000) + (25 * 60000) + (25 * 1000) + 25, false));
        assertEquals("11 часов 11 минут 11 секунд 11 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(
                (11L * 3600000) + (11 * 60000) + (11 * 1000) + 11, false));
    }

    @Test
    void testZeroValuesInLongFormat() {
        assertEquals("0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(0, false));
        assertEquals("1 миллисекунда", TimeConverter.toHoursMinuteSecondMillisecond(1, false));
        assertEquals("1 секунда 0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(1000, false));
        assertEquals("1 минута 0 секунд 0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(60000, false));
        assertEquals("1 час 0 минут 0 секунд 0 миллисекунд", TimeConverter.toHoursMinuteSecondMillisecond(3600000, false));
    }


    @Test
    void testNegativeMillisecondsThrows() {
        assertThrows(IllegalArgumentException.class, () -> TimeConverter.toHoursMinuteSecondMillisecond(-1, true));
        assertThrows(IllegalArgumentException.class, () -> TimeConverter.toHoursMinuteSecondMillisecond(-100, false));
    }

    @Test
    void testLargeValue() {
        long largeMillis = Long.MAX_VALUE - 1;
        String resultShort = TimeConverter.toHoursMinuteSecondMillisecond(largeMillis, true);
        String resultLong = TimeConverter.toHoursMinuteSecondMillisecond(largeMillis, false);
        assertNotNull(resultShort);
        assertNotNull(resultLong);
        assertFalse(resultShort.isEmpty());
        assertFalse(resultLong.isEmpty());
    }
}
