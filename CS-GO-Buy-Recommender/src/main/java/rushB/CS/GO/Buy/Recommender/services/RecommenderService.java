package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.facts.Player;
import rushB.CS.GO.Buy.Recommender.facts.PlayerStatus;
import rushB.CS.GO.Buy.Recommender.facts.Round;

import java.util.HashMap;
import java.util.UUID;

@Service
public class RecommenderService {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private HashMap<String, Armament> armaments;
    private KieSession session;
    private Integer roundCounter = 1;

    private void prepareSession(RoundInput roundInput) {
        session = kieContainer.newKieSession("testSession");
        session.setGlobal("armaments", armaments);
        session.setGlobal("map", roundInput.getMap());
        session.insert(roundCounter);

        for (Player p : roundInput.getPlayers())
            session.insert(p);

        Round round = new Round(roundInput, roundCounter);
        session.insert(round);

        String id;
        PlayerStatus ps;
        for (String player : roundInput.getArmaments().keySet()) {
            ps = new PlayerStatus();
            ps.setCash(roundInput.getCash().get(player));
            ps.setPlayer(player);
            ps.setRound(roundCounter);

            id = UUID.randomUUID().toString();
            ps.setId(id);

            session.insert(ps);

            for (Armament a : roundInput.getArmaments().get(player)) {
                a.setPlayerStatus(id);
                session.insert(a);
            }
        }
    }

    public void recommendForRound(RoundInput roundInput) {
        prepareSession(roundInput);

        session.fireAllRules();
        session.dispose();
        roundCounter++;
    }
}
