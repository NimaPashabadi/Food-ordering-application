package controller;

import model.*;
import model.DataBase.DataBase;
import view.Menu;

import java.util.ArrayList;

public class RestaurantMenuForAdminController {
    public RestaurantMenuForAdminController() {
    }

    public void showRestaurantLocation() {
        System.out.println(DataBase.getCurrentRestaurantForAdmin().getLocation().getName());
    }

    public void editRestaurantLocation(String nodeName) {
        DataBase.getCurrentRestaurantForAdmin().setLocation(DataBase.geNodeByName(nodeName));
    }

    public void determineRestaurantFoodType() {
        System.out.println("PLEASE DETERMINE YOUR RESTAURANT FOOD TYPE");
        String s = Menu.getScanner().nextLine();
        FoodType foodType = new FoodType(s);
        DataBase.getCurrentRestaurantForAdmin().addFoodType(foodType);
        System.out.println("FOOD TYPE DETERMINED SUCCESSFULLY");
    }

    public void showRestaurantFoodType() {
        for (FoodType foodType : DataBase.getCurrentRestaurantForAdmin().getRestaurantType()) {
            System.out.println(foodType.getName());
        }
    }


    public void editRestaurantFoodType() {
        if (DataBase.getCurrentRestaurantForAdmin().isThereOrder()) {
            System.out.println("THERE IS AN ACTIVE ORDER");
        } else {
            System.out.println("ARE YOU SURE YOU WANT TO CHANGE YOUR RESTAURANT TYPE?");
            String yesOrNo = Menu.getScanner().nextLine();
            if (yesOrNo.equals("yes")) {
                String input = "";
                ArrayList<FoodType> foodTypes = new ArrayList<>();
                System.out.println("ADD RESTAURANT FOOD TYPE");
                while (true) {
                    input = Menu.getScanner().nextLine();
                    if (input.equals("end")) break;
                    foodTypes.add(new FoodType(input));
                }
                System.out.println("RESTAURANT TYPE CHANGED SUCCESSFULLY");
                DataBase.getCurrentRestaurantForAdmin().setRestaurantType(foodTypes);
                DataBase.getCurrentRestaurantForAdmin().getMenu().clear();
                ArrayList<Food> foods = new ArrayList<>();
                String food = "";
                String cost = "";
                System.out.println("CREATE YOUR RESTAURANT MENU");
                while (true) {
                    food = Menu.getScanner().nextLine();
                    if (food.equals("end")) {
                        break;
                    }
                    cost = Menu.getScanner().nextLine();
                    double cost1 = Double.parseDouble(cost);
                    Food food1 = new Food(food, cost1);
                    foods.add(food1);
                }
                System.out.println("MENU CREATED SUCCESSFULLY");
                DataBase.getCurrentRestaurantForAdmin().setMenu(foods);
            }
        }
    }

    public void selectMenuOfRestaurant() {
        DataBase.getCurrentRestaurantForAdmin().selectMenuForShowingFoods();
    }

    public void editFoodName(String foodId, String newName) {
        int id = Integer.parseInt(foodId);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setName(newName);
        System.out.println("NAME CHANGED SUCCESSFULLY");
    }

    public void editFoodPrice(String foodId, String newPrice) {
        int id = Integer.parseInt(foodId);
        double cost = Double.parseDouble(newPrice);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setCost(cost);
        System.out.println("PRICE CHANGED SUCCESSFULLY");
    }

    public void addFoodToRestaurant(String name, String price) {
        double cost = Double.parseDouble(price);
        DataBase.getCurrentRestaurantForAdmin().addFoodToMenu(new Food(name, cost));
        System.out.println("FOOD ADDED TO RESTAURANT MENU SUCCESSFULLY");
    }


    public void deleteFoodFromRestaurant(String foodId) {
        int id = Integer.parseInt(foodId);
        System.out.println("ARE YOU SURE YOU WANT TO DELETE THIS FOOD?");
        String yesOrNo = Menu.getScanner().nextLine();
        if (yesOrNo.equals("yes")) {
            if (!DataBase.getCurrentRestaurantForAdmin().isThereOrder()) {
                DataBase.getCurrentRestaurantForAdmin().getMenu().remove(DataBase.getCurrentRestaurantForAdmin().getFoodById(id));
                System.out.println("FOOD DELETED SUCCESSFULLY");
            } else {
                System.out.println("THERE IS ACTIVE ORDER YOU CAN NOT DELETE THIS FOOD");
            }
        }
    }


