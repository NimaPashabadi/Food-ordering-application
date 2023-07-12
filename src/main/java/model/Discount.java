package model;
import java.util.Random;

public class Discount {
    private int id;
    private Random random = new Random();
    private double price;
    private double time;

    public Discount(double price, double time) {
        this.price = price;
        this.id = random.nextInt(100000);
        this.time= time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
