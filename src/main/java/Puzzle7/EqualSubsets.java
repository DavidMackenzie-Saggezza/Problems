package Puzzle7;

import java.util.*;

public class EqualSubsets {
    // This recursive approach "works" but will only complete in short time for lists with around 12 numbers or less.
    // If all cases are checked (as in MultipleSameElementAndSumReturnsTrue) then this will stop returning in reasonable time.

    public static boolean equalSubsets(int[] list) {
        int total = Arrays.stream(list).sum();
        if (total % 2 == 1) {
            return false;
        }
        int targetSum = total / 2;
        Set<Integer> nums = new HashSet<>();
        for (int i = list.length - 1; i >= 0; i--) {
            List<Integer> newNums = new ArrayList<>();
            for (Integer num: nums) {
                newNums.add(num + list[i]);
            }
            for (Integer num: newNums) {
                nums.add(num);
            }
            nums.add(list[i]);
        }
        return nums.contains(targetSum);
    }

    public static Set<Integer> equalSubsetsReturnOneSubset(int[] list) {
        int total = Arrays.stream(list).sum();
        if (total % 2 == 1) {
            return null;
        }
        int targetSum = total / 2;
        HashMap<Integer, Set<Integer>> numsAndSubsets = new HashMap<>();
        for (int i = list.length - 1; i >= 0; i--) {
            HashMap<Integer, Set<Integer>> newNumsAndSubsets = new HashMap<>();
            for (Integer num: numsAndSubsets.keySet()) {
                Set<Integer> newSet = new HashSet<>();
                newSet.addAll(numsAndSubsets.get(num));
                newSet.add(list[i]);
                newNumsAndSubsets.put(num + list[i], newSet);
            }
            numsAndSubsets.putAll(newNumsAndSubsets);
            Set<Integer> newSet = new HashSet<>();
            newSet.add(list[i]);
            numsAndSubsets.put(list[i], newSet);
        }

        return numsAndSubsets.keySet().contains(targetSum) ? numsAndSubsets.get(targetSum) : null;
    }

    public static boolean equalSubsetsOld(int[] list) {
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
            int[] leftArray = Arrays.copyOfRange(list,0, i);
            int[] rightArray;
            if (i != list.length - 1) {
                rightArray = Arrays.copyOfRange(list,i + 1, list.length - 1);
            }
            else {
                rightArray = new int[0];
            }
            int[] subArray = new int[list.length - 1];
            System.arraycopy(leftArray, 0, subArray, 0, leftArray.length);
            System.arraycopy(rightArray, 0, subArray, leftArray.length, rightArray.length);

            if (sumInSet(subArray, sum - list[i])) {
                return true;
            }
        }
        return false;
    }
}
