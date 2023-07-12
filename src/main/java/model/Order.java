package model;

import model.DataBase.DataBase;

import java.util.ArrayList;
import java.util.Random;

public class Order
{
    private String status;

    private Random random = new Random();

    private ArrayList<Order> allOrders = new ArrayList<>();
    private ArrayList<Food> foods;
    private int id;
    private double cost;
    private boolean DoesHasDelivery;
    private Restaurant restaurant;
    private User user;
    private Node location;
    private double time;
    private Delivery delivery;

    public Order() {
        this.status = status;
        this.allOrders = allOrders;
        this.foods = foods;
        this.id = random.nextInt(10000);
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAllOrders(ArrayList<Order> allOrders) {
        this.allOrders = allOrders;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public boolean isDoesHasDelivery() {
        return DoesHasDelivery;
    }

    public void setDoesHasDelivery(boolean doesHasDelivery) {
        DoesHasDelivery = doesHasDelivery;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
