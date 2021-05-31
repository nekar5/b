package com.example;

import java.util.*;

public class Graph { //unoriented
    ArrayList<Node> nodes;
    int nodeAmount=0;

    public Graph(){
        nodes = new ArrayList<>();
    }

    public Node getNode(int index){
        if(nodes.get(index)!=null) {
            return nodes.get(index);
        }
        return null;
    }

    public void addNode(Node n){
        if(nodes.isEmpty()){
            nodes.add(n);
            nodeAmount++;
        }
    }

    public void addNode(Node n1, Node n2){
        if(nodes.contains(n1)) {
            if(n1.addEdge(n2)&&n2.addEdge(n1)) {
                nodes.add(n2);
                nodeAmount++;
            }
        }
    }

    public void connectNodes(Node n1, Node n2){
        if(nodes.contains(n1)&&nodes.contains(n2)) {
            if(n1.addEdge(n2))
                n2.addEdge(n1);
        }
    }

    public void connectNodes(int index1, Node n){
        if(nodes.get(index1)!=null) {
            connectNodes(nodes.get(index1), n);
        }
    }

    public boolean removeNode(Node n){
        if(nodes.contains(n)) {
            n.connections = null;
            nodeAmount--;
            return true;
        }
        return false;
    }

    public boolean removeNode(int index){
        if(nodes.get(index)!=null) {
            Node temp = nodes.get(index);
            for(Node n: temp.connections){
                n.connections.remove(temp);
            }
            temp.connections = null;
            nodeAmount--;
            return true;
        }
        return false;
    }

    public static void bfsIterative(Node startNode) {

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode.value);

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.value+"|");

            for (Node n : currentNode.connections) {
                if (!visited.contains(n.value)) {
                    queue.add(n);
                    visited.add(n.value);
                }
            }
        }
    }

    public static void dfsIterative(Node startNode) {
        Stack<Node> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            if (!visited.contains(currentNode.value)) {
                System.out.print(currentNode.value+"|");
                visited.add(currentNode.value);
            }

            for (Node n : currentNode.connections) {
                if (!visited.contains(n.value)) {
                    stack.push(n);
                }
            }
        }
    }

    public static void dfsRecursive(Node startNode, Set<Integer> visited) {
        System.out.print(startNode.value + "|");
        visited.add(startNode.value);

        for (Node n : startNode.connections) {
            if (!visited.contains(n.value)) {
                dfsRecursive(n, visited);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node n1: nodes) {
            s.append(n1.value + ": ");
            for (Node n2: nodes) {
                s.append((n1.isConnected(n2) ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
