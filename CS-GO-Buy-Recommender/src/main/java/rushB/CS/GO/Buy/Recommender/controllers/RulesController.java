package rushB.CS.GO.Buy.Recommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rushB.CS.GO.Buy.Recommender.dtos.RulesDTO;
import rushB.CS.GO.Buy.Recommender.services.RulesService;

import javax.validation.Valid;

@RestController
public class RulesController {
    @Autowired
    private RulesService rulesService;

    @PostMapping("/rules")
    public ResponseEntity<Object> createRules(@Valid @RequestBody RulesDTO rules) {
        try {
            return new ResponseEntity<>(rulesService.createRules(rules), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
