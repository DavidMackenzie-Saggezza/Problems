package Puzzle8;

import org.junit.jupiter.api.Test;

import static Puzzle8.MaxProduct.maxProduct;
import static org.junit.jupiter.api.Assertions.*;

class MaxProductTest {

    @Test
    void ThreeNumbersReturnsProduct() {
        int[] nums = {1,2,3};
        assertEquals(6, maxProduct(nums));
    }

    @Test
    void ExampleReturns500() {
        int[] nums = {-10, -10, 5, 2};
        assertEquals(500, maxProduct(nums));
    }

    @Test
    void AllPositiveReturnsProductOfThreeLargest() {
        int[] nums = {4,1,5,7,3,5,7};
        assertEquals(245, maxProduct(nums));
    }

    @Test
    void OneLargeNegativeReturnsProductOfThreeLargestPositive() {
        int[] nums = {-40,1,5,7,3,5,7};
        assertEquals(245, maxProduct(nums));
    }
}