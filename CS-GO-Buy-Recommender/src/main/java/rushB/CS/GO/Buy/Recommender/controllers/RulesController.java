package rushB.CS.GO.Buy.Recommender.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rushB.CS.GO.Buy.Recommender.dtos.RulesDTO;
import rushB.CS.GO.Buy.Recommender.services.RulesService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class RulesController {
    @Autowired
    private RulesService rulesService;

    @PostMapping("/rules")
    public ResponseEntity<Object> createRules(@Valid @RequestBody RulesDTO rules) {
        try {
            return new ResponseEntity<>(rulesService.createRules(rules), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/facts")
    public ResponseEntity<ArrayList<String>> getFactClasses() {
        return new ResponseEntity<>(rulesService.getFactClasses(), HttpStatus.OK);
    }

    @GetMapping("/facts/{name}")
    public ResponseEntity<Object> getFactContent(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<>(rulesService.getFactContent(name), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Invalid fact name", HttpStatus.BAD_REQUEST);
        }
    }
}
