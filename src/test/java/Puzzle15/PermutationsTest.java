package Puzzle15;

import org.junit.jupiter.api.Test;

import static Puzzle15.Permutations.permutations;
import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void example() {
        int[] nums = {1,2,3};
        int[][] result = permutations(nums);
        for (int[] perm: result) {
            for (int num: perm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}