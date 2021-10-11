package Puzzle20;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Building {
    public static long[] busiestPeriod(List<Entry> entries) {
        HashMap<Long, Integer> counts = new HashMap<>();
        for (Entry entry: entries) {
            if (!counts.containsKey(entry.getTimestamp())) {
                try{
                    counts.put(entry.getTimestamp(), counts.get(counts.keySet().stream().filter((a) -> a < entry.getTimestamp()).max(Long::compare).get()));
                }
                catch (Exception ex) {
                    counts.put(entry.getTimestamp(), 0);
                }
            }
            for (Long time: counts.keySet()) {
                if (time >= entry.getTimestamp()) {
                    counts.put(time, counts.get(time) + (entry.getType().equals("enter") ? 1: -1) * entry.getCount());
                }
            }
        }

        long start = counts.keySet().stream().max(Comparator.comparingLong(counts::get)).get();
        long end = counts.keySet().stream().filter((a) -> a > start).min(Long::compare).get();
        return new long[] {start, end};

    }
}


