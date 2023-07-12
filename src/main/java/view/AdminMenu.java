package view;

import controller.AdminMenuController;
import model.DataBase.DataBase;

import java.util.regex.Matcher;

public class AdminMenu {
    private AdminMenuController adminMenuController;
    private RestaurantMenuForAdmin restaurantMenuForAdmin;

    public AdminMenu() {
        adminMenuController = new AdminMenuController();
        restaurantMenuForAdmin = new RestaurantMenuForAdmin();
    }

    public void run() {
        Matcher matcher;
        String command;
        System.out.println("WELCOME TO ADMIN MENU " + DataBase.getCurrentAdmin().getUsername());
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*(b|B)(a|A)(c|C)(k|K)\\s+(T|t)(O|o)\\s+(m|M)(a|A)in\\s+(m|M)(e|E)(n|N)(u|U)\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+restaurant\\s+(?<restaurantName>\\S+)\\s+(?<location>\\S+)\\s*$")) != null) {
                adminMenuController.addRestaurant(matcher.group("restaurantName"), matcher.group("location"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+all\\s+restaurants\\s*$")) != null) {
                adminMenuController.showAllRestaurants();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*select\\s+(?<restaurantId>\\S+)\\s*$")) != null) {
                int id = Integer.parseInt(matcher.group("restaurantId"));
                DataBase.setCurrentRestaurantForAdmin(DataBase.getCurrentAdmin().getRestaurantById(id));
                restaurantMenuForAdmin.run(DataBase.getCurrentRestaurantForAdmin());
                System.out.println("NOW YOU ARE IN ADMIN MENU");
            }else {
                System.out.println("INVALID COMMAND!");

            }
        }
    }
}

