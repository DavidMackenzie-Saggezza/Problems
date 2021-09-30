import Puzzle13.Read;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static Puzzle15.Permutations.add;
import static Puzzle15.Permutations.permutations;

public class Main {
    public static void main(String[] args) {
        for (int i = 2; i < 15; i++) {
            int[] nums = new int[i];
            for (int j = 0; j < i; j++) {
                nums[j] = j + 1;
            }
            long time = System.currentTimeMillis();
            permutations(nums);
            System.out.println(i + ": " + (System.currentTimeMillis() - time) + "ms");
        }
    }
}
