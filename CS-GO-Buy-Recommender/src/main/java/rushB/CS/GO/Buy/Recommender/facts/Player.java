package rushB.CS.GO.Buy.Recommender.facts;

public class Player {
    private String name;
    private Rank rank;

    public Player() {
    }

    public Player(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
