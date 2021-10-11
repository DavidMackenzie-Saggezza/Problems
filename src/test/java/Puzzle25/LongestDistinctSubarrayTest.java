package Puzzle25;

import org.junit.jupiter.api.Test;

import static Puzzle25.LongestDistinctSubarray.longestDistinctSubarray;
import static org.junit.jupiter.api.Assertions.*;

class LongestDistinctSubarrayTest {
    @Test
    void example() {
        Integer[] array = {5,1,3,5,2,3,4,1};
        assertEquals(5, longestDistinctSubarray(array));
    }

    @Test
    void allSameElements() {
        Integer[] array = {5,5,5,5,5,5};
        assertEquals(1, longestDistinctSubarray(array));
    }

    @Test
    void pushingLeftTest() {
        // This is the situation mentioned where we may lose a
        Integer[] array = {1,2,1,2,3,1};
        assertEquals(3, longestDistinctSubarray(array));
        Integer[] array1 = {3,2,1,2,1,1};
        assertEquals(3, longestDistinctSubarray(array1));
    }

    @Test
    void bigArray() {
        Integer[] array = new Integer[1000];
        for (int i = 0; i < 998; i++) {
            array[i] = 6000;
        }
        array[998] = 2;
        array[999] = 3;
        assertEquals(3, longestDistinctSubarray(array));
    }
}