package rushB.CS.GO.Buy.Recommender.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final KieContainer kieContainer;

    @Autowired
    public TestService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public void test_run() {
        KieSession kieSession = kieContainer.newKieSession("testSession");
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
