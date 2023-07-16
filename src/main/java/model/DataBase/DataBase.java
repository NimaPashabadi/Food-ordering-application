package model.DataBase;

import model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class DataBase {
    private static Admin currentAdmin;
    private static User currentUser;
    private static Restaurant currentRestaurantForAdmin;
    private static Restaurant currentRestaurantForUser;
    private static ArrayList<ParentUser> parentUsers = new ArrayList<>();
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();
    private static Food currentFoodForAdmin;
    private static Food currentFoodForUser;
    private static Delivery currentDelivery;

    public static Food getCurrentFoodForUser() {
        return currentFoodForUser;
    }

    public static void setCurrentFoodForUser(Food currentFoodForUser) {
        DataBase.currentFoodForUser = currentFoodForUser;
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static void setRestaurants(ArrayList<Restaurant> restaurants) {
        DataBase.restaurants = restaurants;
    }

    public static void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public static ArrayList<ParentUser> getParentUsers() {
        return parentUsers;
    }

    public static void setParentUsers(ArrayList<ParentUser> parentUsers) {
        DataBase.parentUsers = parentUsers;
    }

    public static ArrayList<Admin> getAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        for (ParentUser parentUser : parentUsers) {
            if (parentUser instanceof Admin) {
                admins.add((Admin) parentUser);
            }
        }
        return admins;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (ParentUser parentUser : parentUsers) {
            if (parentUser instanceof User) {
                users.add((User) parentUser);
            }
        }
        return users;
    }

    public static ArrayList<Delivery> getDelivery() {
        ArrayList<Delivery> deliveries = new ArrayList<>();
        for (ParentUser parentUser : parentUsers) {
            if (parentUser instanceof Delivery) {
                deliveries.add((Delivery) parentUser);
            }
        }
        return deliveries;
    }

    public static Admin getAdminByUsername(String username) {
        for (Admin admin : getAdmins()) {
            if (admin.getUsername().equals(username))
                return admin;
        }
        return null;
    }

    public static User getUserByUsername(String username) {
        for (User user : getUsers()) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public static Delivery getDeliveryByUsername(String username) {
        for (Delivery delivery : getDelivery()) {
            if (delivery.getUsername().equals(username))
                return delivery;
        }
        return null;
    }

    public static void addAdmin(String username, String password, String securityQuestion, String securityAnswer) {
        Admin admin = new Admin(username, password, securityQuestion, securityAnswer);
        add(admin);
    }

    public static void addUser(String username, String password, String securityQuestion, String securityAnswer) {
        User user = new User(username, password, securityQuestion, securityAnswer);
        add(user);
    }

    public static void addDelivery(String username, String password, String securityQuestion, String securityAnswer) {
        User user = new User(username, password, securityQuestion, securityAnswer);
        add(user);
    }

    public static void add(ParentUser parentUser) {
        parentUsers.add(parentUser);
    }

    public static void update(Admin admin) {
        for (ParentUser parentUser : parentUsers) {
            if (parentUser instanceof Admin && parentUser.getUsername().equals(admin.getUsername())) {
                parentUser = admin;
                return;
            }
        }
    }

    public static void update(User user) {
        for (ParentUser parentUser : parentUsers) {
            if (parentUser instanceof User && parentUser.getUsername().equals(user.getUsername())) {
                parentUser = user;
                return;
            }
        }
    }

    public static Admin getCurrentAdmin() {
        return currentAdmin;
    }

    public static void setCurrentAdmin(Admin currentAdmin) {
        DataBase.currentAdmin = currentAdmin;
    }

    public static Restaurant getCurrentRestaurantForAdmin() {
        return currentRestaurantForAdmin;
    }

    public static void setCurrentRestaurantForAdmin(Restaurant currentRestaurantForAdmin) {
        DataBase.currentRestaurantForAdmin = currentRestaurantForAdmin;
    }

    public static Restaurant getCurrentRestaurantForUser() {
        return currentRestaurantForUser;
    }

    public static void setCurrentRestaurantForUser(Restaurant currentRestaurantForUser) {
        DataBase.currentRestaurantForUser = currentRestaurantForUser;
    }

    public static Restaurant getRestaurantByNameInCurrentAdmin(String name) {
        for (Restaurant restaurant : currentAdmin.getRestaurants()) {
            if (restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    public static Restaurant getRestaurantByIdInCurrentUser(int id) {
        for (Restaurant restaurant : currentAdmin.getRestaurants()) {
            if (restaurant.getId() == id) {
                return restaurant;
            }
        }
        return null;
    }

    public static void getAllRestaurantsName() {
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName() + " " + restaurant.getId());
        }
    }

    public static Food getCurrentFoodForAdmin() {
        return currentFoodForAdmin;
    }

    public static void setCurrentFoodForAdmin(Food currentFoodForAdmin) {
        DataBase.currentFoodForAdmin = currentFoodForAdmin;
    }

    public static void showSearchedRestaurants(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(name)) {
                System.out.println(restaurant.getName() + " " + restaurant.getId());
            }
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        DataBase.currentUser = currentUser;
    }

    public static Delivery getCurrentDelivery() {
        return currentDelivery;
    }

    public static void setCurrentDelivery(Delivery currentDelivery) {
        DataBase.currentDelivery = currentDelivery;
    }

    public static Restaurant getRestaurantById(int id) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == id) return restaurant;
        }
        return null;
    }
    /*public void fromJSON() throws IOException {
        JsonObject usersDBJson;
        Gson gson = new Gson();
        FileReader usersJSON = new FileReader(pathToUsersDBJsonFile);
        this.user = gson.fromJson(usersJSON, new TypeToken<List<User>>(){}.getType());
        usersJSON.close();
    }

    public void toJSON() throws IOException {
        Gson gson = new Gson();
        FileWriter usersJSON = new FileWriter(pathToUsersDBJsonFile);
        String jsonData = gson.toJson(this.users, new TypeToken<List<User>>(){}.getType());
        BufferedWriter writer = new BufferedWriter(usersJSON);
        writer.write(jsonData);
        writer.close();
    } */

    public static int[][] getMapMatrix() {
        File file = new File("graph.txt");
        int[][] MapMatrix = new int[1001][1001];
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            ArrayList<String> MapS = new ArrayList<>();
            while (scanner.hasNextLine()) {
                MapS.add(scanner.nextLine().trim());
            }
            MapS.remove(0);

            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    MapMatrix[i][j] = 0;
                }
            }
            for (int i = 0; i < 2509; i++) {
                String[] parts = MapS.get(i).split("\\s");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                int length = Integer.parseInt(parts[2]);
                MapMatrix[x][y] = length;
                MapMatrix[y][x] = length;
            }
            return MapMatrix;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
