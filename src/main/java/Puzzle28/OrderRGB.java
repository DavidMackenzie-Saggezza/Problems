package Puzzle28;

public class OrderRGB {
    public static void orderRGB(char[] array) {
        int pos = 0;
        char[] letters = {'R', 'G'};
        for (char letter : letters) {
            for (int j = pos; j < array.length; j++) {
                if (array[j] == letter) {
                    array[j] = array[pos];
                    array[pos] = letter;
                    pos++;
                }
            }
        }

    }
}
