package Puzzle25;

import java.util.HashSet;

public class LongestDistinctSubarray {
    public static <E> int longestDistinctSubarray(E[] array) {
        // Idea here is to loop through each element and 'push' left and right. The only issue is that the way I have it
        // I fear pushing left first in the while loop could cause a bug somehow. I think that when we do miss a
        // 'max subArray' because we push left first then we catch it on the next iteration when we are one position
        // over to the right.
        // It passes all the tests though
        if (array.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < array.length; i++) {
            HashSet<E> elementsSeen = new HashSet<>();
            elementsSeen.add(array[i]);
            int left = i - 1;
            int right = i + 1;
            while ((left >= 0 && !elementsSeen.contains(array[left])) || (right < array.length - 1 && !elementsSeen.contains(array[right]))) {
                if ((left >= 0 && !elementsSeen.contains(array[left]))) {
                    elementsSeen.add(array[left]);
                    left--;
                }
                if ((right < array.length - 1 && !elementsSeen.contains(array[right]))) {
                    elementsSeen.add(array[right]);
                    right++;
                }
            }
            max = Math.max(max, right - left - 1);
        }
        return max;
    }

    public static <E> int longestDistinctSubarrayBruteForce(E[] array) {
        //Brute Force
        if (array.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                HashSet<E> elementsSeen = new HashSet<>();
                elementsSeen.add(array[i]);
                for (int k = i; k <= j; k++) {
                    elementsSeen.add(array[k]);
                }
                max = Math.max(max, elementsSeen.size());
            }
        }
        return max;
    }
}
