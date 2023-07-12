package model;

import java.net.CookieManager;
import java.util.ArrayList;

public class Response {
    private String feedback;
    private ArrayList<Response> responses;
    private int commentId;
    private Admin admin;
    private Comment comment;

    public Response(String feedback, int commentId) {
        this.feedback = feedback;
        this.responses = responses;
        this.commentId = commentId;

        this.admin = admin;
        this.comment = comment;
    }

    public String getFeedback() {
        return feedback;
    }



    public int getCommentId() {
        return commentId;
    }



    public Admin getAdmin() {
        return admin;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
