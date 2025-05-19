package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntNumberToWordsTest {

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
}