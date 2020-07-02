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


    public ArrayList<PlayerStatus> returnPlayerStatusesFullCash(Integer round) {
        PlayerStatus ps1 = new PlayerStatus(0, "Player1", round, 16000);
        PlayerStatus ps2 = new PlayerStatus(1, "Player2", round, 16000);
        PlayerStatus ps3 = new PlayerStatus(2, "Player3", round, 16000);
        PlayerStatus ps4 = new PlayerStatus(3, "Player4", round, 16000);
        PlayerStatus ps5 = new PlayerStatus(4, "Player5", round, 16000);

        ArrayList<PlayerStatus> playerStatuses = new ArrayList<>();
        playerStatuses.add(ps1);
        playerStatuses.add(ps2);
        playerStatuses.add(ps3);
        playerStatuses.add(ps4);
        playerStatuses.add(ps5);

        return playerStatuses;
    }


    public ArrayList<PlayerStatus> returnPlayerStatusesFullTeamGrenade(Integer round) {
        PlayerStatus ps1 = new PlayerStatus(0, "Player1", round, 4200);
        PlayerStatus ps2 = new PlayerStatus(1, "Player2", round, 4800);
        PlayerStatus ps3 = new PlayerStatus(2, "Player3", round, 4800);
        PlayerStatus ps4 = new PlayerStatus(3, "Player4", round, 4800);
        PlayerStatus ps5 = new PlayerStatus(4, "Player5", round, 4480);

        ArrayList<PlayerStatus> playerStatuses = new ArrayList<>();
        playerStatuses.add(ps1);
        playerStatuses.add(ps2);
        playerStatuses.add(ps3);
        playerStatuses.add(ps4);
        playerStatuses.add(ps5);

        return playerStatuses;
    }

    public ArrayList<PlayerStatus> returnPlayerStatusesForOneFireGrenade(Integer round) {
        PlayerStatus ps1 = new PlayerStatus(0, "Player1", round, 3800);
        PlayerStatus ps2 = new PlayerStatus(1, "Player2", round, 3800);
        PlayerStatus ps3 = new PlayerStatus(2, "Player3", round, 3800);
        PlayerStatus ps4 = new PlayerStatus(3, "Player4", round, 3800);
        PlayerStatus ps5 = new PlayerStatus(4, "Player5", round, 4480);

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
        usp2.setPlayerStatus(1);
        Armament usp3 = new Armament(armaments.get("USP-S"));
        usp3.setPlayerStatus(2);
        Armament usp4 = new Armament(armaments.get("USP-S"));
        usp4.setPlayerStatus(3);
        Armament usp5 = new Armament(armaments.get("USP-S"));
        usp5.setPlayerStatus(4);

        ArrayList<Armament> usps = new ArrayList<>();
        usps.add(usp1);
        usps.add(usp2);
        usps.add(usp3);
        usps.add(usp4);
        usps.add(usp5);

        return usps;
    }

    public ArrayList<Armament> createArmamentWithSomeRifles(){
        Armament usp1 = new Armament(armaments.get("USP-S"));
        Armament rifle1 = new Armament(armaments.get("M4A1-S"));
        usp1.setPlayerStatus(0);
        rifle1.setPlayerStatus(0);


        Armament usp2 = new Armament(armaments.get("USP-S"));
        usp2.setPlayerStatus(1);


        Armament usp3 = new Armament(armaments.get("USP-S"));
        Armament rifle3 = new Armament(armaments.get("M4A1-S"));
        usp3.setPlayerStatus(2);
        rifle3.setPlayerStatus(2);

        Armament usp4 = new Armament(armaments.get("USP-S"));
        usp4.setPlayerStatus(3);


        Armament usp5 = new Armament(armaments.get("USP-S"));
        usp5.setPlayerStatus(4);

        ArrayList<Armament> weapons = new ArrayList<>();
        weapons.add(usp1);
        weapons.add(rifle1);
        weapons.add(rifle3);
        weapons.add(usp2);
        weapons.add(usp3);
        weapons.add(usp4);
        weapons.add(usp5);

        return weapons;
    }

    public ArrayList<Armament> createGlocks() {
        Armament glock1 = new Armament(armaments.get("Glock-18"));
        glock1.setPlayerStatus(0);
        Armament glock2 = new Armament(armaments.get("Glock-18"));
        glock2.setPlayerStatus(1);
        Armament glock3 = new Armament(armaments.get("Glock-18"));
        glock3.setPlayerStatus(2);
        Armament glock4 = new Armament(armaments.get("Glock-18"));
        glock4.setPlayerStatus(3);
        Armament glock5 = new Armament(armaments.get("Glock-18"));
        glock5.setPlayerStatus(4);

        ArrayList<Armament> glocks = new ArrayList<>();
        glocks.add(glock1);
        glocks.add(glock2);
        glocks.add(glock3);
        glocks.add(glock4);
        glocks.add(glock5);

        return glocks;
    }
}
