package view;

import controller.MainMenuController;
import controller.RestaurantMenuForUserController;
import controller.UserMenuController;
import model.DataBase.DataBase;

import java.util.regex.Matcher;

public class UserMenu {
    private UserMenuController userMenuController;
    private RestaurantMenuForUser restaurantMenuForUser;

    public UserMenu() {
        userMenuController = new UserMenuController();
        restaurantMenuForUser = new RestaurantMenuForUser();
    }

    public void run() {
        System.out.println(DataBase.getCurrentUser().getUsername() + " WELCOME TO USER MENU");
        String command;
        Matcher matcher;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to main menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+all\\s+restaurants\\s*$")) != null) {
                userMenuController.showAllRestaurantsForUser();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*search\\s+restaurant\\s+(?<restaurantName>\\S+)\\s*$")) != null) {
                userMenuController.searchRestaurantName(matcher.group("restaurantName"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*access\\s+order\\s+history\\s*$")) != null) {
                userMenuController.accessOrderHistory();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+order\\s+(?<orderId>\\S+)\\s*$")) != null) {
                userMenuController.selectOrder(matcher.group("orderId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+cart\\s+status\\s*$")) != null) {
                userMenuController.displayCartStatus();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*confirm\\s+order\\s*$")) != null) {
                userMenuController.confirmOrder();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+estimated\\s+delivery\\s+time\\s*$")) != null) {
                userMenuController.showEstimatedDeliveryTime();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*charge\\s+account\\s*$")) != null) {
                userMenuController.chargeAccount();
            } else if ((matcher= Menu.getMatcher(command,"^\\s*suggest\\s+restaurant\\s*$"))!=null) {
                userMenuController.suggestRestaurant();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+discount\\s*$"))!=null) {
                userMenuController.incentivePlan();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+account\\s+charge\\s*$")) != null) {
                userMenuController.showChargeAccount();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+(?<restaurantId>\\S+)\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("restaurantId"));
                DataBase.setCurrentRestaurantForUser(DataBase.getRestaurantById(id));
                restaurantMenuForUser.run(DataBase.getCurrentRestaurantForUser());
                System.out.println("YOU ARE IN USER MENU");
            } else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}
