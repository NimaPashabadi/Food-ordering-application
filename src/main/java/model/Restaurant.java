package model;

import model.DataBase.DataBase;
import model.DataBase.DataBase;
import java.util.Random;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private Mapi loc;
    private Admin admin;
    private int id;
    private boolean isThereOrder;
    private Node location;
    Random rand = new Random();
    private ArrayList<Order> allOrders;
    private ArrayList<FoodType> restaurantType;
    private ArrayList<Food> menu;
    private ArrayList<Order> onlineOrder;
    private ArrayList<Comment> comments;
    private ArrayList<Rate> rates;

    public Restaurant(String name, Mapi loc) {
        this.name = name;
        this.admin = admin;
        this.loc = loc;
        allOrders = new ArrayList<>();
        menu = new ArrayList<>();
        onlineOrder = new ArrayList<>();
        restaurantType = new ArrayList<>();
        int n = rand.nextInt(100000);
        for (Restaurant restaurant : DataBase.getRestaurants() ) {
            if(n!=restaurant.getId()){
                this.id = n;
            }
        }
        this.location = location;
        this.isThereOrder = false;
        this.comments = new ArrayList<>();
        this.rates = new ArrayList<>();
    }


    public boolean isThereOrder() {
        return isThereOrder;
    }

    public void setThereOrder(boolean thereOrder) {
        isThereOrder = thereOrder;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Node getLocation() {
        return location;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(Node location) {
        this.location = location;
    }

    public Admin getAdmin() {
        return admin;
    }



    public ArrayList<Order> getOrders() {
        return allOrders;
    }

    public ArrayList<FoodType> getRestaurantType() {
        return restaurantType;
    }

    public ArrayList<Food> getMenu() {
        return menu;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public void setOrders(ArrayList<Order> orders) {
        this.allOrders = orders;
    }

    public void setRestaurantType(ArrayList<FoodType> restaurantType) {
        this.restaurantType = restaurantType;
    }

    public void setMenu(ArrayList<Food> menu) {
        this.menu = menu;
    }
    public void selectMenuForShowingFoods(){
        for (Food food : menu) {
            System.out.println(food.getName() + " "+ food.getCost() + "T "+ food.getId());
        }
    }
    public Food getFoodById(int id){
        for (Food food : menu) {
            if(food.getId()==id)
                return food;
        }
        return null;
    }
    public void addFoodToMenu(Food food){
        menu.add(food);
    }

    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public ArrayList<Order> getOnlineOrder() {
        return onlineOrder;
    }
    public Order getOnlineOrderById(int id){
        for (Order order : onlineOrder) {
            if(order.getId()==id) return order;
        }
        return null;
    }
    public void addOrder(Order order){
        onlineOrder.add(order);
        allOrders.add(order);
    }
    public Order getOrderById(int id){
        for (Order order : onlineOrder) {
            if(order.getId()==id) return order;
        }
        return null;
    }
    public void addFoodType(FoodType foodType){
        restaurantType.add(foodType);
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    public Comment getCommentById(int id){
        for (Comment comment : comments) {
            if(comment.getId()==id) return comment;
        }
        return null;
    }
    public Rate getRateById(int id){
        for (Rate rate : rates) {
            if(rate.getId()==id) return rate;
        }
        return null;
    }
    public void addRate(Rate rate){
        rates.add(rate);
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public Mapi getLoc() {
        return loc;
    }

    public void setLoc(Mapi loc) {
        this.loc = loc;
    }
}
