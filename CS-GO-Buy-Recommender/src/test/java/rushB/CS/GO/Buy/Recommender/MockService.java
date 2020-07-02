package rushB.CS.GO.Buy.Recommender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.facts.Player;
import rushB.CS.GO.Buy.Recommender.facts.PlayerStatus;
import rushB.CS.GO.Buy.Recommender.facts.Rank;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MockService {
    @Autowired
    private HashMap<String, Armament> armaments;

    public ArrayList<Player> returnPlayersLowerThanDMG() {
        Player p1 = new Player(Rank.GOLD_NOVA_I, "Player1");
        Player p2 = new Player(Rank.GOLD_NOVA_I, "Player2");
        Player p3 = new Player(Rank.GOLD_NOVA_I, "Player3");
        Player p4 = new Player(Rank.GOLD_NOVA_I, "Player4");
        Player p5 = new Player(Rank.GOLD_NOVA_I, "Player5");

        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);

        return players;
    }

    public ArrayList<Player> returnPlayersHigherThanDMG() {
        Player p1 = new Player(Rank.DISTINGUISHED_MASTER_GUARDIAN, "Player1");
        Player p2 = new Player(Rank.LEGENDARY_EAGLE_MASTER, "Player2");
        Player p3 = new Player(Rank.GOLD_NOVA_I, "Player3");
        Player p4 = new Player(Rank.GOLD_NOVA_I, "Player4");
        Player p5 = new Player(Rank.GOLD_NOVA_I, "Player5");

        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);

        return players;
    }

    public ArrayList<PlayerStatus> returnPlayerStatuses(Integer round, Integer cash) {
        // Integer id, String player, Integer round, Integer cash
        PlayerStatus ps1 = new PlayerStatus(0, "Player1", round, cash);
        PlayerStatus ps2 = new PlayerStatus(1, "Player2", round, cash);
        PlayerStatus ps3 = new PlayerStatus(2, "Player3", round, cash);
        PlayerStatus ps4 = new PlayerStatus(3, "Player4", round, cash);
        PlayerStatus ps5 = new PlayerStatus(4, "Player5", round, cash);

        ArrayList<PlayerStatus> playerStatuses = new ArrayList<>();
        playerStatuses.add(ps1);
        playerStatuses.add(ps2);
        playerStatuses.add(ps3);
        playerStatuses.add(ps4);
        playerStatuses.add(ps5);

        return playerStatuses;
    }

    public ArrayList<Armament> createUSPs() {
        Armament usp1 = new Armament(armaments.get("USP-S"));
        usp1.setPlayerStatus(0);
        Armament usp2 = new Armament(armaments.get("USP-S"));
        usp1.setPlayerStatus(1);
        Armament usp3 = new Armament(armaments.get("USP-S"));
        usp1.setPlayerStatus(2);
        Armament usp4 = new Armament(armaments.get("USP-S"));
        usp1.setPlayerStatus(3);
        Armament usp5 = new Armament(armaments.get("USP-S"));
        usp1.setPlayerStatus(4);

        ArrayList<Armament> usps = new ArrayList<>();
        usps.add(usp1);
        usps.add(usp2);
        usps.add(usp3);
        usps.add(usp4);
        usps.add(usp5);

        return usps;
    }
}
