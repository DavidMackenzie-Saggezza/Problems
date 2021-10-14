package Puzzle26;

import org.junit.jupiter.api.Test;

import static Puzzle26.Product.productWithoutPosition;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void example1() {
        int[] array = {3,2,1};
        int[] result = productWithoutPosition(array);
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
        assertEquals(6, result[2]);
    }

    @Test
    void example2() {
        int[] array = {1,2,3,4,5};
        int[] result = productWithoutPosition(array);
        assertEquals(120, result[0]);
        assertEquals(60, result[1]);
        assertEquals(40, result[2]);
        assertEquals(30, result[3]);
        assertEquals(24, result[4]);
    }
    @Test
    void negativeNumbers() {
        int[] array = {-1,-2,3,4,-5};
        int[] result = productWithoutPosition(array);
        assertEquals(120, result[0]);
        assertEquals(60, result[1]);
        assertEquals(-40, result[2]);
        assertEquals(-30, result[3]);
        assertEquals(24, result[4]);
    }

}