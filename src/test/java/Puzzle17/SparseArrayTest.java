package Puzzle17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SparseArrayTest {

    @Test
    void testGetMethod() {
        int[] arr = {0,0,0,1,0,0,0,0,5,0,0,0,0,0,0,0,};
        SparseArray sparseArray = new SparseArray(arr);
        assertEquals(0, sparseArray.get(0));
        assertEquals(1, sparseArray.get(3));
        assertEquals(5, sparseArray.get(8));
        assertEquals(0, sparseArray.get(15));
    }

    @Test
    void testSetMethod() {
        int[] arr = {0,0,0,1,0,0,0,0,5,0,0,0,0,0,0,0,};
        SparseArray sparseArray = new SparseArray(arr);
        sparseArray.set(8, 7);
        assertEquals(7, sparseArray.get(8));
    }

    @Test
    void testOnlyStoringNonZeroElements() {
        int[] arr = {0,0,0,1,0,0,0,0,5,0,0,0,0,0,0,0,};
        SparseArray sparseArray = new SparseArray(arr);
        assertEquals(2, sparseArray.nonZeroElements());
    }

    @Test
    void testIndexOutOfBounds() {
        int[] arr = {0,0,0,1,0,0,0,0,5,0,0,0,0,0,0,0,};
        SparseArray sparseArray = new SparseArray(arr);
        assertThrows(IndexOutOfBoundsException.class, () -> sparseArray.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> sparseArray.get(arr.length));
        assertThrows(IndexOutOfBoundsException.class, () -> sparseArray.set(-1, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> sparseArray.set(arr.length, 4));
    }
}