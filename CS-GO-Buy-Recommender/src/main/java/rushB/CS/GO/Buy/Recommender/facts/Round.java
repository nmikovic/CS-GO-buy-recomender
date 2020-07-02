package rushB.CS.GO.Buy.Recommender.facts;

import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;

public class Round {
    private Integer number;
    private Side teamSide;
    private Boolean wonPreviousRound;
    private BuyOptions previousTeamState;
    private BuyOptions previousOpponentsState;
    private Tactic tactic;
    private BuyOptions currentTeamState;
    private Boolean opponentHasAWP;
    private Map map;

    public Round() {
    }

    public Round(Integer number, Side teamSide, Boolean wonPreviousRound, BuyOptions previousTeamState, BuyOptions previousOpponentsState, Tactic tactic, BuyOptions currentTeamState, Boolean opponentHasAWP, Map map) {
        this.number = number;
        this.teamSide = teamSide;
        this.wonPreviousRound = wonPreviousRound;
        this.previousTeamState = previousTeamState;
        this.previousOpponentsState = previousOpponentsState;
        this.tactic = tactic;
        this.currentTeamState = currentTeamState;
        this.opponentHasAWP = opponentHasAWP;
        this.map = map;
    }

    public Round(RoundInput roundInput, Integer currentRound) {
        this.number = currentRound;
        this.teamSide = roundInput.getTeamSide();
        this.wonPreviousRound = roundInput.getWonPreviousRound();
        this.previousTeamState = roundInput.getPreviousTeamState();
        this.previousOpponentsState = roundInput.getPreviousOpponentsState();
        this.tactic = roundInput.getTactic();
        this.currentTeamState = roundInput.getCurrentTeamState();
        this.opponentHasAWP = roundInput.getOpponentHasAWP();
        this.map = roundInput.getMap();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Side getTeamSide() {
        return teamSide;
    }

    public void setTeamSide(Side teamSide) {
        this.teamSide = teamSide;
    }

    public Boolean getWonPreviousRound() {
        return wonPreviousRound;
    }

    public void setWonPreviousRound(Boolean wonPreviousRound) {
        this.wonPreviousRound = wonPreviousRound;
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

    public Tactic getTactic() {
        return tactic;
    }

    public void setTactic(Tactic tactic) {
        this.tactic = tactic;
    }

    public BuyOptions getCurrentTeamState() {
        return currentTeamState;
    }

    public void setCurrentTeamState(BuyOptions currentTeamState) {
        this.currentTeamState = currentTeamState;
    }

    public Boolean getOpponentHasAWP() {
        return opponentHasAWP;
    }

    public void setOpponentHasAWP(Boolean opponentHasAWP) {
        this.opponentHasAWP = opponentHasAWP;
    }
}
