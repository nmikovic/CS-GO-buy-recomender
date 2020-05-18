package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.Armament;

import java.util.HashMap;

@Service
public class RecommenderService {
    private final KieContainer kieContainer;
    @Autowired
    private HashMap<String, Armament> armaments;
    private KieSession session;

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
        session = this.prepareSession();
        session.insert(roundInput);
        session.fireAllRules();
    }

}
