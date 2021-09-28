package Puzzle8;

// Given a list of integers, return the largest product that can be made by multiplying any three integers.
// For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.
// You can assume the list has at least 3 positive integers.

import java.util.Arrays;

public class MaxProduct {
    // We don't NEED to sort the whole array as in the implementation below. We just need to have a sorted array of the two least elements and the 3 biggest elements.
    // I did create this helper function but it only works if we have three positive integers i.e. not for the example.
    // Otherwise we need extra work to check this case.

    public static int maxProduct(int[] numbers) {
        Arrays.sort(numbers);
        return Math.max(numbers[0] * numbers[1] * numbers[numbers.length - 1], numbers[numbers.length - 3] * numbers[numbers.length - 2] * numbers[numbers.length -1]);
    }
}
