package rushB.CS.GO.Buy.Recommender.facts;

public class Player {
    private Rank rank;
    private String name;

    public Player() {
    }

    public Player(Rank rank, String name) {
        this.rank = rank;
        this.name = name;
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
