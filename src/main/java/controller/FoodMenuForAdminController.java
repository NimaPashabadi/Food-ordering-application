package controller;

import model.Comment;
import model.DataBase.DataBase;
import model.Rate;
import model.Response;

public class FoodMenuForAdminController {
    public FoodMenuForAdminController() {
    }

    public void showRating() {
        System.out.println("RATES ARE:");
        for (Rate rate : DataBase.getCurrentFoodForAdmin().getRates()) {
            System.out.println(rate.getOutOfFive()+"    "+ rate.getId());
        }
    }

    public void displayComments() {
        for (Comment comment : DataBase.getCurrentFoodForAdmin().getComments()) {
            System.out.println(comment.getComment() + "   " + comment.getId());
        }
    }



    public void addNewResponse(String commentId, String message) {
        int id = Integer.parseInt(commentId);
        Response response = new Response(message, id);
        DataBase.getCurrentFoodForAdmin().getCommentById(id).setResponse(response);
        DataBase.getCurrentAdmin().addResponse(response);
        response.setComment(DataBase.getCurrentFoodForAdmin().getCommentById(id));
        System.out.println("RESPONSE SENT SUCCESSFULLY");
    }

    public void editResponse(String commentId, String newMessage) {
        int id = Integer.parseInt(commentId);
        DataBase.getCurrentFoodForAdmin().getCommentById(id).getResponse().setFeedback(newMessage);
        System.out.println("RESPONSE EDITED SUCCESSFULLY");
    }
}
