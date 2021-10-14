package Puzzle22;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Puzzle22.Markov.computeStatesVisited;

class MarkovTest {
    @Test
    void example() {
        List<Probability> probabilities = new ArrayList<>();
        probabilities.add(new Probability("a", "a", 0.9));
        probabilities.add(new Probability("a", "b", 0.075));
        probabilities.add(new Probability("a", "c", 0.025));
        probabilities.add(new Probability("b", "a", 0.15));
        probabilities.add(new Probability("b", "b", 0.8));
        probabilities.add(new Probability("b", "c", 0.05));
        probabilities.add(new Probability("c", "a", 0.25));
        probabilities.add(new Probability("c", "b", 0.25));
        probabilities.add(new Probability("c", "c", 0.5));
        String startingState = "a";
        int steps = 5000;

        HashMap<String, Integer> statesVisited = computeStatesVisited(probabilities, startingState, steps);
//        for (String state: statesVisited.keySet()) {
//            System.out.println(state + ": " + statesVisited.get(state));
//        }

    }
}