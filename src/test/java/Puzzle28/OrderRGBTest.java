package Puzzle28;

import org.junit.jupiter.api.Test;

import static Puzzle28.OrderRGB.orderRGB;
import static org.junit.jupiter.api.Assertions.*;

class OrderRGBTest {

    @Test
    void example() {
        char[] array = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        orderRGB(array);
        assertEquals('R', array[0]);
        assertEquals('R', array[1]);
        assertEquals('R', array[2]);
        assertEquals('G', array[3]);
        assertEquals('G', array[4]);
        assertEquals('B', array[5]);
        assertEquals('B', array[6]);
    }

    @Test
    void RGB() {
        char[] array = {'R', 'G', 'B'};
        orderRGB(array);
        assertEquals('R', array[0]);
        assertEquals('G', array[1]);
        assertEquals('B', array[2]);
    }

    @Test
    void GBR() {
        char[] array = {'G', 'B', 'R'};
        orderRGB(array);
        assertEquals('R', array[0]);
        assertEquals('G', array[1]);
        assertEquals('B', array[2]);
    }

    @Test
    void BRG() {
        char[] array = {'B', 'R', 'G'};
        orderRGB(array);
        assertEquals('R', array[0]);
        assertEquals('G', array[1]);
        assertEquals('B', array[2]);
    }

    @Test
    void singleR() {
        char[] array = {'R'};
        orderRGB(array);
        assertEquals('R', array[0]);
    }

    @Test
    void singleG() {
        char[] array = {'G'};
        orderRGB(array);
        assertEquals('G', array[0]);
    }

    @Test
    void singleB() {
        char[] array = {'B'};
        orderRGB(array);
        assertEquals('B', array[0]);
    }

    @Test
    void allR() {
        char[] array = {'R', 'R', 'R', 'R'};
        orderRGB(array);
        assertEquals('R', array[0]);
        assertEquals('R', array[1]);
        assertEquals('R', array[2]);
        assertEquals('R', array[3]);
    }

    @Test
    void allG() {
        char[] array = {'G', 'G', 'G', 'G'};
        orderRGB(array);
        assertEquals('G', array[0]);
        assertEquals('G', array[1]);
        assertEquals('G', array[2]);
        assertEquals('G', array[3]);
    }

    @Test
    void allB() {
        char[] array = {'B', 'B', 'B', 'B'};
        orderRGB(array);
        assertEquals('B', array[0]);
        assertEquals('B', array[1]);
        assertEquals('B', array[2]);
        assertEquals('B', array[3]);
    }
}