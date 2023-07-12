package model;

import model.DataBase.DataBase;

public class ParentUser {
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    public ParentUser(String username, String password, String securityQuestion, String securityAnswer) {
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }
    public String getUsername() {
        return username;
    }
    private String getPassword() {
        return password;
    }
    public String getSecurityQuestion() {
        return securityQuestion;
    }
    public boolean isPasswordCorrect(String password) {
        return this.getPassword().equals(password);
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSecurityAnswer() {
        return securityAnswer;
    }
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }
}
