package rushB.CS.GO.Buy.Recommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rushB.CS.GO.Buy.Recommender.services.RecommenderService;

@RestController
public class RecommenderController {
    @Autowired
    private RecommenderService recommenderService;

    @GetMapping("/test")
    public void test() {
        this.recommenderService.test_run();
    }
}
