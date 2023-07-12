package controller;

import model.Comment;
import model.DataBase.DataBase;
import model.Food;
import model.Rate;
import view.Menu;

public class RestaurantMenuForUserController {
    public void showFoodMenuOfRestaurant(){
        for (Food food : DataBase.getCurrentRestaurantForUser().getMenu()) {
            System.out.println(food.getName() +" "+food.getCost()+"T "+ food.getId());
        }
    }
    public void showRestaurantsComment(){
        for (Comment comment : DataBase.getCurrentRestaurantForUser().getComments()) {
            System.out.println(comment.getComment()+"   "+comment.getId());
        }
    }
    public void addNewComment(){
        System.out.println("ADD YOUR COMMENT:");
        String commentText = Menu.getScanner().nextLine();
        Comment comment = new Comment(commentText);
        DataBase.getCurrentRestaurantForUser().addComment(comment);
        comment.setUser(DataBase.getCurrentUser());
        System.out.println("COMMENT SEND SUCCESSFULLY");
    }
    public void editComment(String commentId){
        System.out.println("EDIT YOUR COMMENT:");
        int id = Integer.parseInt(commentId);
        String commentText = Menu.getScanner().nextLine();
        if(DataBase.getCurrentRestaurantForUser().getCommentById(id).getUser().getUsername().equals(DataBase.getCurrentUser().getUsername())){
            DataBase.getCurrentRestaurantForUser().getCommentById(id).setComment(commentText);
            System.out.println("COMMENT EDITED SUCCESSFULLY");
        }
        else System.out.println("YOU CAN ONLY EDIT YOUR OWN COMMENT");
    }
    public void showRating() {
        System.out.println("RATES ARE:");
        for (Rate rate : DataBase.getCurrentRestaurantForUser().getRates()) {
            System.out.println(rate.getOutOfFive() +"  "+rate.getId());
        }
    }
    public void submitRating() {
        System.out.println("SUBMIT YOUR RATE");
        int newRate = Menu.getScanner().nextInt();
        Rate rate = new Rate(newRate);
        DataBase.getCurrentRestaurantForUser().addRate(rate);
        System.out.println("RATE SUBMITTED SUCCESSFULLY");
    }
    public void editRating(String id) {
        System.out.println("EDIT YOUR RATE:");
        int idd = Integer.parseInt(id);
        int newRate = Menu.getScanner().nextInt();
        DataBase.getCurrentRestaurantForUser().getRateById(idd).setOutOfFive(newRate);
        System.out.println("RATE EDITED SUCCESSFULLY");
    }
    public void showResponseOfAdmin(String id){
        System.out.println("RESPONSE OF ADMIN IS:");
        int idd = Integer.parseInt(id);
        System.out.println(DataBase.getCurrentRestaurantForUser().getCommentById(idd).getResponse().getFeedback());
    }
}
