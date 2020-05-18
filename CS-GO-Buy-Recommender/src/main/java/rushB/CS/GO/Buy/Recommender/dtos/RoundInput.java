package rushB.CS.GO.Buy.Recommender.dtos;

import rushB.CS.GO.Buy.Recommender.facts.*;

import java.util.ArrayList;

public class RoundInput {
    private Integer currentRound;
    private Map map;
    private Side teamSide;
    private ArrayList<Player> players;
    private Boolean wonPreviousRound;
    private BuyOptions previousTeamState;
    private BuyOptions previousOpponentsState;
    private Tactic tactic;
    private BuyOptions currentTeamState;

    private Boolean opponentHasAWP;

    public RoundInput() {
    }

    public BuyOptions getCurrentTeamState() {
        return currentTeamState;
    }

    public void setCurrentTeamState(BuyOptions currentTeamState) {
        this.currentTeamState = currentTeamState;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Boolean getWonPreviousRound() {
        return wonPreviousRound;
    }

    public void setWonPreviousRound(Boolean wonPreviousRound) {
        this.wonPreviousRound = wonPreviousRound;
    }

    public Tactic getTactic() {
        return tactic;
    }

    public void setTactic(Tactic tactic) {
        this.tactic = tactic;
    }

    public Boolean getOpponentHasAWP() {
        return opponentHasAWP;
    }

    public void setOpponentHasAWP(Boolean opponentHasAWP) {
        this.opponentHasAWP = opponentHasAWP;
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

    public BuyOptions getPreviousTeamState() {
        return previousTeamState;
    }

    public void setPreviousTeamState(BuyOptions previousTeamState) {
        this.previousTeamState = previousTeamState;
    }

    public BuyOptions getPreviousOpponentsState() {
        return previousOpponentsState;
    }

    public void setPreviousOpponentsState(BuyOptions previousOpponentsState) {
        this.previousOpponentsState = previousOpponentsState;
    }
}
