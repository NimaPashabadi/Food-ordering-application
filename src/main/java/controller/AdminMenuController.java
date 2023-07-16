package controller;
import model.Mapi;
import model.Node;
import model.Admin;
import model.DataBase.DataBase;
import model.Restaurant;

public class AdminMenuController {
    public AdminMenuController() {}
    public void addRestaurant(String restaurantName, String location){
        int map = Integer.parseInt(location);
        Mapi mapi = new Mapi(map);
        Restaurant restaurant = new Restaurant(restaurantName, mapi);
        restaurant.setAdmin(DataBase.getCurrentAdmin());
        DataBase.getCurrentAdmin().addRestaurant(restaurant);
        DataBase.addRestaurant(restaurant);
        System.out.println("RESTAURANT ADDED SUCCESSFULLY");

    }
    public void showAllRestaurants(){
        DataBase.getCurrentAdmin().getRestaurantsSorted();
    }
}
