package Puzzle20;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static Puzzle20.Building.busiestPeriod;
import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    @Test
    void noEntriesThrowsException() {
        List<Entry> entries = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> busiestPeriod(entries));
    }

    @Test
    void oneEntryThrowsException() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(5, 3, "enter"));
        assertThrows(RuntimeException.class, () -> busiestPeriod(entries));
    }

    @Test
    void smallExample() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 2, "exit"));
        entries.add(new Entry(0, 3, "enter"));
        entries.add(new Entry(3, 4, "exit"));
        entries.add(new Entry(2, 3, "enter"));

        long[] result = busiestPeriod(entries);
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    void alternating() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 2, "enter"));
        entries.add(new Entry(1, 1, "exit"));
        entries.add(new Entry(2, 2, "enter"));
        entries.add(new Entry(3, 1, "exit"));
        entries.add(new Entry(4, 2, "enter"));
        entries.add(new Entry(5, 1, "exit"));
        entries.add(new Entry(6, 2, "enter"));
        entries.add(new Entry(7, 5, "exit"));

        long[] result = busiestPeriod(entries);
        assertEquals(6, result[0]);
        assertEquals(7, result[1]);
    }

    @Test
    void withoutFinalExitWrongAnswer() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 2, "enter"));
        entries.add(new Entry(1, 1, "exit"));
        entries.add(new Entry(2, 2, "enter"));
        entries.add(new Entry(3, 1, "exit"));
        entries.add(new Entry(4, 2, "enter"));
        entries.add(new Entry(5, 1, "exit"));
        entries.add(new Entry(6, 2, "enter"));

        assertThrows(RuntimeException.class, () -> busiestPeriod(entries));
    }
}