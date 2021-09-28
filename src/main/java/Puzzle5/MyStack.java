package Puzzle5;

import java.util.ArrayList;
import java.util.List;

public class MyStack<E extends Comparable> {
    List<E> list = new ArrayList<>();
    int size = 0;

    public void push(E value) {
        list.add(value);
        size++;
    }

    public E pop() {
        return size == 0 ? null : list.remove(size-- - 1);
    }

    public E max() {
        if (list.stream().max(E::compareTo).isPresent()) {
            return list.stream().max(E::compareTo).get();
        }
        else {
            return null;
        }
    }

    public int getSize() {
        return size;
    }
}
