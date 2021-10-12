package Puzzle22;

public class Probability {
    private String sourceState;
    private String destinationState;
    private double probability;

    public Probability(String sourceState, String destinationState, double probability) {
        this.sourceState = sourceState;
        this.destinationState = destinationState;
        this.probability = probability;
    }

    public String getSourceState() {
        return sourceState;
    }

    public String getDestinationState() {
        return destinationState;
    }

    public double getProbability() {
        return probability;
    }
}
