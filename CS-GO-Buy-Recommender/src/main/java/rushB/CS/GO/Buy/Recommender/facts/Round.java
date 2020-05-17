package rushB.CS.GO.Buy.Recommender.facts;

import java.util.ArrayList;

public class Round {
    private Side winner;
    private ArrayList<RoundPlayerStatus> playerStatuses;

    public Round() {
    }

    public Round(Side winner, ArrayList<RoundPlayerStatus> playerStatuses) {
        this.winner = winner;
        this.playerStatuses = playerStatuses;
    }

    public Side getWinner() {
        return winner;
    }

    public void setWinner(Side winner) {
        this.winner = winner;
    }

    public ArrayList<RoundPlayerStatus> getPlayerStatuses() {
        return playerStatuses;
    }

    public void setPlayerStatuses(ArrayList<RoundPlayerStatus> playerStatuses) {
        this.playerStatuses = playerStatuses;
    }
}
