package view;

import controller.RestaurantMenuForAdminController;
import model.DataBase.DataBase;
import model.Restaurant;

import java.util.regex.Matcher;

public class RestaurantMenuForAdmin {
    private RestaurantMenuForAdminController restaurantMenuForAdminController;
    private FoodMenuForAdmin foodMenuForAdmin;

    public RestaurantMenuForAdmin() {
        restaurantMenuForAdminController = new RestaurantMenuForAdminController();
        foodMenuForAdmin = new FoodMenuForAdmin();
    }

    public void run(Restaurant currentRestaurant) {
        String command;
        Matcher matcher;
        System.out.println("WELCOME TO " + DataBase.getCurrentRestaurantForAdmin().getName() + " RESTAURANT");
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to admin menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+restaurant\\s+location\\s*$")) != null) {
                restaurantMenuForAdminController.showRestaurantLocation();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+restaurant\\s+location\\s+(?<newLocation>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editRestaurantLocation(matcher.group("newLocation"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*determine\\s+restaurant\\s+food\\s+type\\s*$")) != null) {
                restaurantMenuForAdminController.determineRestaurantFoodType();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+restaurant\\s+food\\s+type\\s*$")) != null) {
                restaurantMenuForAdminController.showRestaurantFoodType();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+restaurant\\s+food\\s+type\\s*$")) != null) {
                restaurantMenuForAdminController.editRestaurantFoodType();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+menu\\s*$")) != null) {
                restaurantMenuForAdminController.selectMenuOfRestaurant();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+food\\s+(?<foodId>\\S+)\\s+name\\s+(?<newName>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editFoodName(matcher.group("foodId"), matcher.group("newName"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+food\\s+(?<foodId>\\S+)\\s+price\\s+(?<newPrice>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editFoodPrice(matcher.group("foodId"), matcher.group("newPrice"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+food\\s+(?<foodName>\\S+)\\s+(?<price>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.addFoodToRestaurant(matcher.group("foodName"), matcher.group("price"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*delete\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.deleteFoodFromRestaurant(matcher.group("foodId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*deactivate\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.deactivateFoodFromRestaurant(matcher.group("foodId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*active\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.activeFoodFromRestaurant(matcher.group("foodId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*discount\\s+food\\s+(?<foodId>\\S+)\\s+(?<discountAmount>\\S+)\\s+(?<timestamp>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.discountFood(matcher.group("foodId"), matcher.group("discountAmount"), matcher.group("timestamp"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*delete\\s+discount\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.deleteDiscountFood(matcher.group("foodId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+open\\s+orders\\s*$")) != null) {
                restaurantMenuForAdminController.displayOnlineOrders();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+order\\s+(?<orderId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editOnlineOrder(matcher.group("orderId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+order\\s+history\\s*$")) != null) {
                restaurantMenuForAdminController.showOrderHistory();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+comments\\s*$")) != null) {
                restaurantMenuForAdminController.displayComments();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+rating\\s*$")) != null) {
                restaurantMenuForAdminController.displayRating();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+new\\s+response\\s+(?<commentId>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.addNewResponse(matcher.group("commentId"), matcher.group("message"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+response\\s+(?<commentId>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editResponse(matcher.group("commentId"), matcher.group("message"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+response\\s+of\\s+(?<commentId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.showResponseOfComment(matcher.group("commentId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("foodId"));
                DataBase.setCurrentFoodForAdmin(DataBase.getCurrentRestaurantForAdmin().getFoodById(id));
                foodMenuForAdmin.run(DataBase.getCurrentFoodForAdmin());
                System.out.println("NOW YOU ARE IN RESTAURANT MENU");
            } else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}