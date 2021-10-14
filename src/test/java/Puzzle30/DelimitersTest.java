package Puzzle30;

import org.junit.jupiter.api.Test;

import static Puzzle30.Delimiters.reverseWords;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DelimitersTest {

    @Test
    void example() {
        String string = "hello/world:here";
        assertEquals("here/world:hello", reverseWords(string));
    }

    @Test
    void example1() {
        String string = "hello/world:here/";
        assertEquals("here/world:hello/", reverseWords(string));
    }

    @Test
    void example2() {
        String string = "hello//world:here";
        assertEquals("here//world:hello", reverseWords(string));
    }

    @Test
    void startsWithDelimiter() {
        String string = "())()hello//world:here";
        assertEquals("())()here//world:hello", reverseWords(string));
    }
}