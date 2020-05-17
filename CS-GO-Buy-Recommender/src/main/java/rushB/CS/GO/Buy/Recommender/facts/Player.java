package rushB.CS.GO.Buy.Recommender.facts;

public class Player {
    private Rank rank;

    public Player() {
    }

    public Player(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
