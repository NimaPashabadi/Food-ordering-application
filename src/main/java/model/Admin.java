package model;

import model.DataBase.DataBase;

import java.util.ArrayList;
import java.util.Collections;

public class Admin extends ParentUser {
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Response> responses;

    public Admin(String username, String password, String securityQuestion, String securityAnswer) {
        super(username, password, securityQuestion, securityAnswer);
        restaurants = new ArrayList<>();
        responses = new ArrayList<>();
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void getRestaurantsSorted() {
        ArrayList<String> nameOfRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            nameOfRestaurants.add(restaurant.getName());
        }
        Collections.sort(nameOfRestaurants);
        ArrayList<String> s = new ArrayList<>();
        for (String nameOfRestaurant : nameOfRestaurants) {
            for (Restaurant restaurant : restaurants) {
                if (restaurant.getName().equals(nameOfRestaurant)) {
                    String s1 = nameOfRestaurant + " " + restaurant.getId();
                    if (!s.contains(s1)) {
                        s.add(s1);
                        System.out.println(s1);
                    }
                }
            }
        }
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addResponse(Response response) {
        responses.add(response);
    }

    public Restaurant getRestaurantById(int id) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == id) return restaurant;
        }
        return null;
    }

    public Restaurant getRestaurantByName(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals("name")) return restaurant;
        }
        return null;
    }

}
