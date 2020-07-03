package rushB.CS.GO.Buy.Recommender.dtos;

import javax.validation.constraints.NotBlank;

public class RulesDTO {
    @NotBlank
    private String rules;

    public RulesDTO(String rules) {
        this.rules = rules;
    }

    public RulesDTO() {
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}
