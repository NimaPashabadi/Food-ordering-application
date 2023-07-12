package controller;

import model.DataBase.DataBase;
import model.Order;
import model.Restaurant;
import view.Menu;

public class DeliveryMenuController {
    public DeliveryMenuController() {
    }
    public void showOrdersWithoutDelivery(){
        for (Restaurant restaurant : DataBase.getRestaurants()) {
            for (Order order : restaurant.getOrders()) {
                if(!order.isDoesHasDelivery()){
                    System.out.println(order.getId() + order.getRestaurant().getName() + restaurant.getId());
                }
            }
        }
    }
    public void selectOrder(){
        int id = Menu.getScanner().nextInt();
        int idForOrder = Menu.getScanner().nextInt();
        DataBase.getRestaurantById(id).getOrderById(idForOrder).setDelivery(DataBase.getCurrentDelivery());
        DataBase.getRestaurantById(id).getOrderById(idForOrder).setDoesHasDelivery(true);
    }
    public void showDistance(){
        DataBase.getCurrentDelivery().getUsername();
    }
}
