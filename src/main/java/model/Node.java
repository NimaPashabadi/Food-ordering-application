package model;

import java.util.ArrayList;

public class Node
{
    private int source;
    private String name;
    private ArrayList<Edge> edges;
    private ArrayList<Node> nodes;
    private int id;

    public int getSource() {
        return source;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
