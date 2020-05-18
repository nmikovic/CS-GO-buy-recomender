package rushB.CS.GO.Buy.Recommender.facts;

import java.util.Objects;

public class Armament {
    protected String name;
    protected Integer price;
    protected ArmamentType type;
    protected Side side;

    public Armament() {
    }

    public Armament(String name, Integer price, ArmamentType type, Side side) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.side = side;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ArmamentType getType() {
        return type;
    }

    public void setType(ArmamentType type) {
        this.type = type;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass())
            return false;
        Armament a = (Armament) o;
        return this.name.equals(a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
