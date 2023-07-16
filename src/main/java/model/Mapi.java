package model;

import java.util.ArrayList;

public class Mapi {
    private static ArrayList<Mapi> allMapis = new ArrayList<>();

    public ArrayList<Mapi> getAllMaps() {
        return allMapis;
    }

    public void setAllMaps(ArrayList<Mapi> m) {
        allMapis = m;
    }

    public Mapi(int a) {
        node = a;
        allMapis.add(this);
    }

    public int getNode() {
        return node;
    }

    public void setNode(int a) {
        node = a;
    }

    public Mapi findMapi(int a) {
        for (int i = 0; i < allMapis.size(); i++) {
            if (allMapis.get(i).node == a) {
                return allMapis.get(i);
            }
        }
        return null;
    }
    public String showLocation(){
        String list = "";
        list = list+ "you are located at "+node;
        return list;
    }
    private int node;
}
