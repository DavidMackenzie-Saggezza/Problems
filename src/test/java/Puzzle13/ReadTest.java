package Puzzle13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadTest {
    // Could inject dependencies on FileReader and then mock these in tests but testing directly will do for this.

    @Test
    void HelloWord() {
        Read read = new Read("src/main/resources/text.txt");
        String returnString;
        try {
            assertEquals("Hello W", read.read(7));
            assertEquals("orld\r\nM", read.read(7));
            assertEquals("y name ", read.read(7));
            assertEquals("is Davi", read.read(7));
            assertEquals("d", read.read(7));

        }
        catch (Exception ex) {
            fail("File not read");
        }

    }
}