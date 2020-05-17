package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.MatchStartInput;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.facts.Match;
import rushB.CS.GO.Buy.Recommender.utils.Utilities;

import java.util.ArrayList;

@Service
public class RecommenderService {
    private final KieContainer kieContainer;
    private ArrayList<Armament> armaments;
    private KieSession session;

    @Autowired
    public RecommenderService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void loadArmaments() {
        this.armaments = Utilities.loadArmament("src/main/resources/data/armament.csv");
    }

    private KieSession prepareSession() {
        KieSession kieSession = kieContainer.newKieSession("testSession");
        kieSession.setGlobal("armaments", this.armaments);

        return kieSession;
    }

    public void recommendForRound(RoundInput roundInput) {
        session.insert(roundInput);

        session.fireAllRules();
        session.dispose();
    }

    public void initializeMatch(MatchStartInput matchStartInput) {
        session = this.prepareSession();
        session.setGlobal("match", new Match(matchStartInput));
    }

}
