package model;
import java.util.ArrayList;
import java.util.Random;

public class Food {
    private String name;
    private int id;
    private boolean isActive;
    private double cost;
    private Random rand = new Random();
    private String comment;
    private double costAfterDiscount;
    private ArrayList<Comment> comments;
    private ArrayList<Rate> Rates;
    private boolean isThereDiscount;
    private Discount discount;


    public Food(String name, double cost) {
        this.name = name;
        int n = rand.nextInt(100000);
        this.id = n;
        this.cost = cost;
        this.discount = discount;
        this.comment = comment;
        this.Rates = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.isActive = true;
        this.isThereDiscount = false;
        this.costAfterDiscount=costAfterDiscount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }


    public String getComment() {
        return comment;
    }


    public ArrayList<Comment> getCommentAndRatings() {
        return comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public void setCommentAndRatings(ArrayList<Comment> commentAndRatings) {
        this.comments = commentAndRatings;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Rate> getRates() {
        return Rates;
    }

    public boolean isThereDiscount() {
        return isThereDiscount;
    }

    public void setThereDiscount(boolean thereDiscount) {
        isThereDiscount = thereDiscount;
    }

    public Comment getCommentById(int id) {
        for (Comment comment : comments) {
            if (comment.getId() == id) return comment;
        }
        return null;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addRating(Rate rate) {
        Rates.add(rate);
    }

    public Rate getRateById(int id) {
        for (Rate rate : Rates) {
            if (rate.getId() == id) return rate;
        }
        return null;
    }

    public double getCostAfterDiscount() {
        return costAfterDiscount;
    }

    public void setCostAfterDiscount(double costAfterDiscount) {
        this.costAfterDiscount = costAfterDiscount;
    }
}
