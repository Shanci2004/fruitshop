package model;

public class Recommend {
    private int id;
    private int fruitId;
    private int type;   //1HOT 2NEW

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Recommend(int id, int fruitId, int type) {
        this.id = id;
        this.fruitId = fruitId;
        this.type = type;
    }

    public Recommend() {
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "id=" + id +
                ", fruitId=" + fruitId +
                ", type=" + type +
                '}';
    }
}
