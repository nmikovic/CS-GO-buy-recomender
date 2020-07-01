package rushB.CS.GO.Buy.Recommender.facts;

public class Player {
    private Rank rank;
    private String name;
    private Score score = new Score();

    public Player() {
    }

    public Player(Rank rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
