package rushB.CS.GO.Buy.Recommender;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rushB.CS.GO.Buy.Recommender.facts.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @After
    public void dispose() {
        session.dispose();
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

    @Test
    public void secondRoundAndCashLowerThan3000_ECO() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, null, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 2000).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(1, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Round.class) && ((Round) o).getCurrentTeamState()
                        .equals(BuyOptions.ECO)).count());
    }

    @Test
    public void secondRoundAndCashBetween3000And4000_HALF_BUY() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, null, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 3300).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(1, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Round.class) && ((Round) o).getCurrentTeamState()
                        .equals(BuyOptions.HALF_BUY)).count());
    }

    @Test
    public void secondRoundAndCashAbove4000_FULL_BUY() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, null, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 4300).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(1, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Round.class) && ((Round) o).getCurrentTeamState()
                        .equals(BuyOptions.FULL_BUY)).count());
    }

    @Test
    public void ECOAndCTAndCacheAndOffensive_buyP250() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 2000).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("P250")).count());
    }

    @Test
    public void ECOAndCTAndCacheAndOffensive_buy2Grenades() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 2300).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(2, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("Grenade")).count());
    }

    @Test
    public void ECOAndTAndCacheAndOffensive_buyTec9() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 2000).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createGlocks().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("Tec-9")).count());
    }

    @Test
    public void HALF_BUYAndCTAndCacheAndOffensive_buyMP9() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 3400).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("MP-9")).count());
    }

    @Test
    public void HALF_BUYAndTAndCacheAndOffensive_buyMAC_10() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 3400).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createGlocks().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("MAC-10")).count());
    }

    @Test
    public void FULL_BUYAndCTAndCacheAndOffensive_buyM4A1_S() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 5000).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("M4A1-S")).count());
    }

    @Test
    public void FULL_BUYAndCTAndCacheAndOffensive_buyFamas() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.COUNTER_TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 4000).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createUSPs().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("Famas")).count());
    }

    @Test
    public void FULL_BUYAndT_buyAK_47() {
        session.insert(2); // set round number
        mockService.returnPlayersLowerThanDMG().forEach(p -> session.insert(p)); // insert players

        Round round = new Round(2, Side.TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 5000).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createGlocks().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        assertEquals(5, session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("AK-47")).count());
    }

    @Test
    public void test_query() {
        session.insert(2); // set round number
        ArrayList<Player> players = mockService.returnPlayersLowerThanDMG();

        players.forEach(p -> session.insert(p));

        Round round = new Round(2, Side.TERRORIST, null, null, null, Tactic.OFFENSIVE, null, null, Map.CACHE);
        session.insert(round); // insert round

        mockService.returnPlayerStatuses(2, 5000).forEach(ps -> session.insert(ps)); // insert player statuses
        mockService.createGlocks().forEach(usp -> session.insert(usp));

        session.fireAllRules();

        QueryResults results;
        ArrayList<Armament> armaments = new ArrayList<>();

        for (Player p : players) {
            results = session.getQueryResults("Extract players' armaments", p.getName());

            for (QueryResultsRow row : results) {
                armaments.add((Armament) row.get("$armaments"));
            }
        }

        assertEquals(session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("AK-47")).count(), armaments.stream()
                .filter(o -> o.getName().equals("AK-47")).count());

        assertEquals(session.getObjects().stream()
                .filter(o -> o.getClass().equals(Armament.class) && ((Armament) o).getName()
                        .equals("Kevlar+Helmet")).count(), armaments.stream()
                .filter(o -> o.getName().equals("Kevlar+Helmet")).count());
    }

}
