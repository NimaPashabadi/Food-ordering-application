package view;
import controller.DeliveryMenuController;
import controller.MainMenuController;
import model.DataBase.DataBase;

import java.util.regex.Matcher;

public class DeliveryMenu {
    private DeliveryMenuController deliveryMenuController;

    public DeliveryMenu() {
        deliveryMenuController = new DeliveryMenuController();
    }
    public void run(){
        Matcher matcher;
        String command;
        System.out.println(DataBase.getCurrentDelivery().getUsername() + " WELCOME TO DELIVERY MENU");
        while (true){
            command = Menu.getScanner().nextLine();
            if (command.matches("^\\s*back to main menu\\s*$")) return;
            else if((matcher = Menu.getMatcher(command, "^\\s*show\\s+orders\\s+without\\s+delivery\\s*$"))!=null){
                deliveryMenuController.showOrdersWithoutDelivery();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            }
            else if((matcher = Menu.getMatcher(command, "^\\s*select\\s+order\\s*$"))!=null){
                deliveryMenuController.selectOrder();
                try{
                    DataBase.toJSON();
                }catch (Exception e){}
                try{
                    DataBase.toJSONForRestaurants();
                }catch (Exception e){}
            } else if ((matcher = Menu.getMatcher(command, "^\\s*show\\s+distance\\s*$"))!=null) {
                deliveryMenuController.showDistance();
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
