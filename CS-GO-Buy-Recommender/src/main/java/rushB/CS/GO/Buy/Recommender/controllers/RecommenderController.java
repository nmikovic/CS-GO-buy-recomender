package rushB.CS.GO.Buy.Recommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rushB.CS.GO.Buy.Recommender.services.TestService;

@RestController
public class RecommenderController {
    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public void test() {
        this.testService.test_run();
    }
}
