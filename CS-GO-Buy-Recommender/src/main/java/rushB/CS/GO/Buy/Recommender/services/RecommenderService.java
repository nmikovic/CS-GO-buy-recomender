package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.utils.Utilities;

import java.util.ArrayList;

@Service
public class RecommenderService {
    private final KieContainer kieContainer;
    private ArrayList<Armament> armaments;

    @Autowired
    public RecommenderService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public void test_run() {
        KieSession kieSession = kieContainer.newKieSession("testSession");

        kieSession.setGlobal("armaments", this.armaments);
        kieSession.fireAllRules();
        kieSession.dispose();
    }


    @EventListener(ApplicationReadyEvent.class)
    public void loadArmaments() {
        this.armaments = Utilities.loadArmament("src/main/resources/data/armament.csv");
    }
}
