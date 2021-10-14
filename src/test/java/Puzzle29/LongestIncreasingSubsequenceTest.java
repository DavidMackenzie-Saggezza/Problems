package Puzzle29;

import org.junit.jupiter.api.Test;

import static Puzzle29.LongestIncreasingSubsequence.longestIncreasingSubsequence;
import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    @Test
    void emptyArray() {
        int[] array = {};
        assertEquals(0, longestIncreasingSubsequence(array));
    }

    @Test
    void singleElement() {
        int[] array = {1};
        assertEquals(1, longestIncreasingSubsequence(array));
    }

    @Test
    void twoElementsIncreasing() {
        int[] array = {1,2};
        assertEquals(2, longestIncreasingSubsequence(array));
    }

    @Test
    void twoElementsDecreasing() {
        int[] array = {2,1};
        assertEquals(1, longestIncreasingSubsequence(array));
    }

    @Test
    void twoElementsSame() {
        int[] array = {2,2};
        assertEquals(1, longestIncreasingSubsequence(array));
    }

    @Test
    void threeElementsIncreasing() {
        int[] array = {-1,2,3};
        assertEquals(3, longestIncreasingSubsequence(array));
    }

    @Test
    void threeElementsDecreasing() {
        int[] array = {3,2,-1};
        assertEquals(1, longestIncreasingSubsequence(array));
    }

    @Test
    void bigArrayWhereWeNeedToCreateAllPossibleSubsequences() {
        // As expected, this runs out of memory at n > 25 for bad solution but runs as below for the good solution :)
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        assertEquals(1000, longestIncreasingSubsequence(array));
    }

    @Test
    void example() {
        int[] array = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        assertEquals(6, longestIncreasingSubsequence(array));
    }
}