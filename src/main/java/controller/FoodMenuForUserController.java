package controller;

import model.Comment;
import model.DataBase.DataBase;
import model.Rate;
import view.Menu;

import javax.swing.plaf.metal.MetalDesktopIconUI;

public class FoodMenuForUserController {
    public void showComments() {
        System.out.println("COMMENTS ARE:");
        for (Comment comment : DataBase.getCurrentFoodForUser().getComments()) {
            System.out.println(comment.getComment() + "   " + comment.getId());
        }
    }

    public void addNewComment() {
        System.out.println("ADD YOUR COMMENT:");
        String commentText = Menu.getScanner().nextLine();
        Comment comment = new Comment(commentText);
        DataBase.getCurrentFoodForUser().addComment(comment);
        comment.setUser(DataBase.getCurrentUser());
        System.out.println("COMMENT SEND SUCCESSFULLY");
    }

    public void editComment(String commentId) {
        System.out.println("EDIT YOUR COMMENT:");
        int id = Integer.parseInt(commentId);
        String commentText = Menu.getScanner().nextLine();
        if (DataBase.getCurrentFoodForUser().getCommentById(id).getUser().getUsername().equals(DataBase.getCurrentUser().getUsername())) {
            DataBase.getCurrentFoodForUser().getCommentById(id).setComment(commentText);
            System.out.println("COMMENT EDITED SUCCESSFULLY");
        } else System.out.println("YOU CAN ONLY EDIT YOUR OWN COMMENT");
    }

    public void showRating() {
        System.out.println("RATES ARE:");
        for (Rate rate : DataBase.getCurrentFoodForUser().getRates()) {
            System.out.println(rate.getOutOfFive());
        }
    }

    public void submitRating() {
        System.out.println("SUBMIT YOUR RATE");
        int newRate = Menu.getScanner().nextInt();
        Rate rate = new Rate(newRate);
        DataBase.getCurrentFoodForUser().addRating(rate);
        System.out.println("RATE SUBMITTED SUCCESSFULLY");
    }

    public void editRating(String id) {
        System.out.println("EDIT YOUR RATE:");
        int idd = Integer.parseInt(id);
        int newRate = Menu.getScanner().nextInt();
        DataBase.getCurrentFoodForUser().getRateById(idd).setOutOfFive(newRate);
        System.out.println("RATE EDITED SUCCESSFULLY");
    }

    public void addThisFoodToCart() {
        if(DataBase.getCurrentFoodForUser().isActive()){
            DataBase.getCurrentFoodForUser().setCostAfterDiscount(DataBase.getCurrentFoodForUser().getCost()-DataBase.getCurrentFoodForUser().getDiscount().getPrice());
            DataBase.getCurrentUser().addFoodToCart(DataBase.getCurrentFoodForUser());
            System.out.println("FOOD ADDED SUCCESSFULLY");
        }else System.out.println("THIS FOOD IS NOT ACTIVE");
    }

    public void showResponseOfAdmin(String id) {
        System.out.println("RESPONSE OF ADMIN IS:");
        int idd = Integer.parseInt(id);
        System.out.println(DataBase.getCurrentFoodForUser().getCommentById(idd).getResponse().getFeedback());
    }
}
