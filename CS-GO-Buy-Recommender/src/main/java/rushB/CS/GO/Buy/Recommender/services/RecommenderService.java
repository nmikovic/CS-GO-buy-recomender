package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.facts.Player;
import rushB.CS.GO.Buy.Recommender.facts.PlayerStatus;
import rushB.CS.GO.Buy.Recommender.facts.Round;


import java.util.ArrayList;
import java.util.HashMap;

@Service
public class RecommenderService {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private HashMap<String, Armament> armaments;
    private KieSession session;
    private Integer roundCounter = 1;

    private void prepareSession(RoundInput roundInput) {
        session = kieContainer.newKieSession();
        session.setGlobal("armaments", armaments);
        session.setGlobal("map", roundInput.getMap());
        session.insert(roundCounter);

        for (Player p : roundInput.getPlayers())
            session.insert(p);

        Round round = new Round(roundInput, roundCounter);
        session.insert(round);

        PlayerStatus ps;
        int id = 0;
        for (String player : roundInput.getArmaments().keySet()) {
            ps = new PlayerStatus();
            ps.setCash(roundInput.getCash().get(player));
            ps.setPlayer(player);
            ps.setRound(roundCounter);

            ps.setId(id);

            session.insert(ps);

            for (Armament a : roundInput.getArmaments().get(player)) {
                a.setPlayerStatus(id);
                session.insert(a);
            }
            id++;
        }
    }

    private HashMap<String, ArrayList<Armament>> queryArmaments(ArrayList<Player> players) {
        HashMap<String, ArrayList<Armament>> playerArmaments = new HashMap<>();

        QueryResults results;
        ArrayList<Armament> armaments;
        for (Player p : players) {
            results = session.getQueryResults("Extract players' armaments", p.getName());

            armaments = new ArrayList<>();
            for (QueryResultsRow row : results) {
                armaments.add((Armament) row.get("$armaments"));
            }
            playerArmaments.put(p.getName(), armaments);
        }

        return playerArmaments;
    }

    public HashMap<String, ArrayList<Armament>> recommendForRound(RoundInput roundInput) {
        prepareSession(roundInput);

        session.fireAllRules();

        HashMap<String, ArrayList<Armament>> results = queryArmaments(roundInput.getPlayers());

        session.dispose();
        roundCounter++;

        return results;
    }
}
