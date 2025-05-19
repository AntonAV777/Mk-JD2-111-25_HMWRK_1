package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoubleNumberToWordsTest {

    @Test
    void testZero() {
        assertEquals("Ноль целых ноль сотых", DoubleNumberToWords.toString(0.00));
    }

    @Test
    void testPositiveSimple() {
        assertEquals("Один целых одна сотая", DoubleNumberToWords.toString(1.01));
        assertEquals("Пять целых пятьдесят пять сотых", DoubleNumberToWords.toString(5.55));
    }

    @Test
    void testNegative() {
        assertEquals("Минус три целых сорок две сотых", DoubleNumberToWords.toString(-3.42));
    }

    @Test
    void testFractionalEdgeForms() {
        assertEquals("Один целых одна сотая", DoubleNumberToWords.toString(1.01));
        assertEquals("Один целых две сотых", DoubleNumberToWords.toString(1.02));
        assertEquals("Один целых четыре сотых", DoubleNumberToWords.toString(1.04));
        assertEquals("Один целых пять сотых", DoubleNumberToWords.toString(1.05));
        assertEquals("Один целых одиннадцать сотых", DoubleNumberToWords.toString(1.11));
    }

    @Test
    void testLargeValueWithinRange() {
        assertEquals(
                "Девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять целых девяносто девять сотых",
                DoubleNumberToWords.toString(999_999_999.99)
        );
    }

    @Test
    void testNegativeLargeValue() {
        assertEquals(
                "Минус девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять целых девяносто девять сотых",
                DoubleNumberToWords.toString(-999_999_999.99)
        );
    }

    @Test
    void testNumberTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> DoubleNumberToWords.toString(1_000_000_000.00));
    }

    @Test
    void testNumberTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> DoubleNumberToWords.toString(-1_000_000_000.00));
    }

    @Test
    void testNaN() {
        assertThrows(IllegalArgumentException.class, () -> DoubleNumberToWords.toString(Double.NaN));
    }

    @Test
    void testInfinity() {
        assertThrows(IllegalArgumentException.class, () -> DoubleNumberToWords.toString(Double.POSITIVE_INFINITY));
        assertThrows(IllegalArgumentException.class, () -> DoubleNumberToWords.toString(Double.NEGATIVE_INFINITY));
    }
}
