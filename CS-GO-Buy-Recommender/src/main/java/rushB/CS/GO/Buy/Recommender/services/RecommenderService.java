package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.MatchStartInput;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.facts.Match;

import java.util.HashMap;

@Service
public class RecommenderService {
    private final KieContainer kieContainer;
    @Autowired
    private HashMap<String, Armament> armaments;
    private KieSession session;
    private FactHandle matchHandle;
    private Match match;

    @Autowired
    public RecommenderService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    private KieSession prepareSession() {
        KieSession kieSession = kieContainer.newKieSession("testSession");
        kieSession.setGlobal("armaments", this.armaments);

        return kieSession;
    }

    public void recommendForRound(RoundInput roundInput) {
        session.insert(roundInput);
        session.fireAllRules();
    }

    public void initializeMatch(MatchStartInput matchStartInput) {
        session = this.prepareSession();
        this.match = new Match(matchStartInput, this.armaments);
        this.matchHandle = session.insert(this.match);
    }

}
