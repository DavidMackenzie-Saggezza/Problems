package Puzzle17;

import java.util.HashMap;

public class SparseArray {
    // Location, Value
    private HashMap<Integer, Integer> elements = new HashMap<>();
    private long size;

    public SparseArray(int[] arr) {
        this.size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                elements.put(i, arr[i]);
            }
        }
    }

    public void set(int i, int val) {
        if (i >= 0 && i < size) {
            elements.put(i, val);
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bounds of sparse array");
        }
    }

    public int get(int i) {
        if (i >= 0 && i < size) {
            return elements.getOrDefault(i, 0);
        }
        else {
            throw new IndexOutOfBoundsException("Index out of bounds of sparse array");
        }
    }

    public int nonZeroElements() {
        return elements.size();
    }
}
