package Puzzle23;

import org.junit.jupiter.api.Test;

import static Puzzle23.CharMapping.existsMapping;
import static org.junit.jupiter.api.Assertions.*;

class CharMappingTest {

    @Test
    void blankStringsReturnTrue() {
        String s1 = "";
        String s2 = "";
        assertTrue(existsMapping(s1, s2));
    }

    @Test
    void differentSizeStringsReturnFalse() {
        String s1 = "ab";
        String s2 = "abc";
        assertFalse(existsMapping(s1, s2));
    }

    @Test
    void example1() {
        String s1 = "abc";
        String s2 = "bcd";
        assertTrue(existsMapping(s1, s2));
    }

    @Test
    void example2() {
        String s1 = "foo";
        String s2 = "bar";
        assertFalse(existsMapping(s1, s2));
    }
}