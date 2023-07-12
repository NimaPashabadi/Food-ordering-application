package controller;

import model.DataBase.DataBase;
import model.Discount;
import model.Food;
import model.Order;
import model.ParentUser;
import view.Menu;

import java.security.PublicKey;

public class UserMenuController {

    public void showAllRestaurantsForUser() {
        DataBase.getAllRestaurantsName();
    }

    public void searchRestaurantName(String nameOfRestaurant) {
        DataBase.showSearchedRestaurants(nameOfRestaurant);
    }
    public void accessOrderHistory(){
        for (Order order : DataBase.getCurrentUser().getOrders()) {
            System.out.println(order.getId() +" "+ order.getCost()+"T");
        }
    }
    public void selectOrder(String orderId){
        int id = Integer.parseInt(orderId);
        System.out.println(DataBase.getCurrentUser().getOrderById(id).getCost() + DataBase.getCurrentUser().getOrderById(id).getRestaurant().getName());
        for (Food food : DataBase.getCurrentUser().getOrderById(id).getFoods()) {
            System.out.println(food.getName());
        }
    }
    public void displayCartStatus(){

        for (Food food : DataBase.getCurrentUser().getCart()) {
            System.out.println(food.getName()+" "+ food.getCostAfterDiscount()+"T" +"     " + food.getId() + "    ");
        }
        double n = 0;
        for (Food food : DataBase.getCurrentUser().getCart()) {
            n+= food.getCostAfterDiscount();
        }
        System.out.println("TOTAL IS: " + n+"T");
    }
    public void confirmOrder(){
        Order order = new Order();
        double n = 0;
        for (Food food : DataBase.getCurrentUser().getCart()) {
            n+=food.getCostAfterDiscount();
        }
        order.setCost(n);
        order.setFoods(DataBase.getCurrentUser().getCart());
        DataBase.getCurrentUser().addOrder(order);
        DataBase.getCurrentUser().setLastOrder(order);
        DataBase.getCurrentRestaurantForUser().addOrder(order);
        DataBase.getCurrentRestaurantForUser().setThereOrder(true);
        DataBase.getCurrentUser().setBudget(DataBase.getCurrentUser().getBudget() - DataBase.getCurrentUser().getLastOrder().getCost());
        System.out.println("ORDER CONFIRMED SUCCESSFULLY");
    }
    public void showEstimatedDeliveryTime(){
        System.out.println(DataBase.getCurrentUser().getLastOrder().getTime());
    }
    public void chargeAccount(){
        System.out.println("PLEASE INPUT YOUR AMOUNT OF CHARGE");
        double charge = Menu.getScanner().nextDouble();
        DataBase.getCurrentUser().setBudget(DataBase.getCurrentUser().getBudget() + charge);
        System.out.println("CHARGED SUCCESSFULLY");
    }
    public void suggestRestaurant(){
        for (Order order : DataBase.getCurrentUser().getOrders()) {
            System.out.println(order.getRestaurant().getName());
        }
    }
    public void showChargeAccount(){
        System.out.println(DataBase.getCurrentUser().getBudget());
    }
    public void incentivePlan(){
        if(DataBase.getCurrentUser().getOrders().size()>=10){
            Discount discount = new Discount(25, 10);
            DataBase.getCurrentUser().addDiscount(discount);
        }
        for (Discount discount : DataBase.getCurrentUser().getDiscounts()) {
            System.out.println(discount.getPrice());
        }
    }
}
