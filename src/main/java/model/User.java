package model;

import java.util.ArrayList;

public class User extends ParentUser {
    private double discount;
    private ArrayList<Discount> discounts;
    private Node location;
    private ArrayList<Order> allOrder;
    private ArrayList<Order> onlineOrder;
    private ArrayList<Food> cart;
    private Order lastOrder;
    private double budget;


    public User(String username, String password, String securityQuestion, String securityAnswer) {
        super(username, password, securityQuestion, securityAnswer);
        this.discount = discount;
        this.allOrder = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.onlineOrder = new ArrayList<>();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Node getLocation() {
        return location;
    }

    public ArrayList<Order> getOrders() {
        return allOrder;
    }

    public void setLocation(Node location) {
        this.location = location;
    }

    public void addFoodToCart(Food food) {
        cart.add(food);
    }

    public ArrayList<Food> getCart() {
        return cart;
    }


    public Order getOrderById(int id) {
        for (Order order : allOrder) {
            if (order.getId() == id) return order;
        }
        return null;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ArrayList<Order> getOnlineOrder() {
        return onlineOrder;
    }


    public void addOrder(Order order) {
        onlineOrder.add(order);
        allOrder.add(order);
    }

    public Order getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(Order lastOrder) {
        this.lastOrder = lastOrder;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
}