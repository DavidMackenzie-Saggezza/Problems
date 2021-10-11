package Puzzle19;

import org.junit.jupiter.api.Test;

import static Puzzle19.Palindrome.canMakePalindrome;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @Test
    void blankStringReturnsTrue() {
        assertTrue(canMakePalindrome(""));
    }

    @Test
    void oneLetterStringReturnsTrue() {
        assertTrue(canMakePalindrome("a"));
    }

    @Test
    void twoDifferentLettersReturnsFalse() {
        assertFalse(canMakePalindrome("ab"));
    }

    @Test
    void twoSameLettersReturnsTrue() {
        assertTrue(canMakePalindrome("aa"));
    }

    @Test
    void ThreeDifferentLettersReturnsFalse() {
        assertFalse(canMakePalindrome("abc"));
    }

    @Test
    void PossibleThreeLetterReturnsTrue() {
        assertTrue(canMakePalindrome("aab"));
        assertTrue(canMakePalindrome("aba"));
        assertTrue(canMakePalindrome("baa"));
        assertTrue(canMakePalindrome("aaa"));
    }

    @Test
    void carraceReturnsTrue() {
        assertTrue(canMakePalindrome("carrace"));
    }

    @Test
    void dailyReturnsFalse() {
        assertFalse(canMakePalindrome("daily"));
    }
}