package rushB.CS.GO.Buy.Recommender;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rushB.CS.GO.Buy.Recommender.facts.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = CsGoBuyRecommenderApplication.class)
public class RulesTest {
    @Autowired
    private KieContainer kieContainer;

    private KieSession session;

    @Autowired
    private HashMap<String, Armament> armaments;

    @Autowired
    private MockService mockService;

    @Before
    public void setUp() {
        session = kieContainer.newKieSession();
        session.setGlobal("armaments", armaments);
    }

    @Test
    public void firstRoundAndAllLowerThanDMG_buyKevlarForAll() {
        session.insert(1); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(1, Side.COUNTER_TERRORIST, null, null, null, null, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(1, 800).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5,
                session.getObjects().stream()
                        .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName().equals("Kevlar"))
                        .count());

    }

    @Test
    public void firstRoundAndAllLowerThanDMG_DontBuyKevlar() {
        session.insert(1); // set round number
        mockService.returnPlayersHigherThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(1, Side.COUNTER_TERRORIST, null, null, null, null, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(1, 800).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(0,
                session.getObjects().stream()
                        .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName().equals("Kevlar"))
                        .count());

    }

}
