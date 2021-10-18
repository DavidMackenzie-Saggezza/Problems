package Puzzle27;

import org.junit.jupiter.api.Test;

import static Puzzle27.Directory.longestPath;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @Test
    void empty() {
        String directory = "";
        assertEquals(0, longestPath(directory));
    }

    @Test
    void example1() {
        String directory = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        assertEquals(20, longestPath(directory));
    }

    @Test
    void example2() {
        String directory = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        assertEquals(32, longestPath(directory));
    }

    @Test
    void noFile() {
        String directory = "dir\n\tsubdir1\n\t\tsubsubdir1\n\t\tsubsubdir2\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tsubsubsubdir1";
        assertEquals(0, longestPath(directory));
    }
}