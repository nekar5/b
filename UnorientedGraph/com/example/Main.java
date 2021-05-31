package com.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        fillGraph(graph);//функція для заповнення графу

        System.out.println("Вершини графу:");
        for(int i=0; i<graph.nodeAmount; i++){
            System.out.print(graph.getNode(i));
        }
        System.out.println("\n");

        System.out.println("[Перевірка на з'єднаність вершин]"+
        " Візьмемо вершину 10 (зв'язана з : 7  9  15  19):");
        graph.getNode(10).connections.stream().map(n -> n.value + "  ").forEach(System.out::print);
        System.out.println("\n");

        System.out.println("[Breadth First Search (BFS) Iterative:]");
        long start = System.nanoTime();
        Graph.bfsIterative(graph.getNode(0));
        long finish = System.nanoTime();
        System.out.println("\nЧас: "+ (finish - start));
        System.out.println("\n");

        System.out.println("[Depth First Search (DFS) Iterative:]");
        start = System.nanoTime();
        Graph.dfsIterative(graph.getNode(0));
        finish = System.nanoTime();
        System.out.println("\nЧас: "+ (finish - start));
        System.out.println("\n");

        System.out.println("[Depth First Search (DFS) Recursive:]");
        start = System.nanoTime();
        Graph.dfsRecursive(graph.getNode(0), new HashSet<>());
        finish = System.nanoTime();
        System.out.println("\nЧас: "+ (finish - start));
        System.out.println("\n");

        System.out.println("Матриця суміжності:");
        System.out.println(graph.toString());


    }

    public static void fillGraph(Graph g){
        //створюємо вершини
        Node[] nodes = new Node[25];
        for (int i = 0; i < 25; i++) {
            Node n = new Node(i);
            nodes[i]=n;
        }

        //додаємо першу у граф
        g.addNode(nodes[0]);

        //створюємо зв'язки між вершинами (ребра) й додаємо нові
        /*
        g.addNode(nodes[0], nodes[2]);
        g.addNode(nodes[0], nodes[1]);
        g.addNode(nodes[2], nodes[3]);
        g.addNode(nodes[2], nodes[4]);
        g.addNode(nodes[1], nodes[6]);
        g.addNode(nodes[1], nodes[7]);
        g.addNode(nodes[3], nodes[12]);
        g.connectNodes(nodes[4], nodes[12]);
        g.addNode(nodes[3], nodes[11]);
        g.connectNodes(nodes[4], nodes[11]);
        g.addNode(nodes[2], nodes[5]);
        g.addNode(nodes[5], nodes[10]);
        g.addNode(nodes[6], nodes[8]);
        g.connectNodes(nodes[7], nodes[8]);
        g.addNode(nodes[8], nodes[9]);
        g.connectNodes(nodes[8], nodes[10]);
        g.addNode(nodes[1], nodes[13]);
        g.connectNodes(nodes[10], nodes[13]);
        g.addNode(nodes[12], nodes[14]);
        g.addNode(nodes[12], nodes[17]);
        g.addNode(nodes[17], nodes[18]);
        g.addNode(nodes[17], nodes[22]);
        g.connectNodes(nodes[18], nodes[22]);
        g.addNode(nodes[13], nodes[15]);
        g.addNode(nodes[13], nodes[16]);
        g.connectNodes(nodes[15], nodes[16]);
        g.addNode(nodes[16], nodes[20]);
        g.addNode(nodes[20], nodes[21]);
        g.addNode(nodes[20], nodes[19]);
        g.connectNodes(nodes[19], nodes[22]);

         */
        long start = System.nanoTime();
        g.addNode(nodes[0], nodes[1]);
        g.addNode(nodes[0], nodes[2]);
        g.addNode(nodes[0], nodes[3]);
        g.addNode(nodes[0], nodes[4]);
        g.addNode(nodes[2], nodes[8]);
        g.addNode(nodes[2], nodes[7]);
        g.connectNodes(nodes[3], nodes[7]);
        g.addNode(nodes[3], nodes[6]);
        g.addNode(nodes[3], nodes[5]);
        g.connectNodes(nodes[4], nodes[5]);
        g.addNode(nodes[8], nodes[9]);
        g.connectNodes(nodes[7], nodes[9]);
        g.addNode(nodes[7], nodes[10]);
        g.connectNodes(nodes[9], nodes[10]);
        g.addNode(nodes[5], nodes[11]);
        g.addNode(nodes[11], nodes[12]);
        g.addNode(nodes[12], nodes[13]);
        g.addNode(nodes[13], nodes[19]);
        g.addNode(nodes[13], nodes[20]);
        g.addNode(nodes[20], nodes[21]);
        g.connectNodes(nodes[19], nodes[21]);
        g.addNode(nodes[9], nodes[15]);
        g.connectNodes(nodes[10], nodes[15]);
        g.connectNodes(nodes[10], nodes[19]);
        g.addNode(nodes[19], nodes[18]);
        g.addNode(nodes[15], nodes[16]);
        g.addNode(nodes[15], nodes[17]);
        g.addNode(nodes[17], nodes[14]);
        g.addNode(nodes[16], nodes[22]);
        g.connectNodes(nodes[14], nodes[19]);
        long finish = System.nanoTime();
        System.out.println("\nЧас додавання 30 елементів: "+ (finish - start));

    }
}