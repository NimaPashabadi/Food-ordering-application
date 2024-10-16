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
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+restaurant\\s+location\\s+(?<newLocation>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editRestaurantLocation(matcher.group("newLocation"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*determine\\s+restaurant\\s+food\\s+type\\s*$")) != null) {
                restaurantMenuForAdminController.determineRestaurantFoodType();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+restaurant\\s+food\\s+type\\s*$")) != null) {
                restaurantMenuForAdminController.showRestaurantFoodType();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+restaurant\\s+food\\s+type\\s*$")) != null) {
                restaurantMenuForAdminController.editRestaurantFoodType();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+menu\\s*$")) != null) {
                restaurantMenuForAdminController.selectMenuOfRestaurant();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+food\\s+(?<foodId>\\S+)\\s+name\\s+(?<newName>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editFoodName(matcher.group("foodId"), matcher.group("newName"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+food\\s+(?<foodId>\\S+)\\s+price\\s+(?<newPrice>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editFoodPrice(matcher.group("foodId"), matcher.group("newPrice"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+food\\s+(?<foodName>\\S+)\\s+(?<price>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.addFoodToRestaurant(matcher.group("foodName"), matcher.group("price"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*delete\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.deleteFoodFromRestaurant(matcher.group("foodId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*deactivate\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.deactivateFoodFromRestaurant(matcher.group("foodId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*active\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.activeFoodFromRestaurant(matcher.group("foodId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*discount\\s+food\\s+(?<foodId>\\S+)\\s+(?<discountAmount>\\S+)\\s+(?<timestamp>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.discountFood(matcher.group("foodId"), matcher.group("discountAmount"), matcher.group("timestamp"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*delete\\s+discount\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.deleteDiscountFood(matcher.group("foodId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+open\\s+orders\\s*$")) != null) {
                restaurantMenuForAdminController.displayOnlineOrders();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+order\\s+(?<orderId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editOnlineOrder(matcher.group("orderId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+order\\s+history\\s*$")) != null) {
                restaurantMenuForAdminController.showOrderHistory();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+comments\\s*$")) != null) {
                restaurantMenuForAdminController.displayComments();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+rating\\s*$")) != null) {
                restaurantMenuForAdminController.displayRating();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+new\\s+response\\s+(?<commentId>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.addNewResponse(matcher.group("commentId"), matcher.group("message"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+response\\s+(?<commentId>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.editResponse(matcher.group("commentId"), matcher.group("message"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+response\\s+of\\s+(?<commentId>\\S+)\\s*$")) != null) {
                restaurantMenuForAdminController.showResponseOfComment(matcher.group("commentId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+food\\s+(?<foodId>\\S+)\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("foodId"));
                DataBase.setCurrentFoodForAdmin(DataBase.getCurrentRestaurantForAdmin().getFoodById(id));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
                foodMenuForAdmin.run(DataBase.getCurrentFoodForAdmin());
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
                System.out.println("NOW YOU ARE IN RESTAURANT MENU");
            } else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}