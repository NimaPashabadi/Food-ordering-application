package view;

import controller.FoodMenuForAdminController;
import model.DataBase.DataBase;
import model.Food;
import model.Node;

import java.util.regex.Matcher;

public class FoodMenuForAdmin {
    private FoodMenuForAdminController foodMenuForAdminController;

    public FoodMenuForAdmin() {
        foodMenuForAdminController =  new FoodMenuForAdminController();
    }

    public void run(Food food) {
        String command;
        Matcher matcher;
        System.out.println("WELCOME TO " + DataBase.getCurrentFoodForAdmin().getName() + " MENU");
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to restaurant menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+rating\\s*$")) != null) {
                foodMenuForAdminController.showRating();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+comments\\s*$")) != null) {
                foodMenuForAdminController.displayComments();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+new\\s+response\\s+(?<commentId>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                foodMenuForAdminController.addNewResponse(matcher.group("commentId"), matcher.group("message"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+response\\s+(?<commentId>\\S+)\\s+(?<message>\\S+)\\s*$")) != null) {
                foodMenuForAdminController.editResponse(matcher.group("commentId"), matcher.group("message"));
            }else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}