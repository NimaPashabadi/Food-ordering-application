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
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+new\\s+comment\\s*$")) != null) {
                foodMenuForUserController.addNewComment();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+comment\\s+(?<commentId>\\S+)\\s*$")) != null) {
                foodMenuForUserController.editComment(matcher.group("commentId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*display\\s+rating\\s*$")) != null) {
                foodMenuForUserController.showRating();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*submit\\s+rating\\s*$")) != null) {
                foodMenuForUserController.submitRating();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*edit\\s+rating\\s+(?<ratingId>\\S+)\\s*$")) != null) {
                foodMenuForUserController.editRating(matcher.group("ratingId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            }else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+admin\\s+response\\s+(?<ratingId>\\S+)\\s*$")) != null) {
                foodMenuForUserController.showResponseOfAdmin(matcher.group("ratingId"));
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*add\\s+this\\s+food\\s+to\\s+cart\\s*$")) != null) {
                foodMenuForUserController.addThisFoodToCart();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            }else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}
