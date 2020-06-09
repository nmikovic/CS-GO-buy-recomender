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


    private Integer prepareSession() {
        this.session = kieContainer.newKieSession("testSession");
        this.session.setGlobal("armaments", this.armaments);
        this.session.insert(new Integer(1));

        return 1;
    }

    private Integer getCurrentRound() {
        QueryResults results = this.session.getQueryResults("Get current round");

        for (QueryResultsRow row : results) {
            return ((Integer) row.get("$rn"));
        }

        return null;
    }

    public void recommendForRound(RoundInput roundInput) {
        Integer currentRound = this.session == null ? this.prepareSession() : this.getCurrentRound();

        if(currentRound != 1){
            Integer save = currentRound;
            this.session.dispose();
            this.session = kieContainer.newKieSession("testSession");
            this.session.setGlobal("armaments", this.armaments);
            this.session.insert(new Integer (save));
            currentRound = save;
        }
        Round round = new Round(roundInput, currentRound);

        this.session.insert(round);

        if (currentRound == 1) {
            this.map = roundInput.getMap();
            this.players = roundInput.getPlayers();
            this.session.setGlobal("map", roundInput.getMap());

            for (Player p : roundInput.getPlayers())
                this.session.insert(p);
        }

        String id;
        PlayerStatus ps;
        for (String player : roundInput.getArmaments().keySet()) {
            ps = new PlayerStatus();
            ps.setCash(roundInput.getCash().get(player));
            ps.setPlayer(player);
            ps.setRound(currentRound);

            id = UUID.randomUUID().toString();
            ps.setId(id);

            this.session.insert(ps);

            for (Armament a : roundInput.getArmaments().get(player)) {
                a.setPlayerStatus(id);
                this.session.insert(a);
            }
        }

        this.session.fireAllRules();

    }
}
