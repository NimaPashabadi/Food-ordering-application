import controller.MainMenuController;
import model.DataBase.DataBase;

public class Main {
    public static void main(String[] args) {
        new DataBase();

        try {
            DataBase.fromJSON();

        } catch (Exception e) {

        }
        try {
            DataBase.fromJSONForRestaurants();
        } catch (Exception t) {

        }
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.run();
    }
}