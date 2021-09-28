package Puzzle3;
import java.util.HashMap;

//Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum
//        number of rooms required.
//        For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

public class OverlappingArrays {
    //Brute Force solution. Only works for integer values. TERRIBLE Performance.
    public static int numMaxOverlapsBrute(int[]... intervals) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int[] interval: intervals) {
            int left = interval[0];
            int right = interval[1];
            while (left != right) {
                if (count.containsKey(left)) {
                    count.put(left, count.get(left) + 1);
                }
                else {
                    count.put(left, 1);
                }
                left++;
            }
        }
        return count.isEmpty() ? 0: count.values().stream().max(Integer::compare).get();
    }

    //Much better solution adding each array iteratively to a HashMap which stores the number of times each subArray
    //is used.
    public static int numMaxOverlaps(int[][] intervals) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int[] interval: intervals) {
            for(int pos: interval) {
                if (!counts.containsKey(pos)) {
                    try{
                        counts.put(pos, counts.get(counts.keySet().stream().filter((a) -> a < pos).max(Integer::compare).get()));
                    }
                    catch (Exception ex) {
                        counts.put(pos, 0);
                    }
                }
            }
            for (int arrayStart: counts.keySet()) {
                if (arrayStart >= interval[0] & arrayStart < interval[1]) {
                    counts.put(arrayStart, counts.get(arrayStart) + 1);
                }
            }
        }
        return counts.isEmpty() ? 0: counts.values().stream().max(Integer::compare).get();
    }
}
