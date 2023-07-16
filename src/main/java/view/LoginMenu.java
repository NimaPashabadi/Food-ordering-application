package view;

import controller.MainMenuController;

import java.util.regex.Matcher;

public class LoginMenu {
    private MainMenuController mainMenuController;

    public LoginMenu(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    public void run() {
        Matcher matcher;
        String command;
        System.out.println("WELCOME TO LOGIN MENU!");
        while (true) {
            command = Menu.getScanner().nextLine();
            if (command.matches("\\s*(e|E)(x|X)(i|I)(T|t)\\s*")){
                System.out.println("BYE!");
                return ;
            }
            if ((matcher = Menu.getMatcher(command, "^\\s*(ADD|add|Add)\\s+(?<role>\\S+)\\s+(?<username>\\S+)\\s+(?<password>\\S+)\\s+(?<securityQuestion>\\S+)\\s+(?<securityAnswer>\\S+)\\s*$")) != null) {
                System.out.println(mainMenuController.register(
                        matcher.group("role"),
                        matcher.group("username"),
                        matcher.group("password"),
                        matcher.group("securityQuestion"),
                        matcher.group("securityAnswer")));

            } else if ((matcher = Menu.getMatcher(command, "^\\s*(LOGIN|Login|login)\\s+(?<role>\\S+)\\s+(?<username>\\S+)\\s+(?<password>\\S+)\\s*$")) != null) {
                String output = mainMenuController.login(
                        matcher.group("role"),
                        matcher.group("username"),
                        matcher.group("password"));
                System.out.println(output);
                if (output.equals("LOGGED IN SUCCESSFULLY AS A DELIVERY")||output.equals("LOGGED IN SUCCESSFULLY AS AN ADMIN")||output.equals("LOGGED IN SUCCESSFULLY AS AN USER")){
                    return;
                }
            } else if ((matcher = Menu.getMatcher(command, "^\\s*(FORGET|Forget|forget)\\s+(PASSWORD|Password|password)\\s+(?<role>\\S+)\\s+(?<username>\\S+)\\s+(?<securityAnswer>\\S+)\\s+(?<newPassword>\\S+)\\s*$")) != null) {
                System.out.println(mainMenuController.forgetPassword(
                        matcher.group("role"),
                        matcher.group("username"),
                        matcher.group("securityAnswer"),
                        matcher.group("newPassword")));
            } else {
                System.out.println("INVALID COMMAND!");
            }
        }
    }
}