package Puzzle6;

import org.junit.jupiter.api.Test;

import static Puzzle6.WordMatrix.isWordInMatrix;
import static org.junit.jupiter.api.Assertions.*;

class WordMatrixTest {
    @Test
    void EmptyArrayReturnsFalse() {
        char[][] matrix = {{}};
        assertFalse(isWordInMatrix(matrix, "word"));
    }

    @Test
    void WordInFirstColumnReturnsTrue() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'Q', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertTrue(isWordInMatrix(matrix, "FOAM"));
    }

    @Test
    void WordInLastColumnReturnsTrue() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'Q', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertTrue(isWordInMatrix(matrix, "TONS"));
    }

    @Test
    void WordInMiddleColumnReturnsTrue() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'O', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertTrue(isWordInMatrix(matrix, "COOS"));
    }

    @Test
    void WordInFirstRowReturnsTrue() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'O', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertTrue(isWordInMatrix(matrix, "FACT"));
    }

    @Test
    void WordInLastRowReturnsTrue() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'O', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertTrue(isWordInMatrix(matrix, "MASS"));
    }

    @Test
    void WordInMiddleRowReturnsTrue() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'O', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertTrue(isWordInMatrix(matrix, "ANON"));
    }

    @Test
    void WordNotInMatrixReturnsFalse() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'O', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertFalse(isWordInMatrix(matrix, "STAR"));
    }

    @Test
    void WordSizeDifferentToMatrixDimensionReturnsFalse() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'O', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertFalse(isWordInMatrix(matrix, "YEARLY"));
    }

    @Test
    void PartialMatchReturnsFalse() {
        char[][] matrix = { {'F', 'A', 'C', 'T'},
                            {'O', 'B', 'O', 'O'},
                            {'A', 'N', 'O', 'N'},
                            {'M', 'A', 'S', 'S'}};
        assertFalse(isWordInMatrix(matrix, "FAC"));
    }
}