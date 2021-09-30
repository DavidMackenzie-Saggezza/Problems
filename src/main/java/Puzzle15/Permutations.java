package Puzzle15;

import java.util.ArrayList;

// Solution works but blows up quickly due to the factorial nature of the problem. We run out of memory for case n = 12.
// This is to be expected as we are trying to return an array of 12! arrays of 12 elements.
// This is (12! * 12 * 4bytes) = 21GB!.

public class Permutations {
    // Add elements iteratively like in the subsets problem
    public static int[][] permutations(int[] nums) {
        int[][] perms = {{nums[0]}};
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        return add(perms, numbers);
    }

    public static int[][] add(int[][] perms, ArrayList<Integer> nums) {
        if (nums.size() == 0) {
            return perms;
        }
        int[][] returnPerms = new int[perms.length * (perms[0].length + 1)][perms[0].length + 1];
        for (int i = 0; i < perms.length; i++) {
            for (int j = 0; j < perms[0].length + 1; j++) {
                int[] newPerm = new int[perms[0].length + 1];
                if (j == perms[0].length) {
                    System.arraycopy(perms[i], 0, newPerm, 0, j);
                    newPerm[j] = nums.get(0);
                }
                else {
                    System.arraycopy(perms[i], 0, newPerm, 0, j);
                    newPerm[j] = nums.get(0);
                    System.arraycopy(perms[i], j, newPerm, j + 1, newPerm.length - (j + 1));
                }
                returnPerms[i * (perms[0].length + 1) + j] = newPerm;
            }
        }
        nums.remove(0);
        return add(returnPerms, nums);
    }
}
