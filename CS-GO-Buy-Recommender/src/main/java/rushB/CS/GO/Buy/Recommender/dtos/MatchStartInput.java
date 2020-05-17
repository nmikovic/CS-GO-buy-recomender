package rushB.CS.GO.Buy.Recommender.dtos;

import rushB.CS.GO.Buy.Recommender.facts.Map;
import rushB.CS.GO.Buy.Recommender.facts.Player;
import rushB.CS.GO.Buy.Recommender.facts.Side;

import java.util.ArrayList;

public class MatchStartInput {
    private Side side;
    private Map map;
    private ArrayList<Player> teammates;

    public MatchStartInput() {
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public ArrayList<Player> getTeammates() {
        return teammates;
    }

    public void setTeammates(ArrayList<Player> teammates) {
        this.teammates = teammates;
    }
}
