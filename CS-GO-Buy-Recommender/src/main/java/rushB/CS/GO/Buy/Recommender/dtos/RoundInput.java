package rushB.CS.GO.Buy.Recommender.dtos;

import rushB.CS.GO.Buy.Recommender.facts.*;

import java.util.ArrayList;
import java.util.HashMap;

public class RoundInput {
    private HashMap<String, Integer> teamBudget; // "player": 1699$
    private HashMap<String, ArrayList<Armament>> playerArmaments; // can include enemy players, changes every round
    private Boolean wonPreviousRound;
    private BuyOptions teamState;
    private BuyOptions opponentsState;
    private Tactic tactic;
    private HashMap<String,Score> roundScores; // should be added to general match score

    private Boolean opponentHasAWP;

    public RoundInput() {
    }

    public HashMap<String, Integer> getTeamBudget() {
        return teamBudget;
    }

    public void setTeamBudget(HashMap<String, Integer> teamBudget) {
        this.teamBudget = teamBudget;
    }

    public HashMap<String, ArrayList<Armament>> getPlayerArmaments() {
        return playerArmaments;
    }

    public void setPlayerArmaments(HashMap<String, ArrayList<Armament>> playerArmaments) {
        this.playerArmaments = playerArmaments;
    }

    public Boolean getWonPreviousRound() {
        return wonPreviousRound;
    }

    public void setWonPreviousRound(Boolean wonPreviousRound) {
        this.wonPreviousRound = wonPreviousRound;
    }

    public BuyOptions getTeamState() {
        return teamState;
    }

    public void setTeamState(BuyOptions teamState) {
        this.teamState = teamState;
    }

    public BuyOptions getOpponentsState() {
        return opponentsState;
    }

    public void setOpponentsState(BuyOptions opponentsState) {
        this.opponentsState = opponentsState;
    }

    public Tactic getTactic() {
        return tactic;
    }

    public void setTactic(Tactic tactic) {
        this.tactic = tactic;
    }

    public HashMap<String, Score> getRoundScores() {
        return roundScores;
    }

    public void setRoundScores(HashMap<String,Score> roundScores) {
        this.roundScores = roundScores;
    }

    public Boolean getOpponentHasAWP() {
        return opponentHasAWP;
    }

    public void setOpponentHasAWP(Boolean opponentHasAWP) {
        this.opponentHasAWP = opponentHasAWP;
    }
}