    public void deactivateFoodFromRestaurant(String foodId) {
        int id = Integer.parseInt(foodId);
        if (!DataBase.getCurrentRestaurantForAdmin().isThereOrder()) {
            DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setActive(false);
            System.out.println("FOOD DEACTIVATED SUCCESSFULLY");
        } else {
            System.out.println("THERE IS ACTIVE ORDER YOU CAN NOT DEACTIVATE THIS FOOD");
        }
    }

    public void activeFoodFromRestaurant(String foodId) {
        int id = Integer.parseInt(foodId);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setActive(true);
        System.out.println("FOOD ACTIVATED SUCCESSFULLY");
    }

    public void discountFood(String foodId, String discountPercent, String timestamp) {
        int id = Integer.parseInt(foodId);
        double discountAmount = Double.parseDouble(discountPercent);
        double time = Double.parseDouble(timestamp);
        Discount discount = new Discount(discountAmount, time);
        if (DataBase.getCurrentRestaurantForAdmin().getFoodById(id).isThereDiscount()) {
            System.out.println("YOU CAN NOT ADD ANOTHER DISCOUNT");
        } else {
            if (discount.getPrice() <= 50) {
                DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setDiscount(discount);
                DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setThereDiscount(true);
                System.out.println("DISCOUNT ADDED SUCCESSFULLY");
            }
        }
    }

    public void deleteDiscountFood(String foodId) {
        int id = Integer.parseInt(foodId);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).getDiscount().setPrice(0);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).getDiscount().setTime(0);
        DataBase.getCurrentRestaurantForAdmin().getFoodById(id).setThereDiscount(false);
        System.out.println("DISCOUNT DELETED SUCCESSFULLY");
    }

    public void displayOnlineOrders() {
        for (Order order : DataBase.getCurrentRestaurantForAdmin().getOnlineOrder()) {
            System.out.println(order.getId() + " " + order.getCost());
            for (Food food : order.getFoods()) {
                System.out.println(food.getName() + " " + food.getCost());
            }
        }
    }

    public void editOnlineOrder(String orderId) {
        int id = Integer.parseInt(orderId);
        System.out.println("ARE YOU SURE THAT YOU WANT CHANGE ORDER TIME?");
        String string = Menu.getScanner().nextLine();
        if (string.equals("yse")) {
            System.out.println("PLEASE ENTER NEW TIME FOR THIS ORDER!");
            double s = Menu.getScanner().nextDouble();
            DataBase.getCurrentRestaurantForAdmin().getOnlineOrderById(id).setTime(s);
        }
    }

    public void showOrderHistory() {
        for (Order allOrder : DataBase.getCurrentRestaurantForAdmin().getAllOrders()) {
            System.out.println(allOrder.getId() + "  " + allOrder.getCost());
        }
    }

    public void displayComments() {
        for (Comment comment : DataBase.getCurrentRestaurantForAdmin().getComments()) {
            System.out.println(comment.getComment() + "   " + comment.getId());
        }
    }

    public void displayRating() {
        for (Rate rate : DataBase.getCurrentRestaurantForAdmin().getRates()) {
            System.out.println(rate.getOutOfFive() + "    " + rate.getId());
        }
    }

    public void addNewResponse(String commentId, String message) {
        int id = Integer.parseInt(commentId);
        Response response = new Response(message, id);
        DataBase.getCurrentRestaurantForAdmin().getCommentById(id).setResponse(response);
        DataBase.getCurrentAdmin().addResponse(response);
        response.setComment(DataBase.getCurrentRestaurantForAdmin().getCommentById(id));
        System.out.println("RESPONSE SENT SUCCESSFULLY");
    }

    public void editResponse(String commentId, String newMessage) {
        int id = Integer.parseInt(commentId);
        DataBase.getCurrentRestaurantForAdmin().getCommentById(id).getResponse().setFeedback(newMessage);
        System.out.println("RESPONSE EDITED SUCCESSFULLY");
    }

    public void showResponseOfComment(String commentId) {
        int id = Integer.parseInt(commentId);
        System.out.println(DataBase.getCurrentRestaurantForAdmin().getCommentById(id).getResponse().getFeedback());
    }

}