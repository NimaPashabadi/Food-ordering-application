package model;

import java.util.Random;

public class Comment {
    private int id;
    private Random random = new Random();
    private String comment;
    private Response response;
    private User user;

    public Comment(String comment) {
        this.id = random.nextInt(100000);
        this.comment = comment;
        this.user  = user;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }


    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
