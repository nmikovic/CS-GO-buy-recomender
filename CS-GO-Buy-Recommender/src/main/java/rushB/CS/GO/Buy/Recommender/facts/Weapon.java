package rushB.CS.GO.Buy.Recommender.facts;

public class Weapon extends Armament {
    private Boolean scope;
    private Integer killBonus;
    private Boolean helmetHeadshotKill;

    public Weapon() {
        super();
    }

    public Weapon(String name, Integer price, ArmamentType type, Side side, Boolean scope, Integer killBonus, Boolean helmetHeadshotKill) {
        super(name, price, type, side);
        this.scope = scope;
        this.killBonus = killBonus;
        this.helmetHeadshotKill = helmetHeadshotKill;
    }

    public Boolean getScope() {
        return scope;
    }

    public void setScope(Boolean scope) {
        this.scope = scope;
    }

    public Integer getKillBonus() {
        return killBonus;
    }

    public void setKillBonus(Integer killBonus) {
        this.killBonus = killBonus;
    }

    public Boolean getHelmetHeadshotKill() {
        return helmetHeadshotKill;
    }

    public void setHelmetHeadshotKill(Boolean helmetHeadshotKill) {
        this.helmetHeadshotKill = helmetHeadshotKill;
    }
}
