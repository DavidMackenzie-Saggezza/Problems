package Puzzle26;

import java.util.Arrays;

public class Product {
    public static int[] productWithoutPosition(int[] array) {
        int totalProduct = Arrays.stream(array).reduce(1, (i, j) -> i * j);

        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = totalProduct / array[i];
        }
        return result;
    }
}