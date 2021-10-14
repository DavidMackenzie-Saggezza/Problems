package Puzzle27;

import org.junit.jupiter.api.Test;

import static Puzzle27.Directory.longestPath;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @Test
    void example() {
        String directory = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        assertEquals(32, longestPath(directory));
    }
}