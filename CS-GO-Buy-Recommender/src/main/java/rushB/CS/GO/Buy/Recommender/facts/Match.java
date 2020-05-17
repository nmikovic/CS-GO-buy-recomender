package rushB.CS.GO.Buy.Recommender.facts;

import java.util.ArrayList;

public class Match {
    private ArrayList<Round> rounds;

    public Match() {
    }

    public Match(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }
}
