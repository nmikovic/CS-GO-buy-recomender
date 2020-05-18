package rushB.CS.GO.Buy.Recommender.facts;

public class Player {
    private Rank rank;
    private String name;
    private Integer cash;
    private Armaments armaments = new Armaments();
    private Score score = new Score();

    public Player() {
    }

    public Player(Rank rank, String name, Integer cash) {
        this.rank = rank;
        this.name = name;
        this.cash = cash;
    }


    public Armaments getArmaments() {
        return armaments;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setArmaments(Armaments armaments) {
        this.armaments = armaments;
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

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }
}
