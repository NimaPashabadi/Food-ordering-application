package view;

import controller.RestaurantMenuForUserController;
import model.DataBase.DataBase;
import model.Restaurant;

import java.util.regex.Matcher;

public class RestaurantMenuForUser {
    private RestaurantMenuForUserController restaurantMenuForUserController;
    public FoodMenuForUser foodMenuForUser;

    public RestaurantMenuForUser() {
        restaurantMenuForUserController = new RestaurantMenuForUserController();
        foodMenuForUser = new FoodMenuForUser();
    }

    public void run(Restaurant restaurant) {
        String command;
        Matcher matcher;
        System.out.println("WELCOME TO " + DataBase.getCurrentRestaurantForUser().getName() + " RESTAURANT");
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to user menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+restaurant\\s+menu\\s*$")) != null) {
                restaurantMenuForUserController.showFoodMenuOfRestaurant();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+comments\\s*$")) != null) {
                restaurantMenuForUserController.showRestaurantsComment();
            } else if ((Menu.getMatcher(command, "^\\s*add\\s+new\\s+comment\\s*$")) != null) {
                restaurantMenuForUserController.addNewComment();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+comment\\s+(?<commentId>\\S+)\\s*$")) != null) {
                restaurantMenuForUserController.editComment(matcher.group("commentId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+rating\\s*$")) != null) {
                restaurantMenuForUserController.showRating();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*submit\\s+rating\\s*$")) != null) {
                restaurantMenuForUserController.submitRating();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+rating\\s+(?<ratingId>\\S+)\\s*$")) != null) {
                restaurantMenuForUserController.editRating(matcher.group("ratingId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+admin\\s+response\\s+(?<ratingId>\\S+)\\s*$")) != null) {
                restaurantMenuForUserController.showResponseOfAdmin(matcher.group("ratingId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+(?<foodId>\\S+)\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("foodId"));
                DataBase.setCurrentFoodForUser(DataBase.getCurrentRestaurantForUser().getFoodById(id));
                foodMenuForUser.run(DataBase.getCurrentFoodForUser());
                System.out.println("NOW YOU ARE IN RESTAURANT MENU");
            } else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}