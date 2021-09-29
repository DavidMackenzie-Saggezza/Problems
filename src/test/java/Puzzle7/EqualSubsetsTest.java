package Puzzle7;

import org.junit.jupiter.api.Test;

import java.util.*;

import static Puzzle7.EqualSubsets.equalSubsets;
import static org.junit.jupiter.api.Assertions.*;

class EqualSubsetsTest {
    @Test
    void sameTwoElementsReturnsTrue() {
        int[] list = {5,5};
        assertTrue(equalSubsets(list));
    }

    @Test
    void differentTwoElementsReturnsFalse() {
        int[] list = {-1,3};
        assertFalse(equalSubsets(list));
    }

    @Test
    void PossibleThreeElementsReturnsTrue() {
        int[] list = {-1,3,2};
        assertTrue(equalSubsets(list));
    }

    @Test
    void NotPossibleThreeElementsReturnsFalse() {
        int[] list = {-1,3,5};
        assertFalse(equalSubsets(list));
    }

    @Test
    void SameElementEvenTimesReturnsTrue() {
        int[] list = new int[14];
        for (int i = 0; i < list.length; i++) {
            list[i] = 1;
        }
        assertTrue(equalSubsets(list));
    }

    @Test
    void SameElementOddTimesReturnsFalse() {
        int[] list = new int[13];
        for (int i = 0; i < list.length; i++) {
            list[i] = 1;
        }
        assertFalse(equalSubsets(list));
    }

    @Test
    void MultipleSameElementAndSumReturnsTrue() {
        // Takes 90 secs to run
        int[] list = new int[13];
        for(int i = 1; i < list.length; i++) {
            list[i] = 1;
        }
        list[0] = 12;
        assertTrue(equalSubsets(list));
    }

    @Test
    void exampleReturnsTrue() {
        int[] list = {15,5,20,10,35,15,10};
        assertTrue(equalSubsets(list));
    }
}