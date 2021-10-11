package Puzzle16;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class HitCounter {
    private List<Instant> hits = new ArrayList<>();

    public void record(Instant time) {
        hits.add(time);
    }

    public int total() {
        return hits.size();
    }

    public long range(Instant start, Instant end) {
        return hits.stream()
                .filter(i -> (i.isAfter(start) && i.isBefore(end)) || i.equals(start) || i.equals(end))
                .count();
    }
}
