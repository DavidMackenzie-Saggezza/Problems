package Puzzle7;

import java.util.Arrays;

public class EqualSubsets {
    // This recursive approach "works" but will only complete in short time for lists with around 12 numbers or less.
    // If all cases are checked (as in MultipleSameElementAndSumReturnsTrue) then this will stop returning in reasonable time.

    public static boolean equalSubsets(int[] list) {
        int total = Arrays.stream(list).sum();
        if (total % 2 == 1) {
            return false;
        }
        int targetSum = total / 2;
        return sumInSet(list, targetSum);
    }

    public static boolean sumInSet(int[] list, int sum) {
        if (list.length == 2) {
            return list[0] == sum || list[1] == sum || list[0] + list[1] == sum;
        }
        for (int i = 0; i < list.length; i++) {
            int[] rightArray;
            if (i != list.length - 1) {
                rightArray = Arrays.copyOfRange(list,i + 1, list.length);
            }
            else {
                rightArray = new int[0];
            }

            if (sumInSet(rightArray, sum - list[i])) {
                return true;
            }
        }
        return false;
    }
}
