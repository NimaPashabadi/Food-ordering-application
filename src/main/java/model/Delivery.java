package model;

import java.util.ArrayList;

public class Delivery extends ParentUser {
    private ArrayList<Order> ordersWithOutDelivery;

    public Delivery(String username, String password, String securityQuestion, String securityAnswer, ArrayList<Order> ordersWithOutDelivery) {
        super(username, password, securityQuestion, securityAnswer);
        this.ordersWithOutDelivery = ordersWithOutDelivery;
    }

}
