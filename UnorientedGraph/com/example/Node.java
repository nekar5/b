package com.example;

import java.util.ArrayList;

public class Node {
    int value; //значення
    ArrayList<Node> connections; //список зв'язків

    public Node(int value) {
        this.value = value;
        connections = new ArrayList<>();
    }

    //додавання ребра (з ребром n)
    public boolean addEdge(Node n) {
        if(!connections.contains(n)) {
            connections.add(n);
            return true;
        }
        return false;
    }

    //видалення ребра (з ребром n)
    public boolean removeEdge(Node n){
        if (connections.contains(n)){
            connections.remove(n);
            return true;
        }
        return false;
    }

    //перевірка зв'язку (з ребром n)
    public boolean isConnected(Node n){
        return connections.contains(n);
    }

    /*
    повертається значення true/false,
    це використовується у методах
    нашого класу графу (Graph.java)
     */

    @Override
    public String toString(){
        return "[Value:"+value+"]";
    }
}
