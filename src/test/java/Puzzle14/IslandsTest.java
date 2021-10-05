package Puzzle14;

import org.junit.jupiter.api.Test;

import static Puzzle14.Islands.numIslands;
import static org.junit.jupiter.api.Assertions.*;

class IslandsTest {
    @Test
    void emptyArrayReturns0() {
        int[][] matrix = new int[0][0];
        assertEquals(0, numIslands(matrix));
    }

    @Test
    void singleZeroReturns0() {
        int[][] matrix = new int[1][1];
        assertEquals(0, numIslands(matrix));
    }

    @Test
    void singleOneReturns1() {
        int[][] matrix = new int[1][1];
        matrix[0][0] = 1;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void rowOfZeroesReturns0() {
        int[][] matrix = new int[1][3];
        assertEquals(0, numIslands(matrix));
    }

    @Test
    void columnOfZeroesReturns0() {
        int[][] matrix = new int[3][1];
        assertEquals(0, numIslands(matrix));
    }

    @Test
    void rowOfOnesReturns1() {
        int[][] matrix = new int[1][5];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[0][4] = 1;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void columnOfOnesReturns1() {
        int[][] matrix = new int[3][1];
        matrix[0][0] = 1;
        matrix[1][0] = 1;
        matrix[2][0] = 1;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void rowOfZeroOneZeroReturns1() {
        int[][] matrix = new int[1][3];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 0;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void rowOfOneZeroOneReturns2() {
        int[][] matrix = new int[1][3];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 1;
        assertEquals(2, numIslands(matrix));
    }

    @Test
    void columnOfZeroOneZeroReturns1() {
        int[][] matrix = new int[3][1];
        matrix[0][0] = 0;
        matrix[1][0] = 1;
        matrix[2][0] = 0;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void columnOfOneZeroOneReturns2() {
        int[][] matrix = new int[3][1];
        matrix[0][0] = 1;
        matrix[1][0] = 0;
        matrix[2][0] = 1;
        assertEquals(2, numIslands(matrix));
    }

    @Test
    void exampleMatrixReturns4() {
        int[][] matrix = new int[6][5];
        matrix[0][0] = 1;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        matrix[4][0] = 1;
        matrix[4][1] = 1;
        matrix[4][4] = 1;
        matrix[5][0] = 1;
        matrix[5][1] = 1;
        matrix[5][4] = 1;
        assertEquals(4, numIslands(matrix));
    }

    @Test
    void DiagonalFilledWithOnesExceptCentre() {
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[1][1] = 1;
        matrix[0][4] = 1;
        matrix[1][3] = 1;
        matrix[4][0] = 1;
        matrix[3][1] = 1;
        matrix[4][4] = 1;
        matrix[3][3] = 1;
        assertEquals(4, numIslands(matrix));
    }

    @Test
    void snakeReturns1() {
        int[][] matrix = new int[6][4];
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[1][3] = 1;
        matrix[2][2] = 1;
        matrix[2][1] = 1;
        matrix[2][0] = 1;
        matrix[3][0] = 1;
        matrix[4][0] = 1;
        matrix[5][0] = 1;
        matrix[5][1] = 1;
        matrix[4][2] = 1;
        matrix[3][3] = 1;
        matrix[5][3] = 1;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void matrixWithSingleBlockOfOnesReturns1() {
        int[][] matrix = new int[6][8];
        matrix[3][3] = 1;
        matrix[4][4] = 1;
        matrix[3][4] = 1;
        matrix[4][3] = 1;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void twoColumnsOfOnesReturns2() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[1][0] = 1;
        matrix[2][0] = 1;
        matrix[0][2] = 1;
        matrix[1][2] = 1;
        matrix[2][2] = 1;
        assertEquals(2, numIslands(matrix));
    }

    @Test
    void multipleDiagonals() {
        int[][] matrix = new int[5][5];
        matrix[0][1] = 1;
        matrix[0][3] = 1;
        matrix[1][0] = 1;
        matrix[1][2] = 1;
        matrix[1][4] = 1;
        matrix[2][1] = 1;
        matrix[2][3] = 1;
        matrix[3][0] = 1;
        matrix[3][2] = 1;
        matrix[3][4] = 1;
        matrix[4][1] = 1;
        matrix[4][3] = 1;
        assertEquals(1, numIslands(matrix));
    }

    @Test
    void squareOfOnesContainingSeparateOne() {
        int[][] matrix = new int[7][7];
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 1;
        matrix[1][5] = 1;
        matrix[2][5] = 1;
        matrix[3][5] = 1;
        matrix[4][5] = 1;
        matrix[5][5] = 1;
        matrix[5][4] = 1;
        matrix[5][3] = 1;
        matrix[5][2] = 1;
        matrix[5][1] = 1;
        matrix[4][1] = 1;
        matrix[3][1] = 1;
        matrix[2][1] = 1;
        matrix[3][3] = 1;
        assertEquals(2, numIslands(matrix));
    }
}