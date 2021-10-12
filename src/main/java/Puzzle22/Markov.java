package Puzzle22;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Markov {
    public static HashMap<String, Integer> computeStatesVisited(List<Probability> transitionProbabilities, String startingState, int steps) {
        // No error checking, assuming that all probabilities from each state sum to 1.
        // Otherwise this may break.
        HashMap<String, HashMap<String, Double>> cumulativeProbs = new HashMap<>();
        for (Probability probability: transitionProbabilities) {
            if (!cumulativeProbs.containsKey(probability.getSourceState())) {
                cumulativeProbs.put(probability.getSourceState(), new HashMap<>());
            }
            double cumulativeProb = cumulativeProbs.get(probability.getSourceState()).values().stream().reduce(0.0, Double::sum);
            cumulativeProbs.get(probability.getSourceState()).put(probability.getDestinationState(), probability.getProbability() + cumulativeProb);
        }

        HashMap<String, Integer> statesVisited = new HashMap<>();

        String state = startingState;
        for (int i = 0; i < steps; i++) {
            double randomProb = Math.random();
            state = cumulativeProbs.get(state).entrySet()
                    .stream()
                    .filter(j -> j.getValue() > randomProb)
                    .min(Comparator.comparingDouble(Map.Entry::getValue))
                    .get()
                    .getKey();
            statesVisited.put(state, statesVisited.getOrDefault(state, 0) + 1);
        }

        return statesVisited;
    }
}
