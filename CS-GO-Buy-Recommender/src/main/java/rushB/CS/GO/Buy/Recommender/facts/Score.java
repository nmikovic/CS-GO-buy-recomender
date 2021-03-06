package rushB.CS.GO.Buy.Recommender.facts;

public class Score {
    private Integer kills = 0;
    private Integer deaths = 0;
    private Integer assists = 0;

    public Score() {
    }

    public Score(Integer kills, Integer deaths, Integer assists) {
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }
}
