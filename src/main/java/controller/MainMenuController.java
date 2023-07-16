package controller;

import model.Admin;
import model.DataBase.DataBase;
import model.Delivery;
import model.User;
import view.MainMenu;
import view.AdminMenu;
import view.LoginMenu;
import view.UserMenu;
import view.DeliveryMenu;

public class MainMenuController {
    private User loggedInUser;
    private Admin loggedInAdmin;
    private Delivery loggedInDelivery;
    private final LoginMenu loginMenu;
    private final AdminMenu adminMenu;
    private final MainMenu mainMenu;
    private final UserMenu userMenu;
    private final DeliveryMenu deliveryMenu;


    public boolean isLoggedInUser() {
        return loggedInUser != null;
    }

    public MainMenuController() {
        loginMenu = new LoginMenu(this);
        userMenu = new UserMenu();
        deliveryMenu = new DeliveryMenu();
        mainMenu = new MainMenu(this);
        adminMenu = new AdminMenu();
    }

    public void run() {
        loginMenu.run();

        while (true) {
            switch (mainMenu.run()) {
                case "admin menu":
                    adminMenu.run();
                    System.out.println("NOW YOU ARE IN MAIN MENU");
                    break;
                case "user menu":
                    userMenu.run();
                    System.out.println("NOW YOU ARE IN MAIN MENU");
                    break;
                case "delivery menu":
                    deliveryMenu.run();
                    System.out.println("NOW YOU ARE IN MAIN MENU");
                    break;
                case "logout":
                    loginMenu.run();
                    break;
            }

        }
    }


    public String register(String role, String username, String password, String securityQuestion, String securityAnswer) {
        if (role.equals("USER") && DataBase.getUserByUsername(username) != null)
            return "REGISTER FAILED: USERNAME ALREADY EXISTS";
        if (role.equals("ADMIN") && DataBase.getAdminByUsername(username) != null)
            return "REGISTER FAILED: USERNAME ALREADY EXISTS";
        if (role.equals("DELIVERY") && DataBase.getDeliveryByUsername(username) != null)
            return "REGISTER FAILED: USERNAME ALREADY EXISTS";
        if (password.length() < 5 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*[0-9].*"))
            return "REGISTER FAILED: PASSWORD IS WEAK";
        if (role.equals("ADMIN"))
            DataBase.addAdmin(username, password, securityQuestion, securityAnswer);
        else if (role.equals("USER"))
            DataBase.addUser(username, password, securityQuestion, securityAnswer);
        else if (role.equals("DELIVERY"))
            DataBase.addDelivery(username, password, securityQuestion, securityAnswer);
        else
            return "REGISTER FAILED: INVALID ROLE!";
        return "REGISTER SUCCESSFUL";
    }

    public String login(String role, String username, String password) {
        if (role.equals("USER") && (loggedInUser = DataBase.getUserByUsername(username)) != null) {
            if (!loggedInUser.isPasswordCorrect(password)) {
                loggedInUser = null;
                return "LOGIN FAILED: INCORRECT PASSWORD!";
            }
            DataBase.setCurrentUser(loggedInUser);
            return "LOGGED IN SUCCESSFULLY AS AN USER";
        } else if (role.equals("ADMIN") && (loggedInAdmin = DataBase.getAdminByUsername(username)) != null) {
            if (!loggedInAdmin.isPasswordCorrect(password)) {
                loggedInAdmin = null;
                return "LOGIN FAILED: INCORRECT PASSWORD!";
            }
            DataBase.setCurrentAdmin(loggedInAdmin);
            return "LOGGED IN SUCCESSFULLY AS AN ADMIN";
        } else if (role.equals("DELIVERY") && (loggedInDelivery = DataBase.getDeliveryByUsername(username)) != null) {
            if (!loggedInAdmin.isPasswordCorrect(password)) {
                loggedInDelivery = null;
                return "LOGIN FAILED: INCORRECT PASSWORD!";
            }
            return "LOGGED IN SUCCESSFULLY AS A DELIVERY";
        } else
            return "LOGIN FAILED: USER NOT FOUND!";
    }

    public String forgetPassword(String role, String username, String securityAnswer, String newPassword) {
        if (role.equals("USER") && DataBase.getUserByUsername(username) == null)
            return "CHANGE FAILED: USERNAME DOES NOT EXISTS";
        if (role.equals("ADMIN") && DataBase.getAdminByUsername(username) == null)
            return "CHANGE FAILED: USERNAME DOES NOT EXISTS";
        if (role.equals("DELIVERY") && DataBase.getDeliveryByUsername(username) == null)
            return "CHANGE FAILED: USERNAME DOES NOT EXISTS";
        if (role.equals("USER") && DataBase.getUserByUsername(username).getSecurityAnswer().equals(securityAnswer)) {
            if (newPassword.length() < 5 || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[0-9].*"))
                return "REGISTER FAILED: PASSWORD IS WEAK";
            else DataBase.getUserByUsername(username).setPassword(newPassword);
        }
        if (role.equals("ADMIN") && DataBase.getAdminByUsername(username).getSecurityAnswer().equals(securityAnswer)) {
            if (newPassword.length() < 5 || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[0-9].*"))
                return "REGISTER FAILED: PASSWORD IS WEAK";
            else DataBase.getAdminByUsername(username).setPassword(newPassword);
        }
        if (role.equals("DELIVERY") && DataBase.getDeliveryByUsername(username).getSecurityAnswer().equals(securityAnswer)) {
            if (newPassword.length() < 5 || !newPassword.matches(".*[A-Z].*") || !newPassword.matches(".*[a-z].*") || !newPassword.matches(".*[0-9].*"))
                return "REGISTER FAILED: PASSWORD IS WEAK";
            else DataBase.getDeliveryByUsername(username).setPassword(newPassword);
        }
        return "PASSWORD CHANGED SUCCESSFULLY";
    }

    public String logout() {
        loggedInUser = null;
        loggedInAdmin = null;
        return "LOGOUT SUCCESSFUL";
    }
}