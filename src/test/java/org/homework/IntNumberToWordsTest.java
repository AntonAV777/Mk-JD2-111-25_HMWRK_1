package org.homework;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class IntNumberToWordsTest {

    @Test
    void testConstructorThrowsException() {
        assertThrows(UnsupportedOperationException.class, IntNumberToWords::new);
    }

    @Test
    void testPrivateConstructorThrowsException() {
        assertThrows(UnsupportedOperationException.class, IntNumberToWords::new);
    }

    @Test
    void testNumberTooHigh() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IntNumberToWords.toString(1_000_000_000));
        assertTrue(exception.getMessage().contains("Number out of range"));
    }

    @Test
    void testNumberTooLow() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IntNumberToWords.toString(-1_000_000_000));
        assertTrue(exception.getMessage().contains("Number out of range"));
    }

    @Test
    void testZero() {
        assertEquals("Ноль", IntNumberToWords.toString(0));
    }

    @Test
    void testPositiveSingleDigit() {
        assertEquals("Один", IntNumberToWords.toString(1));
        assertEquals("Два", IntNumberToWords.toString(2));
        assertEquals("Девять", IntNumberToWords.toString(9));
    }

    @Test
    void testNegativeNumber() {
        assertEquals("Минус сто двадцать три", IntNumberToWords.toString(-123));
    }

    @Test
    void testThousands() {
        assertEquals("Одна тысяча", IntNumberToWords.toString(1000));
        assertEquals("Две тысячи один", IntNumberToWords.toString(2001));
        assertEquals("Девять тысяч девятьсот девяносто девять", IntNumberToWords.toString(9999));
    }

    @Test
    void testMillions() {
        assertEquals("Один миллион", IntNumberToWords.toString(1_000_000));
        assertEquals("Два миллиона", IntNumberToWords.toString(2_000_000));
        assertEquals("Двадцать один миллион", IntNumberToWords.toString(21_000_000));
    }

    @Test
    void testMaxInt() {
        assertEquals("Девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять",
                IntNumberToWords.toString(999_999_999));
    }

    @Test
    void testMinInt() {
        assertEquals("Минус девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять",
                IntNumberToWords.toString(-999_999_999));
    }

    @Test
    void testPrivateConstructor() throws Exception {
        var constructor = IntNumberToWords.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        InvocationTargetException thrown = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertTrue(thrown.getCause() instanceof UnsupportedOperationException);
    }
}
