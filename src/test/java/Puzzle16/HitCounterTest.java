package Puzzle16;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

class HitCounterTest {
    @Test
    void totalZeroWhenNoHits() {
        HitCounter hitCounter = new HitCounter();
        assertEquals(0, hitCounter.total());
    }

    @Test
    void totalOneWhenOneHit() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.record(Instant.ofEpochMilli(15000));
        assertEquals(1, hitCounter.total());
    }

    @Test
    void totalTwoWhenTwoHit() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.record(Instant.ofEpochSecond(15000));
        hitCounter.record(Instant.ofEpochSecond(200000));
        assertEquals(2, hitCounter.total());
    }

    @Test
    void rangeReturnsZeroWhenNoHits() {
        HitCounter hitCounter = new HitCounter();
        assertEquals(0, hitCounter.range(Instant.ofEpochSecond(10000), Instant.ofEpochSecond(1633941006)));
    }

    @Test
    void rangeReturnsZeroWhenMultipleHitsAreOutOfRange() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.record(Instant.ofEpochSecond(15000));
        hitCounter.record(Instant.ofEpochSecond(200000));
        assertEquals(0, hitCounter.range(Instant.ofEpochSecond(300000), Instant.ofEpochSecond(1633941006)));
    }

    @Test
    void rangeReturnsOneWhenOneHitAndIsInRange() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.record(Instant.ofEpochSecond(15000));
        assertEquals(1, hitCounter.range(Instant.ofEpochSecond(0), Instant.ofEpochSecond(1633941006)));
    }

    @Test
    void rangeReturnsOneWhenOneHitAndIsInRangeAndOneOutOfRange() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.record(Instant.ofEpochSecond(15000));
        hitCounter.record(Instant.ofEpochSecond(1633941102));
        assertEquals(1, hitCounter.range(Instant.ofEpochSecond(0), Instant.ofEpochSecond(1633941006)));
    }

    @Test
    void rangeReturnsOneWhenTwoHitsAreInRange() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.record(Instant.ofEpochSecond(15000));
        hitCounter.record(Instant.ofEpochSecond(1633941006));
        assertEquals(2, hitCounter.range(Instant.ofEpochSecond(0), Instant.ofEpochSecond(1633941135)));
    }

    @Test
    void testBoundaryOfRange() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.record(Instant.ofEpochSecond(15000));
        hitCounter.record(Instant.ofEpochSecond(16000));
        assertEquals(2, hitCounter.range(Instant.ofEpochSecond(15000), Instant.ofEpochSecond(16000)));
    }
}