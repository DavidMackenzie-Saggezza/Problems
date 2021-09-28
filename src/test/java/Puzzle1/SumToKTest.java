package Puzzle1;
import org.junit.jupiter.api.Test;

import static Puzzle1.SumToK.sumToK;
import static org.junit.jupiter.api.Assertions.*;

class SumToKTest {
    @Test
    void EmptyArrayReturnsFalse() {
        int[] array = {};
        int k = 4;
        assertEquals(false, sumToK(array, k));
    }

    @Test
    void SingleElementArrayNotEqualToKReturnsFalse() {
        int[] array = {5};
        int k = 3;
        assertEquals(false, sumToK(array, k));
    }

    @Test
    void SingleElementArrayEqualToKReturnsTrue() {
        int[] array = {-5};
        int k = -5;
        assertEquals(false, sumToK(array, k));
    }

    @Test
    void TwoElementArrayWithElementEqualToKReturnsFalse() {
        int[] array = {7, 8};
        int k = 7;
        assertEquals(false, sumToK(array, k));
    }

    @Test
    void TwoElementArrayWithElementsSumToKReturnsTrue() {
        int[] array = {7, 8};
        int k = 15;
        assertEquals(true, sumToK(array, k));
    }

    @Test
    void TwoElementArrayWithElementsNotSumToKReturnsFalse() {
        int[] array = {7, 8};
        int k = 10;
        assertEquals(false, sumToK(array, k));
    }

    @Test
    void ThreeElementArrayWithNoElementsSummingToKReturnsFalse() {
        int[] array = {7, 8, -4};
        int k = 17;
        assertEquals(false, sumToK(array, k));
    }

    @Test
    void ThreeElementArrayWithTwoElementsSummingToKReturnsTrue() {
        int[] array = {7, 8, -4};
        int k = 3;
        assertEquals(true, sumToK(array, k));
    }

    @Test
    void ThreeElementArrayWithThreeNotTwoElementsSummingToKReturnsFalse() {
        int[] array = {7, 8, -4};
        int k = 11;
        assertEquals(false, sumToK(array, k));
    }
}