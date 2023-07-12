package view;

import controller.FoodMenuForUserController;
import model.DataBase.DataBase;
import model.Food;

import java.util.regex.Matcher;

public class FoodMenuForUser {
    private FoodMenuForUserController foodMenuForUserController;

    public FoodMenuForUser() {
        foodMenuForUserController = new FoodMenuForUserController();
    }

    public void run(Food food) {
        System.out.println("WELCOME TO "+DataBase.getCurrentFoodForUser().getName() + " MENU");
        String command;
        Matcher matcher;
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to restaurant menu\\s*$")) return;
            else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+comments\\s*$")) != null) {
                foodMenuForUserController.showComments();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+new\\s+comment\\s*$")) != null) {
                foodMenuForUserController.addNewComment();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+comment\\s+(?<commentId>\\S+)\\s*$")) != null) {
                foodMenuForUserController.editComment(matcher.group("commentId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+rating\\s*$")) != null) {
                foodMenuForUserController.showRating();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*submit\\s+rating\\s*$")) != null) {
                foodMenuForUserController.submitRating();
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+rating\\s+(?<ratingId>\\S+)\\s*$")) != null) {
                foodMenuForUserController.editRating(matcher.group("ratingId"));
            }else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+admin\\s+response\\s+(?<ratingId>\\S+)\\s*$")) != null) {
                foodMenuForUserController.showResponseOfAdmin(matcher.group("ratingId"));
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+this\\s+food\\s+to\\s+cart\\s*$")) != null) {
                foodMenuForUserController.addThisFoodToCart();
            }else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}
