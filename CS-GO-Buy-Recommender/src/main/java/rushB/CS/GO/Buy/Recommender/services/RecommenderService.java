package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class RecommenderService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private HashMap<String, Armament> armaments;
    private KieSession session;
    private Map map;
    private ArrayList<Player> players;
    private Integer roundCounter = 1;

    private void prepareSession(RoundInput roundInput) {
        this.session = kieContainer.newKieSession("testSession");
        this.session.setGlobal("armaments", this.armaments);
        this.session.setGlobal("map", map);
        this.session.insert(roundCounter);

        for (Player p : roundInput.getPlayers())
            this.session.insert(p);

        Round round = new Round(roundInput, roundCounter);
        this.session.insert(round);

        String id;
        PlayerStatus ps;
        for (String player : roundInput.getArmaments().keySet()) {
            ps = new PlayerStatus();
            ps.setCash(roundInput.getCash().get(player));
            ps.setPlayer(player);
            ps.setRound(roundCounter);

            id = UUID.randomUUID().toString();
            ps.setId(id);

            this.session.insert(ps);

            for (Armament a : roundInput.getArmaments().get(player)) {
                a.setPlayerStatus(id);
                this.session.insert(a);
            }
        }
    }

    public void recommendForRound(RoundInput roundInput) {
        this.prepareSession(roundInput);

        this.session.fireAllRules();
        this.session.dispose();
        this.roundCounter++;

    }
}
