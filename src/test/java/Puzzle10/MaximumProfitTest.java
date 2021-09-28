package Puzzle10;

import org.junit.jupiter.api.Test;

import static Puzzle10.MaximumProfit.maxProfit;
import static org.junit.jupiter.api.Assertions.*;

class MaximumProfitTest {

    @Test
    void twoElementArrayReturnsDifference() {
        int[] prices = {1,2};
        assertEquals(1, maxProfit(prices));
    }

    @Test
    void ThreeElementsSameReturnsZero() {
        int[] prices = {1,1,1};
        assertEquals(0, maxProfit(prices));
    }

    @Test
    void ThreeElementsIncreasingReturnsBiggestDifference() {
        int[] prices = {1,2,3};
        assertEquals(2, maxProfit(prices));
    }

    @Test
    void FluctuatingElementsReturnsBiggestDifference() {
        int[] prices = {1,4,2};
        assertEquals(3, maxProfit(prices));
    }

    @Test
    void LongerFluctuatingElementsReturnsBiggestDifference() {
        int[] prices = {1,4,2,7,4};
        assertEquals(6, maxProfit(prices));
    }

    @Test
    void ExampleReturnsCorrectly() {
        int[] prices = {9,11,8,5,7,10};
        assertEquals(5, maxProfit(prices));
    }
}