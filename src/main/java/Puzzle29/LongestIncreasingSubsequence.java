package Puzzle29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static int longestIncreasingSubsequence(int[] array) {
        // Similar but improved solution by only storing the max num of subsequences at each stage
        HashMap<Integer, Integer> maxSubsequences = new HashMap<>();
        for (int i = array.length - 1; i >= 0; i--) {
            int max = 0;
            for (int index: maxSubsequences.keySet()) {
                if (array[i] < array[index]) {
                    max = Math.max(max, maxSubsequences.get(index));
                }
            }
            maxSubsequences.put(i, max + 1);
        }
        return array.length != 0 ? maxSubsequences.values().stream().max(Integer::compare).get() : 0;
    }

    public static int longestIncreasingSubsequenceFirstSolution(int[] array) {
        // This works by creating all possible increasing subsequences and taking the max.
        // Really inefficient as expected.
        HashSet<List<Integer>> possibleSubsequences = new HashSet<>();
        for (int i = array.length - 1; i >= 0; i--) {
            ArrayList<Integer> singleElementSubset = new ArrayList<>();
            singleElementSubset.add(array[i]);
            possibleSubsequences.add(singleElementSubset);

            HashSet<List<Integer>> subsequencesToBeAdded = new HashSet<>();
            for (List<Integer> subsequence: possibleSubsequences) {
                if (array[i] < subsequence.get(0)) {
                    List<Integer> newSubsequence = new ArrayList<>();
                    newSubsequence.add(array[i]);
                    for (Integer integer: subsequence) {
                        newSubsequence.add(integer);
                    }
                    subsequencesToBeAdded.add(newSubsequence);
                }
            }
            subsequencesToBeAdded.forEach(possibleSubsequences::add);

        }

        int max = 0;
        for(List<Integer> list: possibleSubsequences) {
            max = Math.max(list.size(), max);
        }
        return max;
    }
}