package rushB.CS.GO.Buy.Recommender.dtos;

public class RulesDTO {
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
