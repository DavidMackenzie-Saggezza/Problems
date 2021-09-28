package Puzzle1;

import java.util.HashSet;

public class SumToK {
//    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
//    Bonus: Can you do this in one pass?

    //First implementation
    public static boolean sumToKByCheckingAllPairs(int[] array, int k) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] + array[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    //HashSet implementation with better performance
    public static boolean sumToK(int[] array, int k) {
        HashSet<Integer> values = new HashSet<>();
        for (int val: array) {
            if (values.contains(k - val)) {
                return true;
            }
            values.add(val);
        }
        return false;
    }

}
