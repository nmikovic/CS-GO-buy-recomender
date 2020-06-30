package rushB.CS.GO.Buy.Recommender.facts;

import java.io.Serializable;

public class Armament {
    protected Integer playerStatus;
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

    public Armament(Armament other) {
        this.name = other.name;
        this.price = other.price;
        this.type = other.type;
        this.side = other.side;
    }

    public Integer getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(Integer playerStatus) {
        this.playerStatus = playerStatus;
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

}
