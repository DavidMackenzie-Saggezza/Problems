package Puzzle6;

// Given a 2D matrix of characters and a target word, write a function that returns whether the word can be
// found in the matrix by going left-to-right, or up-to-down.

public class WordMatrix {


    // Wasn't stated but assuming square matrix.
    // More efficient solution might be to go along each row/column and check each letter with the corresponding letter in the word.
    // We could stop if the letters do not match and move on to next row/column. This would mean we don't create any objects at all.

    public static boolean isWordInMatrix(char[][] matrix, String word) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder matrixRowToCheck = new StringBuilder();
            StringBuilder matrixColumnToCheck = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                matrixRowToCheck.append(matrix[i][j]);
                matrixColumnToCheck.append(matrix[j][i]);
            }
            if (matrixRowToCheck.toString().equals(word) || matrixColumnToCheck.toString().equals(word)) {
                return true;
            }
        }
        return false;
    }
}
