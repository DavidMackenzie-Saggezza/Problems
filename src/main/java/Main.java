import java.util.Arrays;

import static Puzzle7.EqualSubsets.equalSubsets;

public class Main {
    public static void main(String[] args) {
        for (int i = 3; i < 37; i++) {
            int[] list = new int[i];
            Arrays.fill(list, 1);
            list[0] = i - 1;
            long time = System.currentTimeMillis();
            equalSubsets(list);
            System.out.println(i + ": " + (System.currentTimeMillis() - time) + "ms");
        }
    }
}
