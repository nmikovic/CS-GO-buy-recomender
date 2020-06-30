package rushB.CS.GO.Buy.Recommender.facts;

import org.kie.api.definition.type.PropertyReactive;

@PropertyReactive
public class PlayerStatus {
    private Integer id;
    private String player;
    private Integer round;
    private Integer cash;

    public PlayerStatus() {
    }

    public PlayerStatus(Integer id, String player, Integer round, Integer cash) {
        this.id = id;
        this.player = player;
        this.round = round;
        this.cash = cash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }
}
