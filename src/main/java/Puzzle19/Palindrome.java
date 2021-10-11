package Puzzle19;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static boolean canMakePalindrome(String s) {
        List<Character> letterCounts = new ArrayList<>();
        for (Character letter: s.toCharArray()) {
            if (letterCounts.contains(letter)) {
                letterCounts.remove(letter);
            }
            else {
                letterCounts.add(letter);
            }
        }
        return letterCounts.size() <= 1;
    }
}
