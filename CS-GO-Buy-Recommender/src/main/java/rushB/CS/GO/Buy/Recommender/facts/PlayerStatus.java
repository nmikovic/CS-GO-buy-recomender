package rushB.CS.GO.Buy.Recommender.facts;

public class PlayerStatus {
    private String id;
    private String player;
    private Integer round;
    private Integer cash;

    public PlayerStatus() {
    }

    public PlayerStatus(String id, String player, Integer round, Integer cash) {
        this.id = id;
        this.player = player;
        this.round = round;
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
