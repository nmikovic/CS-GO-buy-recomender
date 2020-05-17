package rushB.CS.GO.Buy.Recommender.facts;

import rushB.CS.GO.Buy.Recommender.dtos.MatchStartInput;

import java.util.ArrayList;
import java.util.HashMap;

public class Match {
    private ArrayList<Round> rounds = new ArrayList<>();
    private Integer currentRound = 1;
    private Map map;
    private Side teamSide;
    private HashMap<Team, Integer> teamScore = new HashMap<>();
    private HashMap<Player, Score> scores = new HashMap<>();

    public Match() {
    }

    public Match(MatchStartInput matchStartInput) {
        this.map = matchStartInput.getMap();
        this.teamSide = matchStartInput.getSide();

        this.teamScore.put(Team.TEAM, 0);
        this.teamScore.put(Team.OPPONENTS, 0);

        matchStartInput.getTeammates().forEach((player) -> {
            this.scores.put(player, new Score());
        });
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }

    public Integer getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Integer currentRound) {
        this.currentRound = currentRound;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Side getTeamSide() {
        return teamSide;
    }

    public void setTeamSide(Side teamSide) {
        this.teamSide = teamSide;
    }

    public HashMap<Player, Score> getScores() {
        return scores;
    }

    public void setScores(HashMap<Player, Score> scores) {
        this.scores = scores;
    }

    public HashMap<Team, Integer> getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(HashMap<Team, Integer> teamScore) {
        this.teamScore = teamScore;
    }
}
