package Puzzle20;

public class Entry{
    private long timestamp;
    private int count;
    private String type;

    public Entry(long timestamp, int count, String type) {
        this.timestamp = timestamp;
        this.count = count;
        this.type = type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }
}
