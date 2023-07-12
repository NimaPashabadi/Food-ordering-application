package model;

import java.util.Random;

public class Rate {
    private int id;
    private Random random = new Random();
    private int outOfFive;

    public Rate(int outOfFive) {
        this.id = random.nextInt(100000);
        this.outOfFive = outOfFive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getOutOfFive() {
        return outOfFive;
    }

    public void setOutOfFive(int outOfFive) {
        this.outOfFive = outOfFive;
    }
}
