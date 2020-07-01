package rushB.CS.GO.Buy.Recommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.services.RecommenderService;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class RecommenderController {
    @Autowired
    private RecommenderService recommenderService;

    @PostMapping("/recommend")
    public HashMap<String, ArrayList<Armament>> recommendForRound(@RequestBody RoundInput roundInput) {
        return recommenderService.recommendForRound(roundInput);
    }
}
