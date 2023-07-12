package controller;
import model.Node;
import model.Admin;
import model.DataBase.DataBase;
import model.Restaurant;

public class AdminMenuController {
    public AdminMenuController() {}
    public void addRestaurant(String restaurantName, String location){
        Node node = DataBase.getNodeByName(location);
        Restaurant restaurant = new Restaurant(restaurantName, node);
        restaurant.setAdmin(DataBase.getCurrentAdmin());
        DataBase.getCurrentAdmin().addRestaurant(restaurant);
        DataBase.addRestaurant(restaurant);
        System.out.println("RESTAURANT ADDED SUCCESSFULLY");

    }
    public void showAllRestaurants(){
        DataBase.getCurrentAdmin().getRestaurantsSorted();
    }
}
