package rushB.CS.GO.Buy.Recommender.facts;

import rushB.CS.GO.Buy.Recommender.dtos.MatchStartInput;

import java.util.ArrayList;
import java.util.HashMap;

public class Match {
    private Integer currentRound = 1;
    private Map map;
    private Side teamSide;
    private HashMap<Team, Integer> teamScore = new HashMap<>();
    private ArrayList<Player> players = new ArrayList<>();
    private HashMap<String, Score> scores = new HashMap<>();
    private HashMap<String, ArrayList<Armament>> playerStatuses = new HashMap<>();

    public Match() {
    }

    public Match(MatchStartInput matchStartInput, HashMap<String, Armament> armaments) {
        this.map = matchStartInput.getMap();
        this.teamSide = matchStartInput.getSide();
        this.teamScore.put(Team.TEAM, 0);
        this.teamScore.put(Team.OPPONENTS, 0);
        this.players = matchStartInput.getTeammates();
        this.players.forEach((player) -> {
            this.scores.put(player.getName(), new Score());

            ArrayList<Armament> playerArmaments = new ArrayList<>();

            if (this.teamSide.equals(Side.TERRORIST)) {
                playerArmaments.add(armaments.get("Glock-18"));
            } else {
                playerArmaments.add(armaments.get("USP-S"));
            }
            this.playerStatuses.put(player.getName(), playerArmaments);
        });
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

    public HashMap<Team, Integer> getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(HashMap<Team, Integer> teamScore) {
        this.teamScore = teamScore;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public HashMap<String, Score> getScores() {
        return scores;
    }

    public void setScores(HashMap<String, Score> scores) {
        this.scores = scores;
    }

    public HashMap<String, ArrayList<Armament>> getPlayerStatuses() {
        return playerStatuses;
    }

    public void setPlayerStatuses(HashMap<String, ArrayList<Armament>> playerStatuses) {
        this.playerStatuses = playerStatuses;
    }


}
