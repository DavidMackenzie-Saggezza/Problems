package Puzzle4;

import org.junit.jupiter.api.Test;

import static Puzzle4.RunLengthEncoder.decode;
import static Puzzle4.RunLengthEncoder.encode;
import static org.junit.jupiter.api.Assertions.*;

class RunLengthEncoderTest {

    @Test
    void encodeBlankStringReturnsBlackString() {
        assertEquals("", encode(""));
    }

    @Test
    void encodeSingleLetterReturnsOneAndThatLetter() {
        assertEquals("1A", encode("A"));
    }

    @Test
    void encodeSameLetterTwiceReturnsTwoAndThatLetter() {
        assertEquals("2A", encode("AA"));
    }

    @Test
    void encodeVariousLetters() {
        assertEquals("1A1D2G1E1P4J2T1Y", encode("ADGGEPJJJJTTY"));
    }

    @Test
    void decodeBlankStringReturnsBlackString() {
        assertEquals("", decode(""));
    }

    @Test
    void decodeSingleLetterReturnsOneAndThatLetter() {
        assertEquals("A", decode("1A"));
    }

    @Test
    void decodeSameLetterTwiceReturnsTwoAndThatLetter() {
        assertEquals("AA", decode("2A"));
    }

    @Test
    void decodeVariousLetters() {
        assertEquals("ADGGEPJJJJTTY", decode("1A1D2G1E1P4J2T1Y"));
    }
}