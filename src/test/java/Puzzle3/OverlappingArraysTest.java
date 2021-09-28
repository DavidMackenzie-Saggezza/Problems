package Puzzle3;

import org.junit.jupiter.api.Test;

import static Puzzle3.OverlappingArrays.numMaxOverlaps;
import static org.junit.jupiter.api.Assertions.*;

class OverlappingArraysTest {

    @Test
    void ThreeRoomsRequired() {
        int[][] intervals = {{30, 75}, {0,50}, {60,150}};
        assertEquals(2, numMaxOverlaps(intervals));
    }

    @Test
    void NoRoomsRequired() {
        int[][] intervals = {{30, 30}};
        assertEquals(0, numMaxOverlaps(intervals));
    }

    @Test
    void NoArrays() {
        int[][] intervals = {};
        assertEquals(0, numMaxOverlaps(intervals));
    }

    @Test
    void SameThreeIntervals() {
        int[][] intervals = {{-1, 4}, {-1, 4}, {-1, 4}};
        assertEquals(3, numMaxOverlaps(intervals));
    }

    @Test
    void AdjacentIntervals() {
        int[][] intervals = {{-1, 0}, {0, 1}, {1, 3}};
        assertEquals(1, numMaxOverlaps(intervals));
    }

    @Test
    void OverLappingIntervals() {
        int[][] intervals = {{1, 10}, {2, 10}, {3, 10}};
        assertEquals(3, numMaxOverlaps(intervals));
    }

    @Test
    void MixOfIntervals() {
        int[][] intervals = {{1, 10}, {2, 10}, {3, 10}, {1, 10}, {10, 11}, {0, 1}, {7, 12}, {8, 11}};
        assertEquals(6, numMaxOverlaps(intervals));

    }
}