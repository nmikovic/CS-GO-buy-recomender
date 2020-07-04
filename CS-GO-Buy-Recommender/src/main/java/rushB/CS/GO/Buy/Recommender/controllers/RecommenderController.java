package rushB.CS.GO.Buy.Recommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rushB.CS.GO.Buy.Recommender.dtos.RoundInput;
import rushB.CS.GO.Buy.Recommender.facts.Armament;
import rushB.CS.GO.Buy.Recommender.services.RecommenderService;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin
public class RecommenderController {
    @Autowired
    private RecommenderService recommenderService;

    @PostMapping("/recommend")
    public ResponseEntity<HashMap<String, ArrayList<Armament>>>recommendForRound(@RequestBody RoundInput roundInput) {

        return new ResponseEntity<>(recommenderService.recommendForRound(roundInput), HttpStatus.OK);
    }


    @GetMapping("/armaments")
    public ResponseEntity<HashMap<String, Armament>> getArmaments(){
        return new ResponseEntity<>(recommenderService.getArmaments(), HttpStatus.OK);
    }
}
