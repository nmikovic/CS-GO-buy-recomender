package rushB.CS.GO.Buy.Recommender.facts;

import java.util.ArrayList;

public class RoundPlayerStatus {
    private Player player;
    private Score score;
    private ArrayList<Armament> armaments;
    private Side side;
    private Boolean teammate;
    private Integer money;

    public RoundPlayerStatus() {
    }

    public RoundPlayerStatus(Player player, Score score, ArrayList<Armament> armaments, Side side, Boolean teammate,
                             Integer money) {
        this.player = player;
        this.score = score;
        this.armaments = armaments;
        this.side = side;
        this.teammate = teammate;
        this.money = money;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public ArrayList<Armament> getArmaments() {
        return armaments;
    }

    public void setArmaments(ArrayList<Armament> armaments) {
        this.armaments = armaments;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Boolean getTeammate() {
        return teammate;
    }

    public void setTeammate(Boolean teammate) {
        this.teammate = teammate;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
